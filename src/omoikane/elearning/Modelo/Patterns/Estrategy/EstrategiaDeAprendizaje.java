/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package omoikane.elearning.Modelo.Patterns.Estrategy;
import omoikane.elearning.Modelo.Progreso;
import omoikane.elearning.Modelo.RutaAprendizaje;
/**
 *
 * @author aczay
 */
public interface EstrategiaDeAprendizaje {
        RutaAprendizaje calcularRuta(Progreso progreso);
}
