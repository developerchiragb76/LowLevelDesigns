package org.example.splitwise;

import org.example.splitwise.command.Command;
import org.example.splitwise.command.ExpenseCommandParser;
import org.example.splitwise.command.ICommandParser;
import org.example.splitwise.command.ShowCommandParser;
import org.example.splitwise.exceptions.UnSupportedCommandTypeException;
import org.example.splitwise.exceptions.UnSupportedSplitMetaDataForExpenseType;
import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.models.BalanceSheet;
import org.example.splitwise.models.User;
import org.example.splitwise.repository.IExpenseRepository;
import org.example.splitwise.repository.IUserRepository;
import org.example.splitwise.repository.InMemoryExpenseRepository;
import org.example.splitwise.repository.InMemoryUserRepository;
import org.example.splitwise.service.ExpenseService;
import org.example.splitwise.strategy.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitWiseDriver {
    public static void main(String[] args) {
        IUserRepository userRepository = new InMemoryUserRepository();
        IExpenseRepository expenseRepository = new InMemoryExpenseRepository();
        BalanceSheet balanceSheet = new BalanceSheet();

        // --- Step 2: Create and save users ---
        userRepository.saveUser(new User("u1", "User1"));
        userRepository.saveUser(new User("u2", "User2"));
        userRepository.saveUser(new User("u3", "User3"));
        userRepository.saveUser(new User("u4", "User4"));

        // --- Step 3: Setup strategies and parsers ---
        List<ISplitStrategy> splitStrategies = Arrays.asList(
                new EqualSplitStrategy(),
                new ExactSplitStrategy(),
                new PercentSplitStrategy()
        );

        List<ISplitMetaDataParser> splitMetaDataParsers = Arrays.asList(
                new EqualSplitMetaDataParser(),
                new ExactSplitMetaDataParser(),
                new PercentSplitMetaDataParser()
        );

        // --- Step 4: Setup service and command parser ---
        ExpenseService expenseService = new ExpenseService(
                expenseRepository,
                userRepository,
                splitStrategies,
                balanceSheet
        );

        List<ICommandParser> commandParsers = Arrays.asList(
                new ExpenseCommandParser(userRepository, expenseService, splitMetaDataParsers),
                new ShowCommandParser(expenseService)
        );

        Command command = new Command(commandParsers);

        // --- Step 5: Take input ---
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands (type EXIT to quit):");
        while (true) {
            String input = scanner.nextLine().trim();
            if(input.isEmpty()) continue;
            if (input.equalsIgnoreCase("EXIT")) break;

            try {
                command.parseCommand(input);
            } catch (UserNotFoundException | UnSupportedCommandTypeException |
                     UnSupportedSplitMetaDataForExpenseType | IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }

        scanner.close();
    }
}
