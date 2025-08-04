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
public class EstrategiaBasica implements EstrategiaDeAprendizaje {
        @Override
    public RutaAprendizaje calcularRuta(Progreso progreso) {
        System.out.println("Estrategia Básica: Generando ruta de aprendizaje...");
        return new RutaAprendizaje(); // Objeto simulado
    }
}
