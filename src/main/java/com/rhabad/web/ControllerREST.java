package com.rhabad.web;

import com.rhabad.domain.Individuo;
import com.rhabad.service.IndividuosServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ControllerREST {

    @Autowired
    private IndividuosServices indiService; //la inyectamos para hacer uso de ella.

    @GetMapping("/")
    public String comienzo(Model model){

        List<Individuo> individuos = indiService.listaIndividuos(); //traemos todos los objetos de tipo individuo

        log.info("Estoy ejecutando el controlador MVC");
        model.addAttribute("individuos", individuos);

        return "indice";
    }

    @GetMapping("/anexar")
    public String anexar(Individuo individuo){
        return "cambios";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors error){
        if (error.hasErrors()){
            return "cambios";
        }

        indiService.salvar(individuo);
        return "redirect:/";
    }

    @GetMapping("/cambiar/{idIndividuo}")
    public String cambiar(Individuo individuo, Model model){
        individuo = indiService.traerIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "cambios";
    }

    @GetMapping("/borrar/{idIndividuo}")
    public String borrar(Individuo individuo){
        indiService.borrar(individuo);
        return "redirect:/";
    }
}
