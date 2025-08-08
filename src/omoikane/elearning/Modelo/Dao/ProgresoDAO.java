 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;

import omoikane.elearning.Modelo.Progreso;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aczay
 */
public class ProgresoDAO implements IDAO<Progreso> {
        private List<Progreso> progresos = new ArrayList<>();

    @Override
    public Progreso getById(int id) {
        System.out.println("DAO: Obteniendo progreso con ID " + id);
        return progresos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Progreso> getAll() {
        System.out.println("DAO: Obteniendo todos los progresos");
        return new ArrayList<>(progresos);
    }

    @Override
    public void insert(Progreso entity) {
        System.out.println("DAO: Insertando nuevo progreso");
        progresos.add(entity);
    }

    @Override
    public void update(Progreso entity) {
        System.out.println("DAO: Actualizando progreso");
    
    }

    @Override
    public void delete(int id) {
        System.out.println("DAO: Eliminando progreso con ID " + id);
        progresos.removeIf(p -> p.getId() == id);
    }
}
