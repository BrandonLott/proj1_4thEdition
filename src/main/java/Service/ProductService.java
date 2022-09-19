package Service;
//import the database Access Object
import DAO.ProductRepository;
//^^ this brings in our object that can access the SQL database(backend)
import Model.Product;

import java.util.List;





public class ProductService {
    //What can this do? first this service will work with a repository to access our back end SQL database for our store
    //also we can provide extra steps to our information gathered be the repository class here in the service class
    ProductRepository pr;

    //pruduct service constructor that allows the usage of getters
    public ProductService()
    {
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
    public void addProduct(Product p){

        Product existingProduct = pr.getProductByName(p.getName());

        if(existingProduct == null) {
           Product newProduct = new Product(p.getName(), p.getType(), p.getQuantity(), p.getPrice(), p.getPid());
            pr.addProduct(newProduct);
        }
    }
    public Product getProductByID(int pid){

        return pr.getProductByID(pid);
    }
    public void deleteProductByName(String name){
        name = name.replaceAll("_"," ");
        pr.deleteProductByName(name);
        }

    public void updateProductByName(String name, Product product) {
        name = name.replaceAll("_"," ");
        pr.updateProductByName(name,product);
    }
}


