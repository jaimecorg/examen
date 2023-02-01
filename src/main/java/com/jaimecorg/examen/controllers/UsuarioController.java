package com.jaimecorg.examen.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.examen.model.Usuario;
import com.jaimecorg.examen.services.UsuariosServices;



@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuariosServices usuariossService;

    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Usuario> usuarios = usuariossService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.setViewName("usuarios/list");

        return modelAndView;
    } 

    
    @GetMapping(value = "/create")
    public ModelAndView create(Usuario usuario) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("usuarios/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Usuario usuario) throws IOException{

        usuariossService.insert(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Usuario usuario = usuariossService.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.setViewName("usuarios/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario) {

        usuariossService.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        usuariossService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios/list");

        return modelAndView;
    }

    

}
