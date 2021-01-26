package com.example.mockserver.service;

import com.example.mockserver.model.Lead;
import com.example.mockserver.model.Status;
import com.example.mockserver.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * трололо
 */
public class LeadService implements ILeadService {
    public static String presetLeadId;
    public static String presetTaskId;

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public Lead save(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead findById(Long id) {
        return leadRepository.getOne(id);
    }

    @Override
    public Lead readPast() {
        List<Lead> leads = leadRepository.findAll();
        int allLeads = leadRepository.findAll().size();
        Lead lead = leads.get(allLeads - 1);
        return lead;
    }

    @Override
    public void update(String presetLeadId) {
        this.presetLeadId = presetLeadId;
    }

    @Override
    public Lead findLeadByLeadId(String leadId) {
        Lead lead = leadRepository.findByLeadId(leadId);
        return lead;
    }

    @Override
    public void upsertLead(Long id, String comment, String interectionType, String sourceManagerTabel,
                           String sourceManagerEmail, String sourceManagerPhoneNumber, String sourceManagerPhoneNumber2,
                           String sourceManagerName, String assisstantPhoneNumber, String assistantName, String contactId,
                           String actionId) {
        leadRepository.upsertLead(id, comment, interectionType, sourceManagerTabel, sourceManagerEmail, sourceManagerPhoneNumber,
                sourceManagerPhoneNumber2, sourceManagerName, assisstantPhoneNumber, assistantName, contactId, actionId);
    }

    public void setTaskId(String productOrderId) {

        /*Status status = statusRepository.findByProductOrderId(productOrderId);
        return status;*/
    }

}
