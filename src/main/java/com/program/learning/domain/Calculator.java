package com.program.learning.domain;

public class Calculator {
    private int num1;
    private int num2;
    private String operation;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int calculate() {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                // Avoid division by zero
                return num2 != 0 ? num1 / num2 : 0;
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operation);
        }
    }
}
