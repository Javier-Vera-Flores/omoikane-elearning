/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Controlador;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import omoikane.elearning.Modelo.Estudiante;
import omoikane.elearning.Modelo.Calificacion;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.Dao.CalificacionDAO;
import omoikane.elearning.Modelo.Dao.TareaDAO;
import omoikane.elearning.Modelo.Patterns.Factory.ExamenFactory;
import omoikane.elearning.Modelo.Patterns.Factory.TareaFactory;
import omoikane.elearning.Modelo.Patterns.Factory.TareaPracticaFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import omoikane.elearning.Vista.VistaAsesor_CrearTarea;
import omoikane.elearning.Vista.VistaAsesor_Menu;

/**
 *
 * @author aczay
 */
/**
 * ControladorTareas maneja la lógica de negocio para la gestión de tareas y
 * exámenes. Actúa como intermediario entre las vistas y las clases del modelo.
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
     *
     * @param tipo El tipo de tarea a crear ("Examen" o "TareaPractica").
     * @param idTarea El ID de la tarea.
     * @param nombre El nombre de la tarea.
     * @param descripcion La descripción de la tarea.
     */
    public Boolean crearTarea(int idTarea, String nombre, String descripcion, String tipo) {
        String nombreClase = "omoikane.elearning.Modelo.Patterns.Factory.";

        System.out.println("Controlador: Creando nueva tarea de tipo " + tipo);
        try {
            System.out.println(nombreClase + tipo + "Factory");
            Class<?> clase = Class.forName(nombreClase + tipo + "Factory");
            TareaFactory factory = (TareaFactory) clase.getDeclaredConstructor().newInstance();

            Tarea nuevaTarea = factory.crearTarea(idTarea, nombre, descripcion);
            tareaDAO.insert(nuevaTarea);

            return true;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            //Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo Reflexion en Factory");
            return false;
        }
    }

    /**
     * Simula la calificación de una tarea.
     *
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
    
    public List<Tarea> getTareas(String filtro) {
        return tareaDAO.getAll(filtro);
    }

    public List<String> filtrarTareas() {
        List<String> tareas = new ArrayList<>();
        for (Tarea t : getTareas("where id_asesor = " + tareaDAO.getIDUsuario())) {
            System.out.println(t.getId_tarea());
            tareas.add(t.getNombre());
        }
        return tareas;
    }

    public Boolean validarID(int newID) {
        List<Tarea> tareas = getTareas("");
        for (Tarea t : tareas) {
            if (newID == t.getId_tarea()) {
                return false;
            }
        }
        return true;
    }

}
