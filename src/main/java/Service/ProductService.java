package Service;
//import the database Access Object
import DAO.ProductRepository;
import Model.Product;

import java.util.List;
//^^ this brings in our object that can access the SQL database(backend)


public class ProductService {
    //What can this do? first this service will work with a repository to access our back end SQL database for our store
    //also we can provide extra steps to our information gathered be the repository class here in the service class
    ProductRepository pr;
    public ProductService(){
        pr = new ProductRepository();
    }
    //set up a service layer to get an array of all available products from SQL database
    public List<Product> getAllProducts(){
        //return an array of all products after pulled in by repository
        return pr.getAllProducts();
    }
    //set up a service layer to get an array of all products by name/breed of chicken
    public List<Product> getAllProductByName(String name){

        return pr.getAllProductByName(name);
    }
    //could be implemented later if our store grows to more than just chickens
    public List<Product> getAllProductByType(String type){
        return pr.getAllProductByType(type);
    }
    //allow us to search by price.
    public List<Product> getAllProductByPrice(double price){
        return pr.getAllProductByPrice(price);
    }
    //need to look into how int pid can be used to uniquely identify a product even though it is an auto generated number
    public void addProduct(String name, String type, int quantity, double price, int pid){
        Product existingProduct = pr.getProductByID(pid);
        if(existingProduct == null) {
            pr.addProduct();
        }
    }

}
