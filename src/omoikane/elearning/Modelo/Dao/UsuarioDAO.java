/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import omoikane.elearning.Modelo.Examen;
import omoikane.elearning.Modelo.Tarea;
import omoikane.elearning.Modelo.TareaPractica;
import omoikane.elearning.Modelo.Usuario;

/**
 *
 * @author aczay
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private Connection connection;
    private List<Usuario> usuarios = new ArrayList<>();
    private String nombreClase = "omoikane.elearning.Modelo.";

    public UsuarioDAO() {
        // Aquí se crea la instancia por primera vez si aún no existe
        this.connection = (Connection) DBManager.getInstance().getConnection();
    }

    @Override
    public Usuario getById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id= ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Convertimos el id a String porque es nombre
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Class<?> clase = Class.forName(nombreClase + rs.getString("tipo_usuario"));
                
                Usuario usuario = (Usuario) clase
                        .getDeclaredConstructor(int.class, String.class)
                        .newInstance(
                                rs.getInt("id"),
                                rs.getString("nombre")
                        );
                usuario.setPass(rs.getString("password"));
                // Si hay resultado, se crea el objeto Usuario
                return usuario; // Se devuelve el usuario encontrado
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Usuario> getAll(String filtro) {
        usuarios.clear();
        String sql = "SELECT * FROM usuarios " + filtro;
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Class<?> clase = Class.forName(nombreClase + rs.getString("tipo_usuario"));
                Usuario usuario = (Usuario) clase
                        .getDeclaredConstructor(int.class, String.class, String.class)
                        .newInstance(
                                rs.getInt("id_tarea"),
                                rs.getString("nombre")
                        );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public void insert(Usuario entity) {
        String sql = "INSERT INTO usuarios(id, nombre, correo, password, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, entity.getId_usuario());
            stmt.setString(2, entity.getNombre());
            stmt.setString(3, entity.getCorreo());
            stmt.setString(4, entity.getPass());
            stmt.setString(5, entity.getClass().getSimpleName());

            stmt.executeUpdate();
            System.out.println("Usuario guardada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Usuario entity) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getNombre()); // nuevo correo
            stmt.setString(2, entity.getCorreo());
            stmt.setString(3, entity.getPass());
            stmt.setInt(4, entity.getId_usuario());

            stmt.executeUpdate();
            System.out.println("Usuario actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
