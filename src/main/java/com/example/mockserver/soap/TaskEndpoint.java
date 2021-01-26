package com.example.mockserver.soap;

import com.example.mockserver.model.Lead;
import com.example.mockserver.repository.LeadRepository;
import com.example.mockserver.service.ILeadService;
import com.siebel.asi3.Request;
import com.siebel.customui.SUBOCreateActionInput;
import com.siebel.customui.SUBOCreateActionOutput;
import com.siebel.xml.headerinfors2.HeaderInfo;
import com.siebel.xml.subocreateaction_output.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.mockserver.service.LeadService.presetTaskId;
import static com.example.mockserver.utils.GenerationUtils.randomCharUpperSequence;
import static com.example.mockserver.utils.GenerationUtils.randomFromTo;

@Endpoint
public class TaskEndpoint {
    private static final String NAMESPACE_URI = "http://siebel.com/CustomUI";

    @Autowired
    private ILeadService leadService;

    private LeadRepository leadRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SUBOCreateAction_Input")
    @ResponsePayload
    private SUBOCreateActionOutput getTask(@RequestPayload SUBOCreateActionInput request) throws IOException {
        Request rqst = request.getRequest();
        String taskId;
        if(presetTaskId == null) {
            taskId = "1-" + randomCharUpperSequence(6);
        }
        else {
            taskId = presetTaskId;
        }
        presetTaskId = null;
        Lead lead = leadService.findLeadByLeadId(rqst.getLeadId());
        Long leadId = selectId(lead);
        upsertLead(rqst, leadId, taskId);
        HashMap<String, String> errorCode = getErrorCode(rqst);
        SUBOCreateActionOutput response = createResponse(errorCode, taskId);
        return response;
    }

    private Lead selectLead(String leadId){
        return leadService.findLeadByLeadId(leadId);
    }

    private Long selectId(Lead lead){
        return lead.getId();
    }

/*    private Lead mappingRequest(Request rqst, String taskId){
        Lead lead = selectLead(rqst.getLeadId());
        lead.setComment(rqst.getComment());
        lead.setInterectionType(rqst.getInteractionType());
        lead.setSourceManagerTabel(rqst.getSourceManagerTabel());
        lead.setSourceManagerEmail(rqst.getSourceManagerEmail());
        lead.setSourceManagerPhoneNumber(rqst.getSourceManagerPhone1());
        lead.setSourceManagerPhoneNumber2(rqst.getSourceManagerPhone2());
        lead.setSourceManagerName(rqst.getSourceManagerName());
        lead.setAssisstantPhoneNumber(rqst.getAssisstantPhoneNumber());
        lead.setAssistantName(rqst.getAssistantName());
        lead.setContactId(rqst.getContactId());
        lead.setActionId(taskId);
        return lead;
    }*/

    private void upsertLead(Request rqst, Long leadId, String taskId){
        leadService.upsertLead(leadId, rqst.getComment(), rqst.getInteractionType(),
                rqst.getSourceManagerTabel(), rqst.getSourceManagerEmail(), rqst.getSourceManagerPhone1(),
                rqst.getSourceManagerPhone2(), rqst.getSourceManagerName(), rqst.getAssisstantPhoneNumber(),
                rqst.getAssistantName(), rqst.getContactId(), taskId);
    }

    //TODO: дописать все поля
    private HashMap<String, String> getErrorCode(Request request){
        HashMap<String, String> errorCode = new HashMap<>();
        errorCode.put("00", "Операция выполнена успешно");

        if (request.getSegment().length() > 50 || request.getFLLastName().length() > 50 ||
                request.getFLFirstName().length() > 50 || request.getFLMiddleName().length() > 50 ||
                request.getFLPhoneNumber().length() > 20 || request.getFLPhoneNumber2().length() > 20 ||
                request.getFLEmail().length() > 255 || request.getSource().length() > 10 ||
                request.getOrganizationName().length() > 255 || request.getINN().length() > 12 ||
                request.getFLPosition().length() > 255) {
            errorCode.clear();
            errorCode.put("01", "Ошибка при валидации входящего сообщения");
        }

        return errorCode;
    }

    private SUBOCreateActionOutput createResponse(HashMap<String, String> errorCode, String taskId){
        HeaderInfo headerInfo = new HeaderInfo();
        headerInfo.setRqUID(String.valueOf(randomFromTo(3, 1555)));

        List keyList = new ArrayList(errorCode.keySet());
        List valueList = new ArrayList(errorCode.values());

        headerInfo.setErrorCode((String) keyList.get(0));
        headerInfo.setErrorText(String.valueOf(valueList.get(0)));
        Response response = new Response();
        response.setActionId(taskId);
        SUBOCreateActionOutput suboCreateActionOutput = new SUBOCreateActionOutput();
        suboCreateActionOutput.setHeaderInfo(headerInfo);
        suboCreateActionOutput.setResponse(response);
        return suboCreateActionOutput;
    }


}
