/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ahmed Fourati
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    void supprimer(T t) throws SQLException;
    void modifier(T t, int id) throws SQLException;
    List<T> afficher() throws SQLException;
}
