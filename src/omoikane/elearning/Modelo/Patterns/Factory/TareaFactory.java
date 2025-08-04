/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Factory;

import omoikane.elearning.Modelo.Tarea;

/**
 *
 * @author aczay
 */
public interface TareaFactory {
     Tarea crearTarea(int id, String nombre, String descripcion);

}
