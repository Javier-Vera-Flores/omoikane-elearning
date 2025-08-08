/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Controlador;

import omoikane.elearning.Modelo.Estudiante;
import omoikane.elearning.Modelo.Progreso;
import omoikane.elearning.Modelo.RutaAprendizaje;
import omoikane.elearning.Modelo.Dao.ProgresoDAO;
import omoikane.elearning.Modelo.PadreDeFamilia;
//import omoikane.elearning.Modelo.Patterns.Observer.PadreFamilia;
import omoikane.elearning.Modelo.Patterns.Observer.ProgresoNotificador;
import omoikane.elearning.Modelo.Patterns.Estrategy.EstrategiaAvanzada;
import omoikane.elearning.Modelo.Patterns.Estrategy.EstrategiaBasica;
import omoikane.elearning.Modelo.Patterns.Estrategy.MotorRutaAprendizaje;
//Aun faltan incluir las clases ....
/**
 *
 * @author aczay
 */
public class ControladorProgreso {
    private ProgresoDAO progresoDAO;
    private MotorRutaAprendizaje motorRuta;
    private ProgresoNotificador notificador;

    public ControladorProgreso(ProgresoDAO progresoDAO) {
        this.progresoDAO = progresoDAO;
        this.motorRuta = new MotorRutaAprendizaje();
        this.notificador = new ProgresoNotificador();
    }

    /**
     * Simula la actualización del progreso de un estudiante.
     * @param estudiante El estudiante cuyo progreso se actualizará.
     * @param puntaje El nuevo puntaje a registrar.
     */
    public void actualizarProgreso(Estudiante estudiante, double puntaje) {
        System.out.println("Controlador: Recibida solicitud para actualizar progreso del estudiante " + estudiante.getNombre());

        // Crear un objeto Progreso (simulado)
        Progreso nuevoProgreso = new Progreso(1, puntaje, estudiante.getId());
        progresoDAO.insert(nuevoProgreso);

        // Aplicar el patrón Strategy para la ruta de aprendizaje

        if (puntaje > 80) {
            motorRuta.setEstrategia(new EstrategiaAvanzada());
        } else {
            motorRuta.setEstrategia(new EstrategiaBasica());
        }
        RutaAprendizaje ruta = motorRuta.ejecutarEstrategia(nuevoProgreso);

        // Aplicar el patrón Observer para notificar al padre
        PadreDeFamilia padre = new PadreDeFamilia("Carlos"); // Simulamos un padre
        notificador.registrar(padre);
        notificador.notificar();

        System.out.println("Controlador: Progreso actualizado y notificaciones enviadas.");
    }
}
