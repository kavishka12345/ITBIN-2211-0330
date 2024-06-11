package Model;

import java.sql.*;

public class CustomerModel {
    private Connection conn;
    private PreparedStatement pst;

    public CustomerModel() {
        conn = initializeDB();
        if (conn == null) {
            System.err.println("Failed to connect to the database. Please check the connection settings.");
        }
    }

    private Connection initializeDB() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure this is the correct driver for your database
            // Establish a connection to your database
            String url =  "jdbc:mysql://localhost:3306/oop project";// replace with your database URL
            String username = "root"; // replace with your database username
            String password = ""; // replace with your database password
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet loadTable() {
        if (conn == null) {
            System.err.println("Connection is not established.");
            return null;
        }
        
        String sql = "SELECT * FROM customer";
        try {
            pst = conn.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet searchCustomer(String search) {
        if (conn == null) {
            System.err.println("Connection is not established.");
            return null;
        }

        String sql = "SELECT * FROM customer WHERE Custname LIKE ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertCustomer(String name, String address, String animaltype, int tpnumber, String gender) {
        if (conn == null) {
            System.err.println("Connection is not established.");
            return;
        }

        String sql = "INSERT INTO customer (Custname, Address, Animaltype, TPnumber, Gender) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, animaltype);
            pst.setInt(4, tpnumber);
            pst.setString(5, gender);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, String name, String address, String animaltype, int tpnumber, String gender) {
        if (conn == null) {
            System.err.println("Connection is not established.");
            return;
        }

        String sql = "UPDATE customer SET Custname=?, Address=?, Animaltype=?, TPnumber=?, Gender=? WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, animaltype);
            pst.setInt(4, tpnumber);
            pst.setString(5, gender);
            pst.setInt(6, id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        if (conn == null) {
            System.err.println("Connection is not established.");
            return;
        }

        String sql = "DELETE FROM customer WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(String name, String company, int quantity, int price, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateCustomer(int id, String name, String company, int quantity, int price, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteFood(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
