/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyectofinal.carlosp2b.progra2bfinal.Departamento;
import proyectofinal.carlosp2b.progra2bfinal.IusuarioDao.IdepartamentoDao;

/**
 *
 * @author carlo
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    
    @Autowired
    private IdepartamentoDao IdepartamentoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Departamento> listaDepartamento() {
        return(List<Departamento>) IdepartamentoDao.findAll();
    }
    
}
