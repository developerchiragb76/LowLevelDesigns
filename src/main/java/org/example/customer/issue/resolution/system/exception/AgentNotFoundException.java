package org.example.customer.issue.resolution.system.exception;

public class AgentNotFoundException extends Throwable {
    public AgentNotFoundException(String agentId) {
        super(agentId);
    }
}
