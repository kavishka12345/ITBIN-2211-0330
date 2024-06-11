package controller;

import model.PetModel;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class PetController {
    private PetModel model;

    public PetController(PetModel model) {
        this.model = model;
    }

    public void loadTable(JTable table) {
        table.setModel(DbUtils.resultSetToTableModel(model.loadTableData()));
    }

    public void searchPets(JTable table, JTextField searchbox) {
        String searchQuery = searchbox.getText();
        table.setModel(DbUtils.resultSetToTableModel(model.searchPets(searchQuery)));
    }

    public void insertPet(JTextField nametext, JTextField breadtxt, JTextField agetxt, JTextField pricetxt, JRadioButton jRadioButton1, JRadioButton jRadioButton2) {
        String name = nametext.getText();
        String bread = breadtxt.getText();
        String age = agetxt.getText();
        int price = Integer.parseInt(pricetxt.getText());
        String gender = jRadioButton1.isSelected() ? "Male" : "Female";

        model.insertPet(name, bread, age, price, gender);
    }

    public void updatePet(JLabel idtext, JTextField nametext, JTextField breadtxt, JTextField agetxt, JTextField pricetxt, JRadioButton jRadioButton1, JRadioButton jRadioButton2) {
        String id = idtext.getText();
        String name = nametext.getText();
        String bread = breadtxt.getText();
        String age = agetxt.getText();
        String price = pricetxt.getText();
        String gender = jRadioButton1.isSelected() ? "Male" : "Female";

        model.updatePet(id, name, bread, age, price, gender);
    }

    public void deletePet(JLabel idtext) {
        String id = idtext.getText();
        int check = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DELETE");
        if (check == 0) {
            model.deletePet(id);
        }
    }

    public void populateFormFields(JTable table, JLabel idtext, JTextField nametext, JTextField breadtxt, JTextField agetxt, JTextField pricetxt, JRadioButton jRadioButton1, JRadioButton jRadioButton2) {
        int r = table.getSelectedRow();

        String id = table.getValueAt(r, 0).toString();
        String name = table.getValueAt(r, 1).toString();
        String bread = table.getValueAt(r, 2).toString();
        String age = table.getValueAt(r, 3).toString();
        String price = table.getValueAt(r, 4).toString();
        String gender = table.getValueAt(r, 5).toString();

        idtext.setText(id);
        nametext.setText(name);
        breadtxt.setText(bread);
        agetxt.setText(age);
        pricetxt.setText(price);

        if (gender.equals("Male")) {
            jRadioButton1.setSelected(true);
        } else if (gender.equals("Female")) {
            jRadioButton2.setSelected(true);
        }
    }

    public void clearForm(JTextField searchbox, JLabel idtext, JTextField nametext, JTextField breadtxt, JTextField agetxt, JTextField pricetxt) {
        searchbox.setText("");
        idtext.setText("id");
        nametext.setText("");
        breadtxt.setText("");
        agetxt.setText("");
        pricetxt.setText("");
    }
}
