/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author carlo
 */
@Data
@Entity
@Table(name="tb_departamento")
public class Departamento implements Serializable{
    private static final long SerialVersionUI=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_DEPTO;
    private String DESCRIPCION_DEPTO;
}
