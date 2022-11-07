package com.example.calculatorrest.controller;

import com.example.calculatorrest.entity.Operation;
import com.example.calculatorrest.entity.User;
import com.example.calculatorrest.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @PostMapping("/calculator")
    public String calculator(@ModelAttribute("newOperation") Operation operation, BindingResult bindingResult,
                             Model model, HttpSession httpSession) {
        calculatorService.calculate(operation);
        if (operation.getResult() == null) {
            throw new RuntimeException("Incorrect arithmetical operation!");
        }
        User currentUser = (User) httpSession.getAttribute("currentUser");
        currentUser.addOperation(operation);
        model.addAttribute("resultOperation", operation);
        return "result";
    }
}
