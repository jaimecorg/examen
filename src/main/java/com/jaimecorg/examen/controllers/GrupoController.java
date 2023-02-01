package com.jaimecorg.examen.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.examen.model.Grupo;
import com.jaimecorg.examen.services.GruposServices;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    GruposServices gruposServices;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    
    @GetMapping(value = "/create")
    public ModelAndView create(Grupo grupo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", new Grupo());
        modelAndView.setViewName("grupos/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Grupo grupo) throws IOException{

        gruposServices.insert(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Grupo grupo = gruposServices.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupo", grupo);
        modelAndView.setViewName("grupos/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Grupo grupo) {

        gruposServices.update(grupo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + grupo.getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        gruposServices.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/grupos/list");

        return modelAndView;
    }

}
