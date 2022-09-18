package Service;

import DAO.OrderRepository;
import Model.Orders;
import Model.Product;

import java.util.List;

public class OrderService {

    OrderRepository or ;

    public OrderService(){
        or = new OrderRepository();
    }
    public List<Orders> getAllOrders(){
        return or.getAllOrders();
    }
    public Orders getOrdersByID(int orderId) {
        return or.getOrdersByID(orderId);
    }
    public List<Orders> getOrdersByCustomerID(int customerId){
        return or.getOrdersByCustomerID(customerId);
    }
    public List<Orders> getOrdersByOrderDate(String date){
        return or.getOrdersByOrderDate(date);
    }
    public List<Orders> getOrdersByShippingAddress(String address){
        return or.getOrdersByShippingAddress(address);
    }
    public List<Orders> getOrdersByProductID(int productId){
        return or.getOrdersByProductID(productId);
    }
}

