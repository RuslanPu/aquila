package com.aqula.controller;

import com.aqula.model.EntryMainPage;

import com.aqula.model.FileDB;
import com.aqula.service.EntryService;

import com.aqula.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MainController {
    @Autowired
    private EntryService service;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value={"/index","/"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        List<EntryMainPage> listEntry = service.getAllEntry();
        List<FileDB> images = fileStorageService.getAllFiles().collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        modelAndView.addObject("listEntry", listEntry );
        modelAndView.addObject("images", images);
        return modelAndView;
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/forget")
    public String forget() {
        return "/forget";
    }

    @GetMapping("/403")
    public String error403() {
        return "/403";
    }
}
