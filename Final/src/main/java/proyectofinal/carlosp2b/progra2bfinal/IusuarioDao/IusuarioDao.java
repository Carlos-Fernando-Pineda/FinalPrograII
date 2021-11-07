/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal.IusuarioDao;

import org.springframework.data.repository.CrudRepository;
import proyectofinal.carlosp2b.progra2bfinal.Usuario;

/**
 *
 * @author carlo
 */
public interface IusuarioDao extends CrudRepository<Usuario,Integer>{
    
}
