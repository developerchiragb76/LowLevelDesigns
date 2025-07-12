package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.model.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryIssueRepository implements IIssueRepository {
    private final Map<String, Issue> issueMap;

    public InMemoryIssueRepository() {
        issueMap = new HashMap<>();
    }

    @Override
    public void saveIssue(Issue issue) {
        issueMap.putIfAbsent(issue.getIssueId(), issue);
    }

    @Override
    public Issue getIssue(String issueId) {
        return issueMap.getOrDefault(issueId, null);
    }

    @Override
    public List<Issue> getAll() {
        return new ArrayList<>(issueMap.values());
    }
}
