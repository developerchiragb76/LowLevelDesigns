package org.example.customer.issue.resolution.system.model;

public class Transaction {
    private final String transactionId;
    private final IssueType issueType;
    private final IIssueTypeHandler transactionTypeData;

    public Transaction(String transactionId, IssueType issueType, IIssueTypeHandler transactionTypeData) {
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.transactionTypeData = transactionTypeData;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IIssueTypeHandler getTransactionTypeData() {
        return transactionTypeData;
    }
}
