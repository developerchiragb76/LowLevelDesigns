package org.example.customer.issue.resolution.system.strategy;

import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;
import org.example.customer.issue.resolution.system.model.IssueType;

import java.util.List;

public class PaymentIssueAgentAssignStrategy implements IAgentIssueAssignStrategy {
    @Override
    public boolean doYouHandleIssue(IssueType issueType) {
        return IssueType.PAYMENT.equals(issueType);
    }

    @Override
    public Agent assignAgent(Issue issue, List<Agent> allAgents) {
        allAgents.stream().filter(agent -> agent.get)
    }
}
