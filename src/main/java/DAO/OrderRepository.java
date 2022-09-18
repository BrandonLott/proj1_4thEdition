package DAO;

import Model.Orders;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.util.List;

public class OrderRepository {
    Connection conn;

    public OrderRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public List<Orders> getAllOrders(){
        return null;
    }
    public Orders getOrdersByID(int customerId){
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
