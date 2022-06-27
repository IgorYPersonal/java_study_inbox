package com.example.demo_inbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/inbox")
public class InboxController {

    @GetMapping
    public String base() {
        return "inbox/list";
    }
}
