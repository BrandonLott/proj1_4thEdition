
import Model.Product;
import Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.Map;


public class ShopAPI {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> ctx.result("Hello World!!"));
        app.get("/test/", ctx -> ctx.result("test"));
        app.get("/Products/", ctx -> ctx.json(ps.getAllProducts()));
        //App.get refers to what. /name of thing/{parameter}                                   String into an Int
        app.get("/Product/{pid}", ctx -> ctx.json(ps.getProductByID(Integer.parseInt(ctx.pathParam("pid")))));
        app.post("/Product/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(ctx.body(), Product.class);
            ps.addProduct(product);
        });
        //delete https://medium.com/@9cv9official/what-are-get-post-put-patch-delete-a-walkthrough-with-javascripts-fetch-api-17be31755d28

        //create endpoints to get needed information
        //create ways to access data from database on a website
        //for sending data app.post. "ctx -> " like an inline method closures, anonymous method.
        //follow endpoints through layers to ensure they work properly.


    }
}
