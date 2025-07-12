package org.example.customer.issue.resolution.system.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Agent {
    private final String agentId;
    private final String agentEmail;
    private final String agentName;
    private boolean isOccupied;
    private final List<Issue> assignedIssues;
    private final List<IssueType> handleableIssueTypes;
    private final Queue<Issue> waitlist = new LinkedList<>();

    public Agent(String agentId, String agentEmail, String agentName, List<IssueType> handleableIssueTypes) {
        this.agentEmail = agentEmail;
        this.agentName = agentName;
        this.agentId = agentId;
        this.isOccupied = false;
        this.assignedIssues = new ArrayList<>();
        this.handleableIssueTypes = handleableIssueTypes;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void assignIssue(Issue issue) {
        this.setOccupied(true);
        issue.updateIssueState(IssueState.IN_PROGRESS);
        issue.assignAgent(this);
        assignedIssues.add(issue);
    }

    public List<Issue> getAssignedIssues() {
        return new ArrayList<>(assignedIssues);
    }

    public boolean canHandle(IssueType issueType) {
        return handleableIssueTypes.contains(issueType);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void addToWaitList(Issue issue) {
        waitlist.offer(issue);
    }

    public Issue getNextIssueFromWaitList() {
        return waitlist.poll();
    }
}
