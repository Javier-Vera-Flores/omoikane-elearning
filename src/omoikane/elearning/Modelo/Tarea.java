package omoikane.elearning.Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aczay
 */
public abstract class Tarea {
    private int id_tarea;
    private String nombre;
    private String descripcion;

    public Tarea(int id_tarea, String nombre, String descripcion) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_tarea() { return id_tarea; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public abstract Calificacion calificar(Estudiante estudiante);
}
