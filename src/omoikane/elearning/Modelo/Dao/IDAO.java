/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package omoikane.elearning.Modelo.Dao;

import java.util.List;

/**
 *
 * @author aczay
 */
public interface IDAO <T>{
    T getById(int id);
    List<T> getAll();
    void insert(T entity);
    void update(T entity);
    void delete(int id);
}
