/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package omoikane.elearning;

import javax.swing.JFrame;
import omoikane.elearning.Controlador.ControladorProgreso;
import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Controlador.ControladorTareas;
import omoikane.elearning.Controlador.ControladorUsuarios;
import omoikane.elearning.Modelo.Dao.CalificacionDAO;
import omoikane.elearning.Modelo.Dao.ProgresoDAO;
import omoikane.elearning.Modelo.Dao.TareaDAO;
import omoikane.elearning.Modelo.Dao.UsuarioDAO;
import omoikane.elearning.Modelo.Examen;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Vista.VistaAsesor;
import omoikane.elearning.Vista.VistaAsesor_CrearTarea;
import omoikane.elearning.Vista.VistaAsesor_Menu;
import omoikane.elearning.Vista.VistaEstudiante;
import omoikane.elearning.Vista.VistaLogIn;

/**
 *
 * @author aczay
 */
public class OmoikaneElearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ControladorUsuarios controladorUsuarios = new ControladorUsuarios(usuarioDAO);

        // Vista
        VistaLogIn logIn = new VistaLogIn(controladorUsuarios);

        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIn.pack();
        logIn.setLocationRelativeTo(null);
        logIn.setVisible(true);

        /*VistaAsesor_Menu menuAsesor = new VistaAsesor_Menu(controladorTareas);

        menuAsesor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuAsesor.pack();
        menuAsesor.setLocationRelativeTo(null);
        menuAsesor.setVisible(true);
        /*INTERFAZ*/
    }

}
