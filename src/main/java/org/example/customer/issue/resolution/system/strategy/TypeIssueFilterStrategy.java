package org.example.customer.issue.resolution.system.strategy;

import org.example.customer.issue.resolution.system.model.Issue;

import java.util.List;

public class TypeIssueFilterStrategy implements IIssueFilterStrategy {
    @Override
    public boolean doesSupport(String filterKey) {
        return "type".equalsIgnoreCase(filterKey);
    }

    @Override
    public List<Issue> filterIssues(List<Issue> allIssues, String filterValue) {
        return allIssues.stream()
                .filter(issue -> issue.getIssueType().toString().equalsIgnoreCase(filterValue))
                .toList();
    }
}
