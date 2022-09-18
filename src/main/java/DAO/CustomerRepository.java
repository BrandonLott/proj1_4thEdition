package DAO;

import Model.Customer;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class CustomerRepository {
    Connection conn;
    public CustomerRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public Customer getCustomerById(int customerID){
        return null;
    }
    public List<Customer> getAllCustomersByFirstName(String firstName){
        return null;
    }
    public List<Customer> getAllCustomersByLastName(String lastName){
        return null;
    }
    public List<Customer> getAllCustomersByAddress(String address){
        return null;
    }
    public List<Customer> getAllCustomersByPhone(String phone){
        return null;
    }

}
