package com.program.learning.Addcontroller;

import com.program.learning.domain.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

    @GetMapping("/index")
    public String viewForm(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculator calculator, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        int resultValue = calculator.calculate();
        model.addAttribute("result", resultValue);

        return "calculate";
    }
}
