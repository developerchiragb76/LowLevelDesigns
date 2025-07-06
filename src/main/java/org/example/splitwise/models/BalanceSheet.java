package org.example.splitwise.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private final Map<String, Map<String, Amount>> balanceSheetMap;

    public BalanceSheet() {
        balanceSheetMap = new HashMap<>();
    }

    public Map<String, Map<String, Amount>> getBalanceSheet() {
        return balanceSheetMap;
    }

    public Map<String, Amount> getUserBalance(String userId) {
        return balanceSheetMap.get(userId);
    }

    public void updateBalance(String fromUser, String toUser, double amount) {
        balanceSheetMap.putIfAbsent(fromUser, new HashMap<>());
        balanceSheetMap.get(fromUser).putIfAbsent(toUser, new Amount(Currency.INR, 0));

        balanceSheetMap.get(fromUser).get(toUser).addBalance(amount);

        balanceSheetMap.putIfAbsent(toUser, new HashMap<>());
        balanceSheetMap.get(toUser).putIfAbsent(fromUser, new Amount(Currency.INR, 0));
        balanceSheetMap.get(toUser).get(fromUser).addBalance(-amount);
    }
}
