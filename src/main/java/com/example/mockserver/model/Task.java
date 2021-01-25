package com.example.mockserver.model;

import javax.persistence.*;

@Table(name = "task")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String suboLeadId;
    private String leadId;
    private String contactId;
    private String serviceOfficeId;


    public String getSuboLeadId() {
        return suboLeadId;
    }

    public void setSuboLeadId(String suboLeadId) {
        this.suboLeadId = suboLeadId;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

}
