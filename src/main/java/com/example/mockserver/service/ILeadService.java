package com.example.mockserver.service;


import com.example.mockserver.model.Lead;

public interface ILeadService {
    Lead save (Lead lead);

    Lead findById(Long id);
}
