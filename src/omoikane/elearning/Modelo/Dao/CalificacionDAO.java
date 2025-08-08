/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;

import omoikane.elearning.Modelo.Calificacion;
import java.util.ArrayList;
import java.util.List;

/**
 * CalificacionDAO es la implementación del patrón DAO para la clase Calificacion.
 * Simula la persistencia de calificaciones en una lista en memoria.
/**
 *
 * @author aczay
 */
public class CalificacionDAO implements IDAO<Calificacion>{
     private List<Calificacion> calificaciones = new ArrayList<>();

    @Override
    public Calificacion getById(int id) {
        System.out.println("DAO: Obteniendo calificación con ID " + id);
        return calificaciones.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Calificacion> getAll(String filtro) {
        System.out.println("DAO: Obteniendo todas las calificaciones");
        return new ArrayList<>(calificaciones);
    }

    @Override
    public void insert(Calificacion entity) {
        System.out.println("DAO: Insertando nueva calificación");
        calificaciones.add(entity);
    }

    @Override
    public void update(Calificacion entity) {
        System.out.println("DAO: Actualizando calificación");
        // Lógica de actualización simulada
    }

    @Override
    public void delete(int id) {
        System.out.println("DAO: Eliminando calificación con ID " + id);
        calificaciones.removeIf(c -> c.getId() == id);
    }
}
