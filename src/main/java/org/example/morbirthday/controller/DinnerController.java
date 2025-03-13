package org.example.morbirthday.controller;


import org.example.morbirthday.model.Dinner;
import org.example.morbirthday.service.DinnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class DinnerController {

    private final DinnerService dinnerService;

    public DinnerController(DinnerService dinnerService){
        this.dinnerService = dinnerService;
    }

    @GetMapping("")
    public String seGave(){
        return "gave";
    }


    @GetMapping("/forside")
    public String seForside(){
        return "forside";
    }

    @GetMapping("/kontakt")
    public String kontakt(){
        return "/kontakt";
    }

    @GetMapping("/nyOrdrer")
    public String lavNyOrdrer(Model model){
        Dinner nyDinner = new Dinner();
        model.addAttribute("nyOrdrer", nyDinner);
        return "nyOrdrer";
    }


    @PostMapping("/nyOrdrer")
    public String sendNyOrdrer(@ModelAttribute Dinner dinner){
        dinnerService.addDinner(dinner);
        return "redirect:/seOrdrer";
    }



    @GetMapping("/seOrdrer")
    public String seOrdrer(Model model){
        model.addAttribute("orders", dinnerService.getAllDinners());
        return "seOrdrer";
    }



}
