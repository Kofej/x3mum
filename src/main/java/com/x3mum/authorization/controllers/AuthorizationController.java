package com.x3mum.authorization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthorizationController {

  @RequestMapping("")
  public String index(Model model) {
    return "authorization/index";
  }
}
