/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal.servicio;

import java.util.List;
import proyectofinal.carlosp2b.progra2bfinal.Profesion;

/**
 *
 * @author carlo
 */
public interface ProfesionService {
    public List<Profesion> listaProfesion();
    public void guardar(Profesion profesion);
    public void eliminar(Profesion profesion);
    public Profesion encontrarProfesion(Profesion profesion);
    public long contarProfesiones();
}
