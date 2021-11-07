/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import proyectofinal.carlosp2b.progra2bfinal.IusuarioDao.IusuarioDao;
import proyectofinal.carlosp2b.progra2bfinal.Usuario;

/**
 *
 * @author carlo
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private IusuarioDao IusuarioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) IusuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario tb_usuarios) {
        IusuarioDao.save(tb_usuarios);
    }

    @Override
    @Transactional
    public void eliminar(Usuario tb_usuarios) {
        IusuarioDao.delete(tb_usuarios);
    }

    @Override
    @Transactional(readOnly=true)
    public Usuario encontrarUsuario(Usuario tb_usuarios) {
        return IusuarioDao.findById(tb_usuarios.getID_USUARIO()).orElse(null);
    }
    
}
