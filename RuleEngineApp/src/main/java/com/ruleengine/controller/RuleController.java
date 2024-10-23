package com.ruleengine.controller;

import com.ruleengine.service.RuleService;
import com.ruleengine.model.Node;

import java.util.Map;

public class RuleController {
    private final RuleService ruleService;

    public RuleController() {
        this.ruleService = new RuleService();
    }

    public Node createRule(String rule) {
        return ruleService.createRule(rule);
    }

    public boolean evaluateRule(Node node, Map<String, Object> data) {
        return ruleService.evaluateRule(node, data);
    }

    public Node combineRules(Node rule1, Node rule2) {
        return ruleService.combineRules(rule1, rule2); // Using the service's combineRules
    }

    public static void main(String[] args) {
        RuleController controller = new RuleController();
        Node ruleNode = controller.createRule("age > 30 AND department = 'Sales'");

        Map<String, Object> data = Map.of(
                "age", 35,
                "department", "Sales"
        );

        boolean result = controller.evaluateRule(ruleNode, data);
        System.out.println("Evaluation Result: " + result);
    }
}
