/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectofinal.carlosp2b.progra2bfinal.servicio.DepartamentoService;
import proyectofinal.carlosp2b.progra2bfinal.servicio.ProfesionService;
import proyectofinal.carlosp2b.progra2bfinal.servicio.UsuarioService;

/**
 *
 * @author carlo
 */
@Service
public class Funciones {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProfesionService profesionService;
    @Autowired
    private DepartamentoService departamentoService;
    
    private boolean Existente(Profesion profesion){
        boolean resultado = false;
        List<Profesion> profesiones = null;
        try{
            profesiones = profesionService.listaProfesion();
            for(Profesion registrados : profesiones){
                if(Objects.equals(registrados.getDESCRIPCION_PROFESION(),profesion.getDESCRIPCION_PROFESION())){
                    resultado = true;
                    break;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return resultado;
    }
    
    public boolean guardar(Usuario tb_usuarios){
        boolean resultado = false;
        try {
            usuarioService.guardar(tb_usuarios);
            resultado = true;
        } catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return resultado;
    }
    
    public boolean guardar(Profesion profesion) {
        boolean resultado = false;
        try {
            if(!Existente(profesion)) {
                if(profesionService.contarProfesiones()< 10) {
                    profesionService.guardar(profesion);
                    resultado = true;
                }else{
                    resultado = false;
                }
            }else{
                resultado = false;
            }
        }catch (Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return resultado;
    }
    
    public boolean eliminar(Usuario tb_usuarios){
        boolean resultado = false;
        try{
            usuarioService.eliminar(tb_usuarios);
            resultado = true;
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return resultado;
    }
    
    public boolean eliminar(Profesion profesion) {
        boolean resultado = false;
        try {
            profesionService.eliminar(profesion);
            resultado = true;
        }catch(Exception ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return resultado;
    }
    
    public Usuario encontrarUsuario(Usuario tb_usuarios){
        Usuario encontrado = null;
        try{
            encontrado = usuarioService.encontrarUsuario(tb_usuarios);
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return encontrado;
    }
    
    public Profesion encontrarProfesion(Profesion profesion){
        Profesion encontrada = null;
        try{
            encontrada = profesionService.encontrarProfesion(profesion);
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return encontrada;
    }
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> registros = null;
        try{
            registros = usuarioService.listaUsuarios();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return registros;
    }
    
    public List<Profesion> listarProfesiones(){
        List<Profesion> registros = null;
        try{
            registros = profesionService.listaProfesion();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return registros;
    }
    
    public List<Departamento> listarDepartamentos(){
        List<Departamento> registros = null;
        try{
            registros = departamentoService.listaDepartamento();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
            System.out.println("Clavo");
        }
        return registros;
    }
        
        
}
