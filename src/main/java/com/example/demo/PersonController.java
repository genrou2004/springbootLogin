package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by raya on 6/22/17.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogIn(Model model){

        model.addAttribute(new Person());
        System.out.print("GET here");
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String processingLogIn(@ModelAttribute Person person){
        personRepository.save(person);
        return "redirect:/display";
    }

    @GetMapping (path = "/display")
    public Iterable<Person> getAllHouses(){
        return personRepository.findAll();
    }
}
