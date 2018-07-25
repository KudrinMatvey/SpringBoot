package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    final VisitRepositry visitRepositry;

    public IndexController(VisitRepositry visitRepositry) {
        this.visitRepositry = visitRepositry;
    }

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");

        Visit visit = new Visit();
        visit.description = String.format("visited as %s", LocalDateTime.now());
        visitRepositry.save(visit);

        return new ModelAndView("index", model);
    }
}