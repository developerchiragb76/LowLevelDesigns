package org.example.customer.issue.resolution.system.exception;

import org.example.customer.issue.resolution.system.model.IssueType;

public class UnsupportedIssueTypeException extends Throwable {
    public UnsupportedIssueTypeException(IssueType issueType) {
        super(String.valueOf(issueType));
    }
}
