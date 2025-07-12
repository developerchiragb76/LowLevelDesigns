package org.example.customer.issue.resolution.system.model;

public class MutualFundIssueTypeHandler implements IIssueTypeHandler {
    @Override
    public boolean doesHandle(IssueType issueType) {
        return IssueType.MUTUAL_FUND.equals(issueType);
    }
}
