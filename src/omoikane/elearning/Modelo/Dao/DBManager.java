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
    
    // Datos de la conexión
    private final String URL = "jdbc:mysql://localhost:3306/omoikane_db";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    private static DBManager instance;
    private Connection connection;

    private DBManager() {
        try {
            //Conexión a la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la BD");
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
    
    //Cerrar la conexión manualmente
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Terminado...");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión:");
                e.printStackTrace();
            }
        }
    }
}
