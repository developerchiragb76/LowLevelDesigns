package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.exception.AgentNotFoundException;
import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;

import java.util.List;
import java.util.Map;

public interface IAgentRepository {
    void saveAgent(Agent agent);
    List<Agent> getAll();
    void addIssue(String agentId, Issue issue) throws AgentNotFoundException;
    Map<String, List<Issue>> getAgentWorkHistory();

    Issue getNextIssueFromWaitList(Agent agent);
}
