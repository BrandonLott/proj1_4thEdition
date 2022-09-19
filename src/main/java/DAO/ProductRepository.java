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
        if (allProducts.size() == 0){
            return null;
        }else {
            return allProducts;
        }
    }

    public List<Product> getAllProductByType(String type){
        List<Product> allProducts = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Products WHERE Product_Type = ?");
            statement.setString(1, type);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Product loadedProduct = new Product(rs.getString("Product_Name"),rs.getString("Product_Type"), rs.getInt("Qty"),  rs.getDouble("Price"),rs.getInt("Product_ID") );
                allProducts.add(loadedProduct);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allProducts.size() == 0){
            return null;
        }else {
            return allProducts;
        }
    }

    public List<Product> getAllProductByPrice(double price){
        List<Product> allProducts = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Products WHERE Price < ?");
            statement.setString(1, String.valueOf(price));

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Product loadedProduct = new Product(rs.getString("Product_Name"),rs.getString("Product_Type"), rs.getInt("Qty"),  rs.getDouble("Price"),rs.getInt("Product_ID") );
                allProducts.add(loadedProduct);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (allProducts.size() == 0){
            return null;
        }else {
            return allProducts;
        }
    }
    public void addProduct(Product a){
        List<Product> product = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("INSERT INTO LevelUpDB.dbo.Products( Product_Name, Product_Type, Qty, Price)VALUES(?,?,?,?)");

            statement.setString(1,a.getName());
            statement.setString(2,a.getType());
            statement.setInt(3,a.getQuantity());
            statement.setDouble(4, a.getPrice());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public Product getProductByID(int pid){
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Products WHERE Product_ID = ?");
            statement.setInt(1, pid);
            ResultSet rs = statement.executeQuery();
            //if return 0 results null, if return at least one, run product loadedProduct line.
            if(rs.next()) {
                Product loadedProduct = new Product(rs.getString("Product_Name"), rs.getString("Product_Type"), rs.getInt("Qty"), rs.getDouble("Price"), rs.getInt("Product_ID"));
                //and return what we received from the database
                return loadedProduct;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductByName(String name) {
        try{
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM LevelUpDB.dbo.Products WHERE Product_Name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            //if return 0 results null, if return at least one, run product loadedProduct line.
            if(rs.next()) {
                Product loadedProduct = new Product(rs.getString("Product_Name"), rs.getString("Product_Type"), rs.getInt("Qty"), rs.getDouble("Price"), rs.getInt("Product_ID"));
                //and return what we recieved from the database
                return loadedProduct;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void deleteProductByName(String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM LevelUpDB.dbo.Products WHERE Product_Name = ?");
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateProductByName(String name, Product product) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE LevelUpDB.dbo.Products SET Product_Type = ?, Product_Name = ?, Qty = ?, Price = ?  WHERE Product_Name = ?");
            statement.setString(1, product.getType());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, name);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    }

