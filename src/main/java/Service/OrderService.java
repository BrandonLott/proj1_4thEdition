package Service;

import DAO.OrderRepository;

public class OrderService {

    OrderRepository or ;

    public OrderService(){
        or = new OrderRepository();
    }
}

