
package com.emergentes.modelo;

import java.util.Date;

public class Sesion {
    
     private int id;
    private String Descripcion;
    private String Cantidad;
    private String Precio;
    private String categorias;

    public Sesion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Apellidos) {
        this.Cantidad = Apellidos;
    }
    
        public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String Categorias) {
        this.categorias = Categorias;
    }   
    
}
