package com.example.mockserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productOrderId;
    private Integer leadId;
    private String status;
    private String updateDate;
    private String segment;
    private Integer serviceOfficeId;
    private String reason;
    private String serviceManagerTabel;
    private String mdmId;
    private String flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductOrderId() { return productOrderId; }

    public void setProductOrderId(String productOrderId) {this.productOrderId = productOrderId;}

    public Integer getLeadId(){ return leadId; }

    public void setLeadId(Integer leadId) { this.leadId = leadId; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {this.status = status; }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) { this.updateDate = updateDate; }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public Integer getServiceOfficeId() {return serviceOfficeId;}

    public void setServiceOfficeId(Integer serviceOfficeId){this.serviceOfficeId = serviceOfficeId; }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getServiceManagerTabel() {
        return serviceManagerTabel;
    }

    public void setServiceManagerTabel(String serviceManagerTabel) {
        this.serviceManagerTabel = serviceManagerTabel;
    }

    public String mdmId() {
        return mdmId;
    }

    public void mdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public String getFlag() { return flag; }

    public void setFlag(String flag) { this.flag = flag; }
}
