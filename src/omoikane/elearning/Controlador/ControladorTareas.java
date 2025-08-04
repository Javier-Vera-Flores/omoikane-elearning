/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Controlador;

import omoikane.elearning.Modelo.Estudiante;
import omoikane.elearning.Modelo.Calificacion;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.Dao.CalificacionDAO;
import omoikane.elearning.Modelo.Dao.TareaDAO;
import omoikane.elearning.Modelo.Patterns.Factory.ExamenFactory;
import omoikane.elearning.Modelo.Patterns.Factory.TareaFactory;
import omoikane.elearning.Modelo.Patterns.Factory.TareaPracticaFactory;
import java.util.List;
/**
 *
 * @author aczay
 */
/**
 * ControladorTareas maneja la lógica de negocio para la gestión de tareas y exámenes.
 * Actúa como intermediario entre las vistas y las clases del modelo.
 */
public class ControladorTareas {
    private TareaDAO tareaDAO;
    private CalificacionDAO calificacionDAO;

    public ControladorTareas(TareaDAO tareaDAO, CalificacionDAO calificacionDAO) {
        this.tareaDAO = tareaDAO;
        this.calificacionDAO = calificacionDAO;
    }

    /**
     * Simula la creación de una tarea usando el patrón Factory Method.
     * @param tipo El tipo de tarea a crear ("Examen" o "TareaPractica").
     * @param id El ID de la tarea.
     * @param nombre El nombre de la tarea.
     * @param descripcion La descripción de la tarea.
     */
    public void crearTarea(String tipo, int id, String nombre, String descripcion) {
        System.out.println("Controlador: Creando nueva tarea de tipo " + tipo);
        TareaFactory factory = null;
        if (tipo.equalsIgnoreCase("Examen")) {
            factory = new ExamenFactory();
        } else if (tipo.equalsIgnoreCase("TareaPractica")) {
            factory = new TareaPracticaFactory();
        } else {
            System.out.println("Tipo de tarea no válido.");
            return;
        }

        Tarea nuevaTarea = factory.crearTarea(id, nombre, descripcion);
        tareaDAO.insert(nuevaTarea);
    }

    /**
     * Simula la calificación de una tarea.
     * @param tareaId El ID de la tarea a calificar.
     * @param estudiante El estudiante que envió la tarea.
     * @param valor El valor de la calificación.
     */
    public void calificarTarea(int tareaId, Estudiante estudiante, int valor) {
        System.out.println("Controlador: Calificando tarea " + tareaId + " para el estudiante " + estudiante.getNombre());
        Tarea tarea = tareaDAO.getById(tareaId);
        if (tarea != null) {
            Calificacion calificacion = tarea.calificar(estudiante);
            calificacion.setValor(valor); // Simulación de asignación de valor se creo un metodo setvalor en Modelo.Calificacion
            calificacionDAO.insert(calificacion);
        }
    }

    public List<Tarea> getTareas() {
        return tareaDAO.getAll();
    }
}
