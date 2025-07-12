package org.example.customer.issue.resolution.system.repository;

import org.example.customer.issue.resolution.system.model.Issue;

import java.util.List;

public interface IIssueRepository {
    void saveIssue(Issue issue);

    Issue getIssue(String issueId);

    List<Issue> getAll();
}
