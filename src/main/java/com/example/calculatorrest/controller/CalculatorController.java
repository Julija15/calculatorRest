package com.example.calculatorrest.controller;

import com.example.calculatorrest.entity.Operation;
import com.example.calculatorrest.service.CalculatorService;
import com.example.calculatorrest.service.UserService;
import com.example.calculatorrest.storage.InMemoryOperationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @Autowired
    InMemoryOperationStorage inMemoryOperationStorage;

    @Autowired
    UserService userService;
    @PostMapping("/calculator")
    public Double calculator(@RequestBody Operation operation) {
        calculatorService.calculate(operation);
        if (operation.getResult() == null) {
            throw new RuntimeException("Incorrect arithmetical operation!");
        }
        userService.addOperation(operation);
        inMemoryOperationStorage.save(operation);
        return operation.getResult();
    }
}
