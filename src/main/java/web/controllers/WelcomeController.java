package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String sayWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        messages.add("Practical challenge 3.1.2 Java pre-project.");
        messages.add("Task 3.1.2. Spring Boot.");
        model.addAttribute("messages", messages);

        return "welcome";
    }
}
