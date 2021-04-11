package com.example.demo.controller;

import com.example.demo.model.AccountInterest;
import com.example.demo.model.User;
import com.example.demo.repository.AccountinerestRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InterestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountinerestRepository accountinerestRepository;

    @PostMapping("/api/user")
    String getUserByEmail(@ModelAttribute User user, Model model) {
        User byEmail = userRepository.findByEmail(user.getEmail());
        if(null == byEmail || !user.getEmail().equals(byEmail.getEmail()) || !user.getPassword().equals(byEmail.getPassword())){
            return "login_fail";
        }

        List<AccountInterest> all = accountinerestRepository.findAll();
        model.addAttribute("interestList", all);
        model.addAttribute("email", byEmail.getEmail());
        return "table";
    }

    @GetMapping("/calculate")
    String calculate(Model model) {
        List<AccountInterest> all = accountinerestRepository.findAll();
        all.forEach(accountInterest -> {
            accountInterest.setInterest(accountInterest.getBalance()*accountInterest.getInterestRate()/100);
        });
        accountinerestRepository.saveAll(all);
        model.addAttribute("email", "");
        model.addAttribute("interestList", all);
        return "table";
    }

    @GetMapping("/clear")
    String clear(Model model) {
        List<AccountInterest> all = accountinerestRepository.findAll();
        all.forEach(accountInterest -> {
            accountInterest.setInterest(0);
        });
        accountinerestRepository.saveAll(all);
        model.addAttribute("email", "");
        model.addAttribute("interestList", all);
        return "table";
    }

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    /*@PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }*/
}
