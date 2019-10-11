package DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class DAO<E> {

    public abstract List<E> getAll();

    public abstract void update(E object);

    public abstract void create(E object);

    public static Connection connection_DataSource() {
        Connection Conn = null;
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("book2");
        dataSource.setUser("root");
        dataSource.setPassword("1997");
        try {
            Conn = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Conn;
    }
   
    public static PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            Connection conn = connection_DataSource();
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

}

