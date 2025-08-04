/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Factory;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.Examen;
/**
 *
 * @author aczay
 */
public class ExamenFactory implements TareaFactory {
    @Override
    public Tarea crearTarea(int id, String nombre, String descripcion) {
        System.out.println("Factory: Creando un objeto Examen.");
        return new Examen(id, nombre, descripcion);
    }
}
