
import Model.Customer;
import Model.Product;
import Service.CustomerService;
import Service.OrderService;
import Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.util.Map;


public class ShopAPI {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        CustomerService cs = new CustomerService();
        OrderService os = new OrderService();

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        app.start(8888);

        app.get("/Products/", ctx -> ctx.json(ps.getAllProducts()));

        //App.get refers to what. /name of thing/{parameter}                                   String into an Int
        app.get("/Product/{pid}", ctx -> ctx.json(ps.getProductByID(Integer.parseInt(ctx.pathParam("pid")))));
        app.get("/Product/byName/{name}", ctx -> ctx.json(ps.getAllProductByName(ctx.pathParam("name"))));
        app.get("/Product/byPrice/{price}", ctx -> ctx.json(ps.getAllProductByPrice(Double.parseDouble(ctx.pathParam("price")))));
        app.delete("/Product/{name}", ctx -> ps.deleteProductByName(ctx.pathParam("name")));

        app.get("/Customers/byLast/{lastName}", ctx -> ctx.json(cs.getAllCustomersByLastName(ctx.pathParam("lastName"))));
        app.get("/Customers/byFirst/{firstName}", ctx -> ctx.json(cs.getAllCustomersByFirstName(ctx.pathParam("firstName"))));
        app.get("/Customers/byAddress{address}", ctx -> ctx.json(cs.getAllCustomersByAddress(ctx.pathParam("address"))));


        app.post("/Product/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(ctx.body(), Product.class);
            ps.addProduct(product);
        });
        app.post("/Customer/",ctx ->{
           ObjectMapper mapper = new ObjectMapper();
            Customer customer = mapper.readValue(ctx.body(),Customer.class);
            cs.addCustomer(customer);
        });

        //delete https://medium.com/@9cv9official/what-are-get-post-put-patch-delete-a-walkthrough-with-javascripts-fetch-api-17be31755d28

        //create endpoints to get needed information
        //create ways to access data from database on a website
        //for sending data app.post. "ctx -> " like an inline method closures, anonymous method.
        //follow endpoints through layers to ensure they work properly.


    }
}
