package com.example.mockserver.rest;

import com.example.mockserver.model.Lead;
import com.example.mockserver.service.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ILeadService leadService;

    @GetMapping("/dao")
    public ResponseEntity<Lead> test() {
        Lead lead = new Lead();
        lead.setName("123");
        lead = leadService.save(lead);
        Lead lead2 = leadService.findById(lead.getId());
        return new ResponseEntity<>(lead2, HttpStatus.OK);
    }
}
