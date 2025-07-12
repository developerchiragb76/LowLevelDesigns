package org.example.customer.issue.resolution.system.strategy;

import org.example.customer.issue.resolution.system.exception.NoAgentsAvailableException;
import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;
import org.example.customer.issue.resolution.system.model.IssueType;

import java.util.List;

public class MutualFundIssueAgentAssignStrategy implements IAgentIssueAssignStrategy {
    @Override
    public boolean doYouHandleIssue(IssueType issueType) {
        return IssueType.MUTUAL_FUND.equals(issueType);
    }

    @Override
    public Agent assignAgent(Issue issue, List<Agent> allAgents) throws NoAgentsAvailableException {
        Agent pickAgent = allAgents.stream()
                .filter(agent -> agent.canHandle(issue.getIssueType()) && !agent.isOccupied()).findFirst().orElse(null);
        if(pickAgent != null) {
            pickAgent.assignIssue(issue);
            return pickAgent;
        }

        for(Agent agent : allAgents) {
            if(agent.canHandle(issue.getIssueType())) {
                agent.addToWaitList(issue);
                break;
            }
        }
        return null;
    }
}
