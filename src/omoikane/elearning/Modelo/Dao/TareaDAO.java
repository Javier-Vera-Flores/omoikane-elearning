/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;

import omoikane.elearning.Modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aczay
 */
public class TareaDAO implements IDAO<Tarea>  {
    // Simulación de la base de datos con una lista en memoria
    private List<Tarea> tareas = new ArrayList<>();

    @Override
    public Tarea getById(int id) {
        System.out.println("DAO: Obteniendo tarea con ID " + id);
        return tareas.stream().filter(t -> t.getId_tarea() == id).findFirst().orElse(null);
    }

    @Override
    public List<Tarea> getAll() {
        System.out.println("DAO: Obteniendo todas las tareas");
        return new ArrayList<>(tareas);
    }

    @Override
    public void insert(Tarea entity) {
        System.out.println("DAO: Insertando nueva tarea con ID " + entity.getId_tarea());
        tareas.add(entity);
    }

    @Override
    public void update(Tarea entity) {
        System.out.println("DAO: Actualizando tarea con ID " + entity.getId_tarea());
        // Lógica de actualización simulada
    }

    @Override
    public void delete(int id) {
        System.out.println("DAO: Eliminando tarea con ID " + id);
        tareas.removeIf(t -> t.getId_tarea() == id);
    }
}
