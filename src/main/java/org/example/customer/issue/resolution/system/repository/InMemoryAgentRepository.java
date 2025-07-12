package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.exception.AgentNotFoundException;
import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryAgentRepository implements IAgentRepository {
    private final Map<String, Agent> agentIssuesMap;

    public InMemoryAgentRepository() {
        agentIssuesMap = new HashMap<>();
    }

    @Override
    public void saveAgent(Agent agent) {
        agentIssuesMap.putIfAbsent(agent.getAgentId(), agent);
    }

    @Override
    public List<Agent> getAll() {
        return new ArrayList<>(agentIssuesMap.values());
    }

    @Override
    public void addIssue(String agentId, Issue issue) throws AgentNotFoundException {
        Agent a = agentIssuesMap.getOrDefault(agentId, null);
        if(a == null) throw new AgentNotFoundException(agentId);
        a.assignIssue(issue);
        saveAgent(a);
    }

    @Override
    public Map<String, List<Issue>> getAgentWorkHistory() {
        return agentIssuesMap.values().stream()
                .collect(Collectors.toMap(Agent::getAgentId, Agent::getAssignedIssues, (a, b) -> a));
    }

    @Override
    public Issue getNextIssueFromWaitList(Agent agent) {
        return agent.getNextIssueFromWaitList();
    }
}
