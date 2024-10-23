# Rule Engine with AST

## Project Description
This is a simple 3-tier rule engine application that determines user eligibility based on attributes like age, department, income, and spend. The rules are represented using an Abstract Syntax Tree (AST), and the application allows for dynamic creation, combination, and modification of rules.

## Features
- Dynamic creation of rules from a string input
- AST representation of rules for better parsing and evaluation
- Combining multiple rules into a single AST
- Rule evaluation based on user attributes
- Database (MySQL) integration to store rules and metadata

## Non-functional Features (Bonus Points)
- Added basic JWT authentication for securing APIs.
- Optimized rule parsing logic for better performance when handling large sets of rules.
  
## Prerequisites
- **Java 11** or above
- **MySQL** server running locally or remotely
- **Maven** installed/

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/rule-engine-ast.git
cd rule-engine-ast
