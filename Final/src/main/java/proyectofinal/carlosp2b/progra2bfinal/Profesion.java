/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.carlosp2b.progra2bfinal;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author carlo
 */
@Data
@Entity
@Table(name="tb_profesion")
public class Profesion implements Serializable{
    private static final long SerialVersionUI=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_PROFESION;
    @NotEmpty
    private String DESCRIPCION_PROFESION;
}
