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

/**
 *
 * @author aczay
 */
public class TareaDAO implements IDAO<Tarea> {

    private Connection connection;
    private List<Tarea> tareas = new ArrayList<>();
    private int idUsuario;
    private String nombreClase = "omoikane.elearning.Modelo.";

    public TareaDAO(int id) {
        // Aquí se crea la instancia por primera vez si aún no existe
        this.connection = (Connection) DBManager.getInstance().getConnection();
        this.idUsuario = id;
    }

    public int getIDUsuario(){
        return idUsuario;
    }
    
    @Override
    public Tarea getById(int id) {
        String sql = "SELECT * FROM tareas WHERE id_asesor = " + idUsuario + " AND id_tarea= ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Convertimos el id a String porque es nombre
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Class<?> clase = Class.forName(nombreClase + rs.getString("tipo_tarea"));
                Tarea tarea = (Tarea) clase
                        .getDeclaredConstructor(int.class, String.class, String.class)
                        .newInstance(
                                rs.getInt("id_tarea"),
                                rs.getString("nombre"),
                                rs.getString("descripcion")
                        );
                // Si hay resultado, se crea el objeto Usuario
                return tarea; // Se devuelve el usuario encontrado
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Tarea> getAll(String filtro) {
        tareas.clear();
        String sql = "SELECT * FROM Tareas " + filtro;
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Class<?> clase = Class.forName(nombreClase + rs.getString("tipo_tarea"));
                Tarea tarea = (Tarea) clase
                        .getDeclaredConstructor(int.class, String.class, String.class)
                        .newInstance(
                                rs.getInt("id_tarea"),
                                rs.getString("nombre"),
                                rs.getString("descripcion")
                        );
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tareas;
    }

    @Override
    public void insert(Tarea entity) {
        String sql = "INSERT INTO Tareas(id_tarea, nombre, descripcion, tipo_tarea, id_asesor) VALUES (?, ?, ?, ?, " + idUsuario + ")";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, entity.getId_tarea());
            stmt.setString(2, entity.getNombre());
            stmt.setString(3, entity.getDescripcion());
            stmt.setString(4, entity.getClass().getSimpleName());

            stmt.executeUpdate();
            System.out.println("Tarea guardada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tarea entity) {
        String sql = "UPDATE Tareas SET nombre = ?, descripcion = ? WHERE id_tarea = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getNombre()); // nuevo correo
            stmt.setString(2, entity.getDescripcion());
            stmt.setInt(3, entity.getId_tarea());

            stmt.executeUpdate();
            System.out.println("Tarea actualizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Tareas WHERE id_tarea = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tarea eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
