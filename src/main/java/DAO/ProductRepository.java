//These are Database Access Objects they can reach the backend and grab from SQL database
package DAO;

import Model.Product;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
    //in order to reach the SQL database we need to connect to it using the connection util we have already built
    Connection conn;
    public ProductRepository(){
        //we now need to get connected in our method
        conn = ConnectionUtil.getConnection();
    }
    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM LevelUpDB.dbo.Products");


            while (rs.next()){
                Product loadedProduct = new Product(rs.getString("Product_Name"),rs.getString("Product_Type"), rs.getInt("Qty"),  rs.getDouble("Price"),rs.getInt("Product_ID") );
                allProducts.add(loadedProduct);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return allProducts ;
    }
    public List<Product> getAllProductByName(String name){
        List<Product> allProducts = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Products WHERE Product_Name = ?");
            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Product loadedProduct = new Product(rs.getString("Product_Name"),rs.getString("Product_Type"), rs.getInt("Qty"),  rs.getDouble("Price"),rs.getInt("Product_ID") );
                allProducts.add(loadedProduct);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return allProducts ;
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
