/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aczay
 */
public class DBManager {
    private static DBManager instance;
    private Connection connection;

    private DBManager() {
        try {
            // Simulación de la conexión
            this.connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            System.out.println("Conexión a la base de datos simulada establecida.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
