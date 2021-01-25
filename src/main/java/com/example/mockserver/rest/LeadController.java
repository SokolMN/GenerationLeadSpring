package com.example.mockserver.rest;

import com.example.mockserver.model.Lead;
import com.example.mockserver.service.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class LeadController {

    @Autowired
    ILeadService leadService;

    @PostMapping(value = "setLeadId")
    public ResponseEntity<?> setLeadId(@RequestBody Lead lead){
        leadService.update(lead.getLeadId());
        return new ResponseEntity<>(lead, HttpStatus.OK);
    }

    @GetMapping("/dao")
    public ResponseEntity<Lead> test() {
        Lead lead = new Lead();
        lead.setName("123");
        lead.setMiddlename("");
        lead.setSurname("");
        lead.setEmail("");
        lead.setDate(Timestamp.valueOf(LocalDateTime.now()));
        lead.setInn("123456789");
        lead.setNeedCreatedFlag("Y");
        lead.setOrganizationName("Рога и копыта");
        lead.setPhoneNumber("79145678963");
        lead.setPhoneNumber2("79145678950");
        lead.setPosition("Самый главный дятел на районе");
        lead.setSegment("Привилегия");
        lead.setServiceOfficeId("858585");
        lead = leadService.save(lead);
        Lead lead2 = leadService.findById(lead.getId());
        return new ResponseEntity<>(lead2, HttpStatus.OK);
    }

    @GetMapping(value = "/lastLeadRequest")
    public ResponseEntity<Lead> readPastRequest() {
        Lead lead = leadService.readPast();
        return lead != null
                ? new ResponseEntity<>(lead, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
