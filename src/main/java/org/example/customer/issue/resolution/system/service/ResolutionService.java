package org.example.customer.issue.resolution.system.service;

import org.example.customer.issue.resolution.system.exception.AgentNotFoundException;
import org.example.customer.issue.resolution.system.exception.NoAgentsAvailableException;
import org.example.customer.issue.resolution.system.exception.UnsupportedIssueTypeException;
import org.example.customer.issue.resolution.system.model.*;

import java.util.List;
import java.util.Map;

public class ResolutionService {
    /*
        createIssue(transactionId, issueType, subject, description, email)

        addAgent(agentEmail, agentName ,List)

        assignIssue(issueId) // -> Issue can be assigned to the agents based on different strategies.

        For now, assign to any one of the free agents.

        getIssues(filter) // -> issues against the provided filter
        updateIssue(issueId, status, resolution)
        resolveIssue(issueId, resolution)
        viewAgentsWorkHistory() // -> a list of issue which agents worked on Example: createIssue("T1", "Payment Related", "Payment Failed", "My payment failed but money is debited", "testUser1@test.com");
     */
    private AgentService agentService;
    private CustomerService customerService;
    private IssueService issueService;


    public String createIssue(String transactionId, IssueType issueType, String subject, String description, String customerEmail) throws UnsupportedIssueTypeException {
        return issueService.createIssue(transactionId, issueType, subject, description, customerEmail);
    }

    public String addAgent(String email, String name, List<IssueType> issueTypes) {
        return agentService.addAgent(email, name, issueTypes);
    }

    public Agent assignIssue(String issueId) throws UnsupportedIssueTypeException, AgentNotFoundException, NoAgentsAvailableException {
        Issue issue = issueService.getIssue(issueId);
        return agentService.assignAgent(issue);
    }


    public List<Issue> getIssues(Map<String, String> issueFilterInput) {
        return issueService.getIssues(issueFilterInput);
    }


    public void updateIssue(String issueId, IssueState issueState) {
        issueService.updateIssueState(issueId, issueState);
    }

    public void resolveIssue(String issueId) throws UnsupportedIssueTypeException, NoAgentsAvailableException, AgentNotFoundException {
        Agent agent = issueService.resolveIssue(issueId, IssueState.RESOLVED, "Resolved");
        Issue issue = agentService.getNextIssueFromWaitList(agent);
        if(issue != null) agent.assignIssue(issue);
    }


    public Map<String, List<Issue>> viewAgentsWorkHistory() {
        return agentService.viewAgentWorkHistory();
    }
}
