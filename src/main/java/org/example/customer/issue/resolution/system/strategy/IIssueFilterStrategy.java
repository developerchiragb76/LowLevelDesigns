package org.example.customer.issue.resolution.system.strategy;

import org.example.customer.issue.resolution.system.model.Issue;

import java.util.List;

public interface IIssueFilterStrategy {
    boolean doesSupport(String filterKey);
    List<Issue> filterIssues(List<Issue> allIssues, String filterValue);
}
