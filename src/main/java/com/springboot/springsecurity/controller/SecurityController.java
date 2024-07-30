package com.springboot.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * Os mapeamentos configurados na controller, sobrepoem os mapeamentos da WebMvcConfigurer,
 * ou seja, mesmo que estejam configurados em ambas as classes, prevalecerá o mapeamento
 * configurado na controller
 */
@Controller
public class SecurityController {
    /*
     * Aqui estão duas possíveis formas de carregar uma View com Thymeleaf
     * As duas são equivalentes entre si.
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", new String("Message from controller"));
        return "home";
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", new String("Message from mav controller"));
        return mav;
    }

}