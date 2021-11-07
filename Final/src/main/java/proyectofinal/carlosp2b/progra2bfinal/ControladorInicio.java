/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author carlo
 */
@Controller
public class ControladorInicio {
    
    @GetMapping("/")
    public String inicio(Model model){
        return "index";
    }
    
    @GetMapping("/usuario")
    public String usuario(){
        return "user";
    }
    
    @GetMapping("/profesion")
    public String profesion(){
        return "profesion";
    }
}
