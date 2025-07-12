package org.example.customer.issue.resolution.system.strategy;

import org.example.customer.issue.resolution.system.exception.NoAgentsAvailableException;
import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;
import org.example.customer.issue.resolution.system.model.IssueType;

import java.util.List;

public interface IAgentIssueAssignStrategy {
    boolean doYouHandleIssue(IssueType issueType);
    Agent assignAgent(Issue issue, List<Agent> allAgents) throws NoAgentsAvailableException;
}
