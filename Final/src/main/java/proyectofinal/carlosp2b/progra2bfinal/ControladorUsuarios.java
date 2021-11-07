/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import java.util.HashMap;
import java.util.Map;
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
public class ControladorUsuarios {
    
    @Autowired
    private Funciones funciones;
    
    @GetMapping("/agregarUser")
    public String agregarUser(Usuario tb_usuarios,Model model){
        model.addAttribute("departamentos",funciones.listarDepartamentos());
        model.addAttribute("profesiones",funciones.listarProfesiones());
        return "datosUser";
    }
    
    @GetMapping("/editarUser/{ID_USUARIO")
    public String editarUser(Usuario tb_usuarios,Model model){
        tb_usuarios = funciones.encontrarUsuario(tb_usuarios);
        model.addAttribute("departamentos",funciones.listarDepartamentos());
        model.addAttribute("profesiones",funciones.listarProfesiones());
        model.addAttribute("tb_usuarios",tb_usuarios);
        return "datosUser";
    }
    
    @GetMapping("/listaUsuarios")
    public String listaUser(Model model){
        Map<Integer,String>departamentos = new HashMap<>();
        Map<Integer,String>profesiones = new HashMap<>();
        funciones.listarDepartamentos().forEach(departamento ->{
            departamentos.put(departamento.getID_DEPTO(), departamento.getDESCRIPCION_DEPTO());
        });
        funciones.listarProfesiones().forEach(profesion -> {
            profesiones.put(profesion.getID_PROFESION(),profesion.getDESCRIPCION_PROFESION());
        });
        model.addAttribute("tb_usuarios",funciones.listarUsuarios());
        model.addAttribute("departamentos",departamentos);
        model.addAttribute("profesiones",profesiones);
        return "listaUser";
    }
    
    @GetMapping("/eliminarUser/{ID_USUARIO")
    public String eliminarUser(Usuario tb_usuarios){
        funciones.eliminar(tb_usuarios);
        return "redirect:/listaUser";
    }
    
    @PostMapping("/guardarUser")
    public String guardarUser(@Valid Usuario tb_usuarios, BindingResult resultado, Model model){
        if(resultado.hasErrors()){
            model.addAttribute("departamentos",funciones.listarDepartamentos());
            model.addAttribute("profesiones",funciones.listarProfesiones());
            return "datosUser";
        }
        if(tb_usuarios.getID_USUARIO() <= 0){
            java.util.Date tiempo = new java.util.Date();
            java.sql.Timestamp fechaRegistro = new java.sql.Timestamp(tiempo.getTime());
            tb_usuarios.setFECHA_REGISTRO(fechaRegistro);
        }
        funciones.guardar(tb_usuarios);
        return "redirect:/user";
    }
    
}
