package com.ruleengine;

import com.ruleengine.service.RuleService;
import com.ruleengine.model.Node;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class RuleEngineTest {
    private RuleService ruleService;

    @BeforeEach
    public void setUp() {
        ruleService = new RuleService();
    }

    @Test
    public void testCreateAndEvaluateRule() {
        Node rule = ruleService.createRule("age > 30");

        Map<String, Object> data = Map.of("age", 35);
        boolean result = ruleService.evaluateRule(rule, data);
        assertTrue(result);
    }

    @Test
    public void testCombineRules() {
        Node rule1 = ruleService.createRule("age > 30");
        Node rule2 = ruleService.createRule("department = 'Sales'");

        Node combinedRule = ruleService.combineRules(rule1, rule2);

        Map<String, Object> data = Map.of("age", 35, "department", "Sales");
        boolean result = ruleService.evaluateRule(combinedRule, data);
        assertTrue(result);
    }

    @Test
    public void testCombineRulesWithFalseCondition() {
        Node rule1 = ruleService.createRule("age > 30");
        Node rule2 = ruleService.createRule("department = 'HR'"); // This will be false

        Node combinedRule = ruleService.combineRules(rule1, rule2);

        Map<String, Object> data = Map.of("age", 35, "department", "Sales");
        boolean result = ruleService.evaluateRule(combinedRule, data);
        assertFalse(result); // Result should be false as one of the conditions is false
    }
}
