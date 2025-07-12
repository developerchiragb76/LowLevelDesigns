package org.example.customer.issue.resolution.system.service;

import org.example.customer.issue.resolution.system.exception.UnsupportedIssueTypeException;
import org.example.customer.issue.resolution.system.model.*;
import org.example.customer.issue.resolution.system.repository.IIssueRepository;
import org.example.customer.issue.resolution.system.strategy.IIssueFilterStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class IssueService {
    public final IIssueRepository issueRepository;
    private final CustomerService customerService;
    private final List<IIssueTypeHandler> transactionTypesData;
    private final List<IIssueFilterStrategy> issueFilterStrategies;

    public IssueService(IIssueRepository issueRepository, CustomerService customerService, List<IIssueTypeHandler> transactionTypesData, List<IIssueFilterStrategy> issueFilterStrategies) {
        this.issueRepository = issueRepository;
        this.customerService = customerService;
        this.transactionTypesData = transactionTypesData;
        this.issueFilterStrategies = issueFilterStrategies;
    }

    public String createIssue(String transactionId, IssueType issueType, String subject, String description, String customerEmail) throws UnsupportedIssueTypeException {
        IIssueTypeHandler transactionTypeData = transactionTypesData.stream()
                .filter(txnTypeData -> txnTypeData.doesHandle(issueType))
                .findFirst()
                .orElse(null);

        if(transactionTypeData == null) throw new UnsupportedIssueTypeException(issueType);

        Transaction transaction = new Transaction(transactionId, issueType, transactionTypeData);
        String issueId = UUID.randomUUID().toString();
        Customer customer = customerService.getCustomer(customerEmail);
        Issue issue = new Issue(issueId, customer, transaction, description, subject);
        issueRepository.saveIssue(issue);
        return issueId;
    }

    public Issue getIssue(String issueId) {
        return issueRepository.getIssue(issueId);
    }

    public void updateIssueState(String issueId, IssueState issueState) {
        Issue issue = issueRepository.getIssue(issueId);
        issue.updateIssueState(issueState);
        issueRepository.saveIssue(issue);
    }

    public Agent resolveIssue(String issueId, IssueState issueState, String resolved) {
        Issue issue = issueRepository.getIssue(issueId);
        Agent agent = issue.getAgent();
        if(!issue.getIssueState().equals(IssueState.RESOLVED)) {
            issue.setResolution(resolved);
            issue.updateIssueState(issueState);
            issueRepository.saveIssue(issue);
            return agent;
        }
        return null;
    }

    public List<Issue> getIssues(Map<String, String> issueFilterInput) {
        List<Issue> allIssues = issueRepository.getAll();
        for(Map.Entry<String, String> entry : issueFilterInput.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            for(IIssueFilterStrategy issueFilterStrategy : issueFilterStrategies) {
                if(issueFilterStrategy.doesSupport(key)) {
                    allIssues = issueFilterStrategy.filterIssues(allIssues, value);
                }
            }
        }

        return allIssues;
    }
}
