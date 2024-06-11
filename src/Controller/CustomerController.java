package Controller;

import Model.CustomerModel;
import java.sql.ResultSet;

public class CustomerController {
    private CustomerModel model;

    public CustomerController() {
        model = new CustomerModel();
    }

    public ResultSet loadTable() {
        return model.loadTable();
    }

    public ResultSet searchCustomer(String search) {
        return model.searchCustomer(search);
    }

    public void insertCustomer(String name, String address, String animaltype, int tpnumber, String gender) {
        model.insertCustomer(name, address, animaltype, tpnumber, gender);
    }

    public void updateCustomer(int id, String name, String address, String animaltype, int tpnumber, String gender) {
        model.updateCustomer(id, name, address, animaltype, tpnumber, gender);
    }

    public void deleteCustomer(int id) {
        model.deleteCustomer(id);
    }

    public ResultSet searchFood(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
