package org.example.customer.issue.resolution.system.model;

import java.util.Date;

public class Issue {
    private String issueId;
    private Agent agent;
    private Customer createdBy;
    private Date createdDate;
    private Transaction transaction;
    private String issueDescription;
    private String issueSubject;
    private IssueState issueState;
    private String resolution;
    private final IssueType issueType;

    public Issue(String issueId, Customer createdBy, Transaction transaction, String issueDescription, String issueSubject) {
        this.issueId = issueId;
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.transaction = transaction;
        this.issueDescription = issueDescription;
        this.issueSubject = issueSubject;
        this.resolution = "";
        this.issueType = transaction.getIssueType();
    }

    public String getIssueId() {
        return issueId;
    }

    public IssueState getIssueState() {
        return issueState;
    }

    public String getResolution() {
        return resolution;
    }

    void assignAgent(Agent agent) {
        this.agent = agent;
    }

    public Agent getAgent() {
        return agent;
    }

    public Customer getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getIssueSubject() {
        return issueSubject;
    }

    public void updateIssueState(IssueState issueState) {
        this.issueState = issueState;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public IssueType getIssueType() {
        return issueType;
    }
}
