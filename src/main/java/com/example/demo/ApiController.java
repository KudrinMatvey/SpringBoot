package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    final VisitRepositry visitRepositry;

    public ApiController(VisitRepositry visitRepositry) {
        this.visitRepositry = visitRepositry;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits()
    {
        return visitRepositry.findAll();
    }
}
