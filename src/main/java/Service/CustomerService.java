package Service;

import DAO.CustomerRepository;
import Model.Customer;
import Model.Product;

import java.util.List;

public class CustomerService {
    CustomerRepository cr;
    public CustomerService(){
        cr = new CustomerRepository();
    }
    public Customer getCustomerById(int customerID){
        return cr.getCustomerById(customerID);
    }
    public List<Customer> getAllCustomersByFirstName(String firstName){
        return cr.getAllCustomersByFirstName(firstName);
    }
    public List<Customer> getAllCustomersByLastName(String lastName){
        return cr.getAllCustomersByLastName(lastName);
    }
    public List<Customer> getAllCustomersByAddress(String address){
        return cr.getAllCustomersByAddress(address);
    }
    public List<Customer> getAllCustomersByPhone(String phone){
        return cr.getAllCustomersByPhone(phone);
    }
    public void addCustomer(Customer c){

        Customer existingCustomer = (Customer) cr.getAllCustomersByLastName(c.getLastName());

        if(existingCustomer == null) {
            Customer newCustomer = new Customer(c.getLastName(), c.getFirstName(), c.getCustomerID(), c.getAddress(), c.getPhone());
            cr.addCustomer(newCustomer);
        }
    }

}
