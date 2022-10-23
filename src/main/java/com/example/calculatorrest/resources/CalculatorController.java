package com.example.calculatorrest.resources;

import com.example.calculatorrest.entity.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @PostMapping
    public Operation calc(@RequestBody Operation operation) {
        operation.setResult(Double.valueOf(operation.getOperation()));
        return operation;
    }
}
