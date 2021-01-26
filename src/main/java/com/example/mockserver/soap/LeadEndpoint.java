package com.example.mockserver.soap;

import com.example.mockserver.model.Lead;
import com.example.mockserver.repository.LeadRepository;
import com.example.mockserver.service.ILeadService;
import com.siebel.asi.HeaderInfo;
import com.siebel.asi2.Request;
import com.siebel.customui.VTBSpcFindOrCreateLeadInput;
import com.siebel.customui.VTBSpcFindOrCreateLeadOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.mockserver.service.LeadService.presetLeadId;
import static com.example.mockserver.utils.GenerationUtils.randomCharUpperSequence;
import static com.example.mockserver.utils.GenerationUtils.randomFromTo;

@Endpoint
public class LeadEndpoint {
    private static final String NAMESPACE_URI = "http://siebel.com/CustomUI";

    @Autowired
    private ILeadService leadService;

    private LeadRepository leadRepository;

    private LeadEndpoint(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VTB_spcFindOrCreateLead_Input")
    @ResponsePayload
    private VTBSpcFindOrCreateLeadOutput getLead(@RequestPayload VTBSpcFindOrCreateLeadInput request) throws IOException {
        Request rqst = request.getRequest();
        String leadID;
        if (presetLeadId == null) {
            leadID = "1-" + randomCharUpperSequence(6);
        }
        else{
            leadID = presetLeadId;
        }
        presetLeadId = null;
        Lead lead = mappingRequest(rqst, leadID);
        insert(lead);
        HashMap<String, String> errorCode = getErrorCode(rqst);
        VTBSpcFindOrCreateLeadOutput response = createResponse(errorCode, leadID);

        return response;
    }

    private Lead mappingRequest(Request rqst, String leadId){
        Lead lead = new Lead();
        lead.setServiceOfficeId(rqst.getServiceOfficeId());
        lead.setSegment(rqst.getSegment());
        lead.setPosition(rqst.getPosition());
        lead.setPhoneNumber(rqst.getPhone());
        lead.setNeedCreatedFlag(rqst.getNeedCreateLead());
        lead.setInn(rqst.getINN());
        lead.setOrganizationName(rqst.getOrganizationName());
        lead.setDate(Timestamp.valueOf(LocalDateTime.now()));
        lead.setEmail(rqst.getEmail());
        lead.setSurname(rqst.getLastName());
        lead.setMiddlename(rqst.getMiddleName());
        lead.setName(rqst.getFirstName());
        lead.setPhoneNumber2(rqst.getPhone2());
        lead.setSuboLeadId(rqst.getSuboLeadId());
        lead.setSource(rqst.getSource());
        lead.setLeadId(leadId);
        return lead;
    }

    private void insert(Lead lead){
        leadService.save(lead);
    }

    private VTBSpcFindOrCreateLeadOutput createResponse(HashMap<String, String> errorCode, String leadId){
        com.siebel.asi3.Lead lead = new com.siebel.asi3.Lead();
        lead.setLeadId(leadId);
        com.siebel.xml.headerinfors.HeaderInfo headerInfo = new com.siebel.xml.headerinfors.HeaderInfo();
        headerInfo.setRqUID(String.valueOf(randomFromTo(3, 1555)));

        List keyList = new ArrayList(errorCode.keySet());
        List valueList = new ArrayList(errorCode.values());

        headerInfo.setErrorCode((String) keyList.get(0));
        headerInfo.setErrorText(String.valueOf(valueList.get(0)));

        VTBSpcFindOrCreateLeadOutput vtbSpcFindOrCreateLeadOutput = new VTBSpcFindOrCreateLeadOutput();
        vtbSpcFindOrCreateLeadOutput.setHeaderInfo(headerInfo);
        vtbSpcFindOrCreateLeadOutput.setLead(lead);
        return vtbSpcFindOrCreateLeadOutput;
    }

    private HashMap<String, String> getErrorCode(Request request){
        HashMap<String, String> errorCode = new HashMap<>();
        errorCode.put("00", "Операция выполнена успешно");

        if (request.getSegment().length() > 50 || request.getLastName().length() > 50 ||
                request.getFirstName().length() > 50 || request.getMiddleName().length() > 50 ||
                request.getPhone().length() > 20 || request.getPhone2().length() > 20 ||
                request.getEmail().length() > 255 || request.getSource().length() > 10 ||
                request.getOrganizationName().length() > 255 || request.getINN().length() > 12 ||
                request.getPosition().length() > 255) {
            errorCode.clear();
            errorCode.put("01", "Ошибка при валидации входящего сообщения");
        }

        return errorCode;
    }
}
