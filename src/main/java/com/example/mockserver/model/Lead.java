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

    private String taskServiceId;

    private String interectionType;

    //TODO: изменить тип данных, комментарий может не влезть
    private String comment;

    private String sourceManagerEmail;

    private String sourceManagerPhoneNumber;

    private String sourceManagerPhoneNumber2;

    private String sourceManagerName;

    private String sourceManagerLogin;

    private String sourceManagerTabel;

    private String assisstantPhoneNumber;

    private String assistantName;

    private String contactId;

    private String actionId;

    /*private String serviceManagerEmail;

    private String serviceManagerPhoneNumber;

    private String serviceManagerPhoneNumber2;

    private String serviceManagerName;

    private String serviceManagerLogin;

    private String serviceManagerTabel;*/

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

    public String getTaskServiceId() {
        return taskServiceId;
    }

    public void setTaskServiceId(String taskServiceId) {
        this.taskServiceId = taskServiceId;
    }

    public String getInterectionType() {
        return interectionType;
    }

    public void setInterectionType(String interectionType) {
        this.interectionType = interectionType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSourceManagerEmail() {
        return sourceManagerEmail;
    }

    public void setSourceManagerEmail(String sourceManagerEmail) {
        this.sourceManagerEmail = sourceManagerEmail;
    }

    public String getSourceManagerPhoneNumber() {
        return sourceManagerPhoneNumber;
    }

    public void setSourceManagerPhoneNumber(String sourceManagerPhoneNumber) {
        this.sourceManagerPhoneNumber = sourceManagerPhoneNumber;
    }

    public String getSourceManagerPhoneNumber2() {
        return sourceManagerPhoneNumber2;
    }

    public void setSourceManagerPhoneNumber2(String sourceManagerPhoneNumber2) {
        this.sourceManagerPhoneNumber2 = sourceManagerPhoneNumber2;
    }

    public String getSourceManagerName() {
        return sourceManagerName;
    }

    public void setSourceManagerName(String sourceManagerName) {
        this.sourceManagerName = sourceManagerName;
    }

    public String getSourceManagerLogin() {
        return sourceManagerLogin;
    }

    public void setSourceManagerLogin(String sourceManagerLogin) {
        this.sourceManagerLogin = sourceManagerLogin;
    }

    public String getSourceManagerTabel() {
        return sourceManagerTabel;
    }

    public void setSourceManagerTabel(String sourceManagerTabel) {
        this.sourceManagerTabel = sourceManagerTabel;
    }

    public String getAssisstantPhoneNumber() {
        return assisstantPhoneNumber;
    }

    public void setAssisstantPhoneNumber(String assisstantPhoneNumber) {
        this.assisstantPhoneNumber = assisstantPhoneNumber;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }


    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

}
