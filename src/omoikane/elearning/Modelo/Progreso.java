/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo;

/**
 *
 * @author aczay
 */
public class Progreso {
    // Atributos para el progreso del estudiante
    private int id_progreso;
    private double puntaje_promedio;
    private int id_estudiante;

    public Progreso(int id_progreso, double puntaje_promedio, int id_estudiante) {
        this.id_progreso = id_progreso;
        this.puntaje_promedio = puntaje_promedio;
        this.id_estudiante = id_estudiante;
    }

    public int getId_progreso() {
        return id_progreso;
    }

    public void setId_progreso(int id_progreso) {
        this.id_progreso = id_progreso;
    }


    public double getPuntaje_promedio() {
        return puntaje_promedio;
    }


    public void setPuntaje_promedio(double puntaje_promedio) {
        this.puntaje_promedio = puntaje_promedio;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }


    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
}
