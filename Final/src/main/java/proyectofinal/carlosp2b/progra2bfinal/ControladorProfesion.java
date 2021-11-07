/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author carlo
 */
@Controller
public class ControladorProfesion {
    @Autowired
    private Funciones funciones;
    
    @GetMapping("/agregarProfesion")
    public String agregarProfesion(Profesion profesion){
        return "datosProfesion";
    }
    
    @GetMapping("/editarProfesion/{ID_PROFESION")
    public String editarProfesion(Profesion profesion, Model model){
        profesion = funciones.encontrarProfesion(profesion);
        model.addAttribute("profesion",profesion);
        return "datosProfesion";
    }
    
    @GetMapping("/eliminarProfesion/{ID_PROFESION}")
    public String eliminarProfesion(Profesion profesion){
        funciones.eliminar(profesion);
        return "redirect:/listaProfesion";
    }
    
    @PostMapping("/guardarProfesion")
    public String guardarProfesion(@Valid Profesion profesion, BindingResult resultado, Model model){
        if(resultado.hasErrors()){
            return "datosProfesion";
        }
        funciones.guardar(profesion);
        return "redirect:/profesion";
    }
    
    @GetMapping("/listaProfesion")
    public String listarProfesiones(Model model){
        model.addAttribute("profesiones", funciones.listarProfesiones());
        return "listaProfesion";
    }
    
}
