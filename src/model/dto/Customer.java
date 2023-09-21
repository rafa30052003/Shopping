package model.dto;

import java.util.Objects;

public class Customer {
   private String dni;
   private String nombre;
   private String direccion;
   private String tlf;

    public Customer() {
    }

    public Customer(String dni, String nombre, String direccion, String tlf) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tlf = tlf;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTlf() {
        return tlf;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(dni, customer.dni) && Objects.equals(nombre, customer.nombre) && Objects.equals(direccion, customer.direccion) && Objects.equals(tlf, customer.tlf);
    }



    @Override
    public String toString() {
        return "Customer{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tlf='" + tlf + '\'' +
                '}';
    }

}
