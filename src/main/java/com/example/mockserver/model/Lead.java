package com.example.mockserver.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "lead")
@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp date;

    private String rqUID;

    private String name;

    private String surname;

    private String middlename;

    private String phoneNumber;

    private String email;

    private String phoneNumber2;

    private String suboLeadId;

    private String serviceOfficeId;

    private String source;

    private String organizationName;

    private String inn;

    private String position;

    private String needCreatedFlag;

    private String segment;

    private String leadId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getSuboLeadId() {
        return suboLeadId;
    }

    public void setSuboLeadId(String suboLeadId) {
        this.suboLeadId = suboLeadId;
    }

    public String getServiceOfficeId() {
        return serviceOfficeId;
    }

    public void setServiceOfficeId(String serviceOfficeId) {
        this.serviceOfficeId = serviceOfficeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNeedCreatedFlag() {
        return needCreatedFlag;
    }

    public void setNeedCreatedFlag(String needCreatedFlag) {
        this.needCreatedFlag = needCreatedFlag;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

}
