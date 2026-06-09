/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import co.edu.uvpalmira.fpoe.jpalib.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author USUARIO
 * 
 * 
 */

@NamedQueries({
    @NamedQuery(name = "Docente.buscarPorCodigo",
    query = "SELECT a FROM Docente a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Docente.buscarPorEscuela",
    query = "SELECT a FROM Docente a WHERE a.codigo LIKE :prefijo ORDER BY a.codigo ASC")
})

@Entity
public class Docente extends AbstractEntity{
    
    @NotEmpty
    @Column(nullable = false, unique = false, length = 100)
    private int codigo;
    
    @NotEmpty
    @Column(nullable = false, unique = false, length = 100)
    private String nombre;
    
    @NotEmpty
    @Column(nullable = false, unique = true, length = 100)
    private String apellido;
    
    @NotEmpty
    @Column(nullable = false, unique = false, length = 100)
    private String genero;
    
    // Constructor vacio
    public Docente() {
    }

    // construcrores
    public Docente(int codigo, String nombre, String apellido, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public Docente(int codigo, String nombre, String apellido, String genero, Long id) {
        super(id);
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }
    
    // metodos get
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }
    
    // metodos set
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
