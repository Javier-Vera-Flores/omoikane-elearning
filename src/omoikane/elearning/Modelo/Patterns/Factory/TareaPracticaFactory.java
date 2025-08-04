/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Factory;

import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.TareaPractica;

/**
 *
 * @author aczay
 */
public class TareaPracticaFactory implements TareaFactory {
    @Override
    public Tarea crearTarea(int id, String nombre, String descripcion) {
        System.out.println("Factory: Creando un objeto TareaPractica.");
        return new TareaPractica(id, nombre, descripcion);
    }
}
