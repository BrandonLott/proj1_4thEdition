package DAO;

import Model.Orders;
import Model.Product;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRepository {
    Connection conn;

    public OrderRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public List<Orders> getAllOrders(){
        return null;
    }
    public Orders getOrdersByID(int orderId){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Orders WHERE Order_ID = ?");
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
               Orders loadedOrder = new Orders(rs.getString("Order_Date"), rs.getString("Customer_ID"), rs.getString("Ship_Address"), rs.getInt("Product_ID"), rs.getInt("Qty"));
                //and return what we recieved from the database
                return loadedOrder;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Orders> getOrdersByCustomerID(int customerId){
        return null;
    }
    public List<Orders> getOrdersByOrderDate(String date){
        return null;
    }
    public List<Orders> getOrdersByShippingAddress(String address){
        return null;
    }
    public List<Orders> getOrdersByProductID(int productId){
        return null;
    }
}
