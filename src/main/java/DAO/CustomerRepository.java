package DAO;

import Model.Customer;
import Model.Orders;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    Connection conn;
    public CustomerRepository(){
        conn = ConnectionUtil.getConnection();
    }
    public Customer getCustomerById(int customerID){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Customers WHERE Customer_ID = ?");
            statement.setInt(1, customerID);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                Customer loadedCustomer = new Customer(rs.getInt("Customer_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Address"), rs.getString("Phone"));
                //and return what we received from the database
                return loadedCustomer;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Customer> getAllCustomersByFirstName(String firstName){
        List<Customer> allCustomers = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Customers WHERE First_Name = ?");
            statement.setString(1, String.valueOf(firstName));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Customer loadedCustomer = new Customer(rs.getInt("Customer_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Address"), rs.getString("Phone"));
                allCustomers.add(loadedCustomer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allCustomers.size() == 0){
            return null;
        }else {
            return allCustomers;
        }
    }
    public List<Customer> getAllCustomersByLastName(String lastName){
        List<Customer> allCustomers = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Customers WHERE Last_Name = ?");
            statement.setString(1, String.valueOf(lastName));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Customer loadedCustomer = new Customer(rs.getInt("Customer_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Address"), rs.getString("Phone"));
                allCustomers.add(loadedCustomer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allCustomers.size() == 0){
            return null;
        }else {
            return allCustomers;
        }
    }
    public List<Customer> getAllCustomersByAddress(String address){
        List<Customer> allCustomers = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Customers WHERE Address = ?");
            statement.setString(1, String.valueOf(address));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Customer loadedCustomer = new Customer(rs.getInt("Customer_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Address"), rs.getString("Phone"));
                allCustomers.add(loadedCustomer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allCustomers.size() == 0){
            return null;
        }else {
            return allCustomers;
        }
    }
    public List<Customer> getAllCustomersByPhone(String phone){
        List<Customer> allCustomers = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Customers WHERE Phone = ?");
            statement.setString(1, String.valueOf(phone));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Customer loadedCustomer = new Customer(rs.getInt("Customer_ID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Address"), rs.getString("Phone"));
                allCustomers.add(loadedCustomer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allCustomers.size() == 0){
            return null;
        }else {
            return allCustomers;
        }
    }

}
