package org.example.customer.issue.resolution.system.service;

import org.example.customer.issue.resolution.system.exception.AgentNotFoundException;
import org.example.customer.issue.resolution.system.exception.NoAgentsAvailableException;
import org.example.customer.issue.resolution.system.exception.UnsupportedIssueTypeException;
import org.example.customer.issue.resolution.system.model.Agent;
import org.example.customer.issue.resolution.system.model.Issue;
import org.example.customer.issue.resolution.system.model.IssueState;
import org.example.customer.issue.resolution.system.model.IssueType;
import org.example.customer.issue.resolution.system.repository.IAgentRepository;
import org.example.customer.issue.resolution.system.strategy.IAgentIssueAssignStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AgentService {
    private IAgentRepository agentRepository;
    private List<IAgentIssueAssignStrategy> agentIssueAssignStrategies;

    public String addAgent(String email, String name, List<IssueType> issueTypes) {
        String agentId = UUID.randomUUID().toString();
        Agent agent = new Agent(agentId, email, name, issueTypes);
        agentRepository.saveAgent(agent);
        return agentId;
    }

    public Agent assignAgent(Issue issue) throws UnsupportedIssueTypeException, AgentNotFoundException, NoAgentsAvailableException {
        List<Agent> allAgents = agentRepository.getAll();
        IAgentIssueAssignStrategy agentIssueAssignStrategy = agentIssueAssignStrategies.stream()
                .filter(strategy -> strategy.doYouHandleIssue(issue.getIssueType())).findFirst().orElse(null);

        if(agentIssueAssignStrategy == null) throw new UnsupportedIssueTypeException(issue.getTransaction().getIssueType());

        List<Agent> agents = agentRepository.getAll();
        Agent agent = agentIssueAssignStrategy.assignAgent(issue, agents);
        agentRepository.addIssue(agent.getAgentId(), issue);
        issue.updateIssueState(IssueState.IN_PROGRESS);
        return agent;
    }

    public Map<String, List<Issue>> viewAgentWorkHistory() {
        return agentRepository.getAgentWorkHistory();
    }

    public Issue getNextIssueFromWaitList(Agent agent) {
        return agentRepository.getNextIssueFromWaitList(agent);
    }
}
