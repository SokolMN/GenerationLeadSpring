package com.example.mockserver.service;

import com.example.mockserver.model.Lead;
import com.example.mockserver.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * трололо
 */
public class LeadService implements ILeadService {

    @Autowired
    LeadRepository leadRepository;

    @Override
    public Lead save(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead findById(Long id) {
        return leadRepository.getOne(id);
    }
}
