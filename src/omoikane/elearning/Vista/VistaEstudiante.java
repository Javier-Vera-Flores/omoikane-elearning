/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Vista;

import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Modelo.Tarea;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author aczay
 */
public class VistaEstudiante {
    private ControladorTareas controladorTareas;
    private Scanner scanner = new Scanner(System.in);

    public VistaEstudiante(ControladorTareas ct) {
        this.controladorTareas = ct;
    }

    public void mostrarMenu() {
        System.out.println("\n--- Menú de Estudiante ---");
        System.out.println("1. Ver mis tareas");
        System.out.println("2. Entregar tarea (simulado)");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.nextLine();
        
        switch (opcion) {
            case "1":
                verTareasUI();
                break;
            case "2":
                entregarTareaUI();
                break;
            case "3":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                mostrarMenu();
        }
    }

    private void verTareasUI() {
        System.out.println("--- Tareas Disponibles ---");
        List<Tarea> tareas = controladorTareas.getTareas("");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas asignadas.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println("ID: " + tarea.getId_tarea() + ", Nombre: " + tarea.getNombre());
            }
        }
    }

    private void entregarTareaUI() {
        System.out.println("--- Entregar Tarea ---");
        System.out.println("La entrega de tareas es simulada. La tarea se envía al asesor para su calificación.");
    }
}
