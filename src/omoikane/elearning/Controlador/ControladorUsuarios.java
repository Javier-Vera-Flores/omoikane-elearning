/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Controlador;

import java.util.List;
import omoikane.elearning.Modelo.Dao.UsuarioDAO;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.Usuario;

/**
 *
 * @author ASUS
 */
public class ControladorUsuarios {

    private UsuarioDAO usuarioDAO;

    public ControladorUsuarios(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Usuario> getUsuarios(String filtro) {
        return usuarioDAO.getAll(filtro);
    }

    public Boolean validarUser(int id) {
        Usuario user = usuarioDAO.getById(id);
        return user != null;
    }

    public Boolean validarPass(int id, String pass) {
        Usuario user = usuarioDAO.getById(id);

        return user.getPass().equals(pass);
    }
    
    public int getIdUser(int id){
        Usuario user = usuarioDAO.getById(id);
        return user.getId_usuario();
    }
    
    public String getNameUser(int id){
        Usuario user = usuarioDAO.getById(id);
        return user.getNombre();
    }
}
