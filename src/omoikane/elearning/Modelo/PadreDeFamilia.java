/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo;
import omoikane.elearning.Modelo.Patterns.Observer.Observador;
/**
 *
 * @author aczay
 */
public class PadreDeFamilia implements Observador {
    private String nombre;

    public PadreDeFamilia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar() {
        System.out.println("Padre " + nombre + ": He recibido una notificación sobre el progreso de mi hijo.");
        // Simulación de envío de correo
        System.out.println("Enviando correo electrónico...");
    }
}
