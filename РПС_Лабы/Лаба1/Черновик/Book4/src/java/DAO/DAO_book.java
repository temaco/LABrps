package DAO;

import my_class.book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;


public class DAO_book extends DAO<book> {

    @Override
    public List<book> getAll() {
        String sql = "SELECT * FROM book";
        List<book> list = new ArrayList<book>();

        try (PreparedStatement stm = DAO.getPrepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                book value = new book();
                value.setID_book(rs.getInt("ID_book"));
                value.setName_book(rs.getString("Name_book"));
                value.setAuthor(rs.getString("Author"));
                value.setBirthday(rs.getString("Birthday"));
                list.add(value);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка : " + e.getMessage());
        }
        return list;
    }

    @Override
    public void update(book Object) {
        
        String sql = "Update book SET Name_book = ?, Author = ?, Birthday = ? WHERE ID_book = ?";
        try (PreparedStatement stmt = DAO.getPrepareStatement(sql)) {

            stmt.setString(1, Object.getName_book());
            stmt.setString(2, Object.getAuthor());
            stmt.setString(3, Object.getBirthday());            
            stmt.setInt(4, Object.getID_book());
            stmt.executeUpdate();
       
        } catch (SQLException e) {
            System.out.println("Ошибка : " + e.getMessage());
        }
        
    }

    

    @Override
    public void create(book Object) {

        String sql = "INSERT INTO book(ID_book, Name_book, Author, Birthday) value (?, ?, ?, ?);";
        try (PreparedStatement stmt = DAO.getPrepareStatement(sql)) {
          
            stmt.setInt(1, Object.getID_book());
            stmt.setString(2, Object.getName_book());
            stmt.setString(3, Object.getAuthor());
            stmt.setString(4, Object.getBirthday());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка : " + e.getMessage());
        }
    }
    
    
   
}
