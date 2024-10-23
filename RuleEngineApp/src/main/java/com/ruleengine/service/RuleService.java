package com.ruleengine.service;

import com.ruleengine.model.Node;
import com.ruleengine.utils.RuleParser;

import java.util.Map;

public class RuleService {

    // Creates a rule from the string
    public Node createRule(String rule) {
        return RuleParser.parse(rule);
    }

    // Evaluates a rule node against provided data
    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node.getCondition() != null) {
            // Handle operand condition evaluation
            return evaluateCondition(node.getCondition(), data);
        }

        // Handle logical operation
        boolean leftResult = evaluateRule(node.getLeft(), data);
        boolean rightResult = evaluateRule(node.getRight(), data);

        return node.getOperator().equals("AND") ? leftResult && rightResult : leftResult || rightResult;
    }

    // Evaluates a single condition
    public boolean evaluateCondition(String condition, Map<String, Object> data) {
        String[] parts = condition.split(" ", 3);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }

        String field = parts[0].trim();
        String operator = parts[1].trim();
        String value = parts[2].trim();

        Object fieldValue = data.get(field);
        if (fieldValue instanceof String) {
            value = value.replace("'", ""); // Remove quotes from the value
        }

        switch (operator) {
            case ">":
                return ((Comparable) fieldValue).compareTo(parseValue(value)) > 0;
            case "<":
                return ((Comparable) fieldValue).compareTo(parseValue(value)) < 0;
            case "=":
                return fieldValue.equals(parseValue(value));
            case "!=":
                return !fieldValue.equals(parseValue(value));
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Combines two rules with AND logic
    public Node combineRules(Node rule1, Node rule2) {
        return new Node("AND", rule1, rule2);
    }

    // Parses the value to the appropriate type
    private Object parseValue(String value) {
        if (value.matches("\\d+")) { // Integer check
            return Integer.parseInt(value);
        } else if (value.matches("\\d+\\.\\d+")) { // Double check
            return Double.parseDouble(value);
        } else {
            return value; // Return as string
        }
    }
}
