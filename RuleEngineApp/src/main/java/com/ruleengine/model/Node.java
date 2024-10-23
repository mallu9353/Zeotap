package com.ruleengine.model;

public class Node {
    private String operator; // This holds the operator for AND/OR conditions
    private Node left; // Left child node
    private Node right; // Right child node
    private String condition; // Holds the condition if it's an operand

    // Constructor for operators
    public Node(String operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    // Constructor for operand conditions
    public Node(String condition) {
        this.condition = condition;
    }

    // Getters
    public String getOperator() {
        return operator;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getCondition() {
        return condition;
    }
}
