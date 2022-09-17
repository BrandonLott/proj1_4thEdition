//These are Database Access Objects they can reach the backend and grab from SQL database
package DAO;

import Model.Product;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class ProductRepository {
    //in order to reach the SQL database we need to connect to it using the connection util we have already built
    Connection conn;
    public ProductRepository(){
        //we now need to get connected in our method
        conn = ConnectionUtil.getConnection();
    }
    public List<Product> getAllProducts(){

        return null;
    }
    public List<Product> getAllProductByName(String name){
        return null;
    }

    public List<Product> getAllProductByType(String type){
        return null;
    }

    public List<Product> getAllProductByPrice(double price){
        return null;
    }
    public void addProduct(){

    }
    public Product getProductByID(int pid){
        return null;
    }
}
