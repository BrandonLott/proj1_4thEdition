package DAO;

import Model.Customer;
import Model.Orders;
import Model.Product;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    Connection conn;

    public OrderRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public List<Orders> getAllOrders(){
        List<Orders> allOrders = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM LevelUpDB.dbo.Orders");


            while (rs.next()){
                Orders loadedOrder = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                allOrders.add(loadedOrder);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return allOrders;
    }
    public Orders getOrdersByID(int orderId){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Order_ID = ?");
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
               Orders loadedOrder = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                //and return what we received from the database
                return loadedOrder;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Orders> getOrdersByCustomerID(int customerId){
        List<Orders> allOrders = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Customer_ID = ?");
            statement.setString(1, String.valueOf(customerId));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Orders loadedOrders = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                allOrders.add(loadedOrders);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allOrders.size() == 0){
            return null;
        }else {
            return allOrders;
        }
    }
    public List<Orders> getOrdersByOrderDate(String date){
        List<Orders> allOrders = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Order_Date = ?");
            statement.setString(1, String.valueOf(date));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Orders loadedOrders = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                allOrders.add(loadedOrders);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allOrders.size() == 0){
            return null;
        }else {
            return allOrders;
        }
    }
    public List<Orders> getOrdersByShippingAddress(String address){
        List<Orders> allOrders = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Ship_Address = ?");
            statement.setString(1, String.valueOf(address));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Orders loadedOrders = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                allOrders.add(loadedOrders);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allOrders.size() == 0){
            return null;
        }else {
            return allOrders;
        }
    }
    public List<Orders> getOrdersByProductID(int productId){
        List<Orders> allOrders = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Product_ID = ?");
            statement.setString(1, String.valueOf(productId));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Orders loadedOrders = new Orders(rs.getString("Order_Date"), rs.getInt("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                allOrders.add(loadedOrders);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allOrders.size() == 0){
            return null;
        }else {
            return allOrders;
        }
    }
    public void addOrder(Orders o) {
        List<Orders> order = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("INSERT INTO LevelUpDB.dbo.Orders( Order_Date, Customer_ID, Ship_Address, Product_ID, Qty)VALUES(?,?,?,?,?)");

            statement.setString(1,o.getDate());
            statement.setInt(2,o.getCustomerId());
            statement.setString(3,o.getAddress());
            statement.setInt(4,o.getProductId());
            statement.setInt(5,o.getQty());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
