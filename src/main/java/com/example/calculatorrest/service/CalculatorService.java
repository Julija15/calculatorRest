package com.example.calculatorrest.service;

import com.example.calculatorrest.entity.Operation;
import com.example.calculatorrest.storage.InMemoryOperationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private InMemoryOperationStorage inMemoryOperationStorage;

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double sub(double num1, double num2) {
        return num1 - num2;
    }

    private double mul(double num1, double num2) {
        return num1 * num2;
    }

    private double div(double num1, double num2) {
        return num1 / num2;
    }

    public void calculate(Operation operation) {
        Double result = null;
        switch (operation.getOperation()) {
            case "sum":
                result = operation.getNum1() + operation.getNum2();
                break;
            case "sub":
                result = operation.getNum1() - operation.getNum2();
                break;
            case "mul":
                result = operation.getNum1() * operation.getNum2();
                break;
            case "div":
                result = operation.getNum1() / operation.getNum2();
                break;
            default:
                break;
        }
        operation.setResult(result);
        inMemoryOperationStorage.save(operation);
    }

    public List<Operation> findHistory(long id) {
        return inMemoryOperationStorage.getAllByUserId(id);
    }
}


