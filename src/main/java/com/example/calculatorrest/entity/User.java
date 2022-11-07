package com.example.calculatorrest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long Id;
    private String name;
    private String username;
    private List<Operation> operations;

    public void addOperation(Operation operation){
        if (operations == null){
            operations =new ArrayList<>();
        }
        operations.add(operation);
    }

    public void setId() {
    }
}
