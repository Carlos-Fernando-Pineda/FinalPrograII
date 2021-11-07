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
import proyectofinal.carlosp2b.progra2bfinal.IusuarioDao.IprofesionDao;
import proyectofinal.carlosp2b.progra2bfinal.Profesion;

/**
 *
 * @author carlo
 */
@Service
public class ProfesionServiceImpl implements ProfesionService{
    
    @Autowired
    private IprofesionDao IprofesionDao;

    @Override
    @Transactional(readOnly=true)
    public List<Profesion> listaProfesion() {
        return(List<Profesion>) IprofesionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Profesion profesion) {
        IprofesionDao.save(profesion);
    }

    @Override
    @Transactional
    public void eliminar(Profesion profesion) {
        IprofesionDao.delete(profesion);
    }

    @Override
    @Transactional(readOnly=true)
    public Profesion encontrarProfesion(Profesion profesion) {
        return IprofesionDao.findById(profesion.getID_PROFESION()).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public long contarProfesiones() {
        return IprofesionDao.count();
    }
    
}
