package com.example.lab6_20210535.controller;

import com.example.lab6_20210535.entity.Directores;
import com.example.lab6_20210535.entity.Peliculas;
import com.example.lab6_20210535.repository.DirectoresRepository;
import com.example.lab6_20210535.repository.PeliculasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class movieController {

    final PeliculasRepository peliculasRepository;
    final DirectoresRepository directoresRepository;

    public movieController(PeliculasRepository peliculasRepository, DirectoresRepository directoresRepository) {
        this.peliculasRepository = peliculasRepository;
        this.directoresRepository = directoresRepository;
    }

    @GetMapping({"/","/paginaPrincipal"})
    public String paginaPrincipal(){

        return "paginaPrincipal";
    }

    @GetMapping("listaPeliculas")
    public String listaPeliculas(Model model){
        List<Peliculas> listaPeliculas = peliculasRepository.findAll();
        model.addAttribute("listaPeliculas", listaPeliculas);
        return "listaPeliculas";
    }

    @GetMapping("listaDirectores")
    public String listaDirectores(Model model){
        List<Directores> listaDirectores = directoresRepository.findAll();
        model.addAttribute("listaDirectores", listaDirectores);
        return "listaDirectores";
    }

    @GetMapping("crearPelicula")
    public String crearPelicula(@ModelAttribute("pelicula") Peliculas peliculas){
        return "crear_editar_pelicula";
    }

    @GetMapping("crearDirector")
    public String crearPelicula(@ModelAttribute("director") Directores directores){
        return "crear_editar_director";
    }

    @PostMapping("newMovie")
    public String Movie(Model model, @Valid Peliculas peliculas, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "crear_editar_pelicula";
        }else{
            peliculasRepository.save(peliculas);
            return "redirect:/listaPeliculas";
        }

    }
    @PostMapping("newDirector")
    public String director(Model model, @Valid Directores directores, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "crear_editar_director";
        }else{
            directoresRepository.save(directores);
            return "redirect:/listaDirectores";
        }

    }

    @GetMapping("eliminarPelicula/{id}")
    public String eliminarPelicula(@PathVariable("id") Integer id){
        peliculasRepository.deleteById(id);
        return "redirect:/listaPeliculas";
    }
}
