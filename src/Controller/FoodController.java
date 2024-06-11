package Controller;

import Model.CustomerModel;
import Model.FoodModel;
import java.sql.ResultSet;

public class FoodController {
    private FoodModel model;

    public FoodController() {
        model = new FoodModel();
    }

    public ResultSet loadTable() {
        return model.loadTable();
    }

    public ResultSet searchFood(String search) {
        return model.searchFood(search);
    }

    public void insertFood(String name, String company, String quantity, int price, String type) {
        model.insertFood(name, company, quantity, price, type);
    }

    public void updateFood(int id, String name, String company,String quantity, int price, String type) {
        model.updateFood(id, name,company, quantity, price, type);
    }

    public void deleteFood(int id) {
        model.deleteFood(id);
    }
}
