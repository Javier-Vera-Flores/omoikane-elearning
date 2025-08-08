/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Vista;

import omoikane.elearning.Controlador.ControladorProgreso;
import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Modelo.Estudiante;
import java.util.Scanner;
/**
 *
 * @author aczay
 */
public class VistaAsesor {
    private ControladorProgreso controladorProgreso;
    private ControladorTareas controladorTareas;
    private Scanner scanner = new Scanner(System.in);

    public VistaAsesor(ControladorProgreso cp, ControladorTareas ct) {
        this.controladorProgreso = cp;
        this.controladorTareas = ct;
    }

    public void mostrarMenu() {
        System.out.println("\n--- Menú de Asesor ---");
        System.out.println("1. Actualizar Progreso de Estudiante");
        System.out.println("2. Crear nueva Tarea");
        System.out.println("3. Calificar Tarea");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();
        
        switch (opcion) {
            case "1":
                actualizarProgresoUI();
                break;
            case "2":
                crearTareaUI();
                break;
            case "3":
                calificarTareaUI();
                break;
            case "4":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                mostrarMenu();
        }
    }

    private void actualizarProgresoUI() {
        System.out.println("--- Actualizar Progreso ---");
        System.out.print("ID del Estudiante: ");
        int idEstudiante = Integer.parseInt(scanner.nextLine());
        System.out.print("Puntaje del  examen/tarea: ");
        double puntaje = Double.parseDouble(scanner.nextLine());
        Estudiante estudiante = new Estudiante(idEstudiante, " Estudiante Prueba " + idEstudiante); // Simulación
        controladorProgreso.actualizarProgreso(estudiante, puntaje);
    }
    
    private void crearTareaUI() {
        System.out.println("-- Crear Tarea ---");
        System.out.print("Tipo de tarea (Examen/TareaPractica): ");
        String tipo = scanner.nextLine();
        System.out.print("ID de la nueva tarea: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        controladorTareas.crearTarea(tipo, id, nombre, descripcion);
    }
    
    private void calificarTareaUI() {
        System.out.println("--- Calificar Tarea ---");
        System.out.print("ID de la tarea a calificar: ");
        int tareaId = Integer.parseInt(scanner.nextLine());
        System.out.print("ID del estudiante: ");
        int estudianteId = Integer.parseInt(scanner.nextLine());
        System.out.print("Calificación: ");
        int valor = Integer.parseInt(scanner.nextLine());
        Estudiante estudiante = new Estudiante(estudianteId, "Estudiante Prueba " + estudianteId); // Simulación
        controladorTareas.calificarTarea(tareaId, estudiante, valor);
    }
}
