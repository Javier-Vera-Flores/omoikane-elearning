/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Observer;

import java.util.ArrayList;
import java.util.List;
import omoikane.elearning.Modelo.PadreDeFamilia;
//parece que no lo ocuparemos mas jeje
//import com.omoikane.app.model.PadreDeFamilia;

/**
 *
 * @author aczay
 */
public class ProgresoNotificador {
    /**
 * ProgresoNotificador es el sujeto que notifica a los observadores.
 */
    private List<Observador> observadores = new ArrayList<>();

    public void registrar(Observador observador) {
        observadores.add(observador);
        System.out.println("Notificador: Observador registrado.");
    }

    public void notificar() {
        System.out.println("Notificador: Notificando a los observadores...");
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }
}
