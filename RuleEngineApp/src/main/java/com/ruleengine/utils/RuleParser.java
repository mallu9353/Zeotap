package com.ruleengine.utils;

import com.ruleengine.model.Node;

public class RuleParser {

    // Parses the rule string and builds the AST
    public static Node parse(String ruleString) {
        ruleString = ruleString.trim();

        // Handle parentheses (complex expressions)
        if (ruleString.startsWith("(")) {
            int balance = 0;
            int operatorIndex = -1;
            for (int i = 0; i < ruleString.length(); i++) {
                if (ruleString.charAt(i) == '(') balance++;
                if (ruleString.charAt(i) == ')') balance--;
                if (balance == 0 && (ruleString.contains("AND") || ruleString.contains("OR"))) {
                    if (ruleString.substring(i).startsWith("AND") || ruleString.substring(i).startsWith("OR")) {
                        operatorIndex = i;
                        break;
                    }
                }
            }

            if (operatorIndex != -1) {
                String left = ruleString.substring(1, operatorIndex).trim();
                String operator = ruleString.substring(operatorIndex, operatorIndex + 3).trim();
                String right = ruleString.substring(operatorIndex + 3).trim();
                return new Node(operator, parse(left), parse(right));
            }
        }

        // Handle basic AND/OR rules without parentheses
        if (ruleString.contains(" AND ") || ruleString.contains(" OR ")) {
            String[] tokens;
            String operator;
            if (ruleString.contains(" AND ")) {
                tokens = ruleString.split(" AND ", 2);
                operator = "AND";
            } else {
                tokens = ruleString.split(" OR ", 2);
                operator = "OR";
            }
            String left = tokens[0].trim();
            String right = tokens[1].trim();
            return new Node(operator, parse(left), parse(right));
        }

        // It's an operand (e.g., age > 30)
        return new Node(ruleString.trim());
    }
}
