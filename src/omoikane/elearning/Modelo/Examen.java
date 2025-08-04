/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo;

/**
 *
 * @author aczay
 */
public class Examen extends Tarea{
        public Examen(int id_tarea, String nombre, String descripcion) {
        super(id_tarea, nombre, descripcion);
    }

    @Override
    public Calificacion calificar(Estudiante estudiante) {
        System.out.println("Calificando examen para el estudiante: " + estudiante.getNombre());
        return new Calificacion(); // Simulación de calificación
    }
}
