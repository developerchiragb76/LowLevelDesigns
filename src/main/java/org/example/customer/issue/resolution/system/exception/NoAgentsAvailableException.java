package org.example.customer.issue.resolution.system.exception;

import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.IssueType;

public class NoAgentsAvailableException extends Throwable {
    public NoAgentsAvailableException(IssueType issueType) {
        super(String.valueOf(issueType));
    }
}
