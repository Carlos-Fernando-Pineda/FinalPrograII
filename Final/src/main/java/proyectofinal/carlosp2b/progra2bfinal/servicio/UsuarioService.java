/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal.servicio;

import java.util.List;
import proyectofinal.carlosp2b.progra2bfinal.Usuario;

/**
 *
 * @author carlo
 */
public interface UsuarioService {
    public List<Usuario> listaUsuarios();
    public void guardar(Usuario tb_usuarios);
    public void eliminar(Usuario tb_usuarios);
    public Usuario encontrarUsuario(Usuario tb_usuarios);
}
