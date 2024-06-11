package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PetModel {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PetModel() {
        conn = DBconnect.connect();
    }

    public ResultSet loadTableData() {
        try {
            String sql = "SELECT Id, Petname, Bread, Age, Price, Gender FROM Pet";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    public ResultSet searchPets(String searchQuery) {
        try {
            String sql = "SELECT * FROM pet WHERE Petname LIKE '%" + searchQuery + "%' OR Id LIKE '%" + searchQuery + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    public void insertPet(String name, String bread, String age, int price, String gender) {
        try {
            String sql = "INSERT INTO pet(Petname, Bread, Age, Price, Gender) VALUES ('" + name + "', '" + bread + "', '" + age + "', '" + price + "', '" + gender + "')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updatePet(String id, String name, String bread, String age, String price, String gender) {
        try {
            String sql = "UPDATE pet SET Petname='" + name + "', Bread='" + bread + "', Age='" + age + "', Price='" + price + "', Gender='" + gender + "' WHERE Id='" + id + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void deletePet(String id) {
        try {
            String sql = "DELETE FROM pet WHERE Id='" + id + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
