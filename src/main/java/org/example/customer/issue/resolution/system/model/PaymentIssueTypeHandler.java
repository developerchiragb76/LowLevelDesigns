package org.example.customer.issue.resolution.system.model;

public class PaymentIssueTypeHandler implements IIssueTypeHandler {
    @Override
    public boolean doesHandle(IssueType issueType) {
        return IssueType.PAYMENT.equals(issueType);
    }
}
