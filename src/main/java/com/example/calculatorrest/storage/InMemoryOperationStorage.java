package com.example.calculatorrest.storage;

import com.example.calculatorrest.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationStorage  {

    private static final List<Operation> operations = new ArrayList<>();

    public void save(Operation operation){
        operations.add(operation);
    }

    public List<Operation> getAllByUserId(long id) {
        List<Operation> operationList = new ArrayList<>();
        for (Operation operation : operations) {
            if(operation.getUserId() == id){
                operationList.add(operation);
            }
        }
        return operationList;
    }
}
