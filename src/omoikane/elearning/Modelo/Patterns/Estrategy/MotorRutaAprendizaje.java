/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Estrategy;
import omoikane.elearning.Modelo.Progreso;
import omoikane.elearning.Modelo.RutaAprendizaje;
/**
 *
 * @author aczay
 */
public class MotorRutaAprendizaje {
 /**
 * MotorRutaAprendizaje es el contexto que usa una estrategia.
 */
    private EstrategiaDeAprendizaje estrategia;

    public void setEstrategia(EstrategiaDeAprendizaje estrategia) {
        this.estrategia = estrategia;
    }

    public RutaAprendizaje ejecutarEstrategia(Progreso progreso) {
        if (estrategia == null) {
            System.out.println("No se ha definido una estrategia. Usando la básica por defecto.");
            this.estrategia = new EstrategiaBasica();
        }
        return estrategia.calcularRuta(progreso);
    }
}
