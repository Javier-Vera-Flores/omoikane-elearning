/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package omoikane.elearning;
import omoikane.elearning.Controlador.ControladorProgreso;
import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Modelo.Dao.CalificacionDAO;
import omoikane.elearning.Modelo.Dao.ProgresoDAO;
import omoikane.elearning.Modelo.Dao.TareaDAO;
import omoikane.elearning.Vista.VistaAsesor;
import omoikane.elearning.Vista.VistaEstudiante;

/**
 *
 * @author aczay
 */
public class OmoikaneElearning {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicialización de la capa del Modelo
        TareaDAO tareaDAO = new TareaDAO();
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        ProgresoDAO progresoDAO = new ProgresoDAO();
        
        // Inicialización de la capa del Controlador
        ControladorTareas controladorTareas = new ControladorTareas(tareaDAO, calificacionDAO);
        ControladorProgreso controladorProgreso = new ControladorProgreso(progresoDAO);
        
        // Inicialización de la capa de la Vista, inyectando los controladores
        VistaAsesor vistaAsesor = new VistaAsesor(controladorProgreso, controladorTareas);
        VistaEstudiante vistaEstudiante = new VistaEstudiante(controladorTareas);

        System.out.println("Simulación del sistema Omoikane iniciada...");
        
        // Por ejemplo, para el Asesor:
        vistaAsesor.mostrarMenu();
        //vistaEstudiante.mostrarMenu();
        
    }
    
}
