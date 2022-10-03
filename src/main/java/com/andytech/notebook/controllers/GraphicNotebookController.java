package com.andytech.notebook.controllers;

import com.andytech.notebook.services.NotebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Validated
public class GraphicNotebookController {

    Logger logger = LoggerFactory.getLogger(GraphicNotebookController.class);

    @Autowired
    private NotebookService notebookService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}