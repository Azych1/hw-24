package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyprospringdemo.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return calculatorService.hello();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (required = false) Integer num1,@RequestParam (required = false) Integer num2) {
        if (num1 != null && num2 != null) {
            return calculatorService.plus(num1, num2);
        } else {
            return "Не хватает числа(-ел) для выполнения операции";
        }
    }

    @GetMapping("/minus")
    public String minus(@RequestParam (required = false) Integer num1,@RequestParam (required = false) Integer num2) {
        if (num1 != null && num2 != null) {
            return calculatorService.minus(num1, num2);
        } else {
            return "Не хватает числа(-ел) для выполнения операции";
        }
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam (required = false) Integer num1,@RequestParam (required = false) Integer num2) {
        if (num1 != null && num2 != null) {
            return calculatorService.multiply(num1, num2);
        } else {
            return "Не хватает числа(-ел) для выполнения операции";
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (required = false) Integer num1,@RequestParam (required = false) Integer num2) {
        if (num1 != null && num2 != null) {
            if (num2 == 0) {
                return "Деление на 0 не доступно";
            }
        } else {
            return "Не хватает числа(-ел) для выполнения операции";
        }

        return calculatorService.divide(num1, num2);

    }

}
