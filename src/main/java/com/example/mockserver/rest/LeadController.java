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
    private ILeadService leadService;

    @PostMapping(value = "setLeadId")
    public ResponseEntity<Lead> setLeadId(@RequestBody Lead lead){
        leadService.update(lead.getLeadId());
        return new ResponseEntity<>(lead, HttpStatus.OK);
    }

    @GetMapping(value = "/lastLeadRequest")
    public ResponseEntity<Lead> readPastRequest() {
        Lead lead = leadService.readPast();
        return lead != null
                ? new ResponseEntity<>(lead, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
