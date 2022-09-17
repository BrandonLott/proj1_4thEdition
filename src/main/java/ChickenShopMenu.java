import Service.ProductService;
import Util.ConnectionUtil;

import java.io.BufferedReader;
import java.sql.Connection;
import java.util.Scanner;

public class ChickenShopMenu {
    public static void main(String[] args) {
//        Connection conn = ConnectionUtil.getConnection();

        boolean visitingShop = true;
        //create new painting service class, so I can use my methods in my Product service class ex .getProductByName...
        ProductService ps = new ProductService();

        while (visitingShop){
            System.out.println("Welcome to my chicken shop");
            System.out.println("What would you like to do");
            System.out.println("Browse, Leave, Restock.");
            Scanner recieve = new Scanner(System.in);
            String answer = recieve.nextLine();
            if(answer.equals("Leave")){
                visitingShop = false;
            }
            else if (answer.equals("Browse")) {
                boolean look = true;
                LOOK:
                while (look) {
                    System.out.println("Select how you would like to browse from the following");
                    System.out.println("Breed, Type, Stop");
                    String selection = recieve.nextLine();
                    if (selection.equals("Breed")) {
                        System.out.println("What Breed are you looking for?");
                     //variable breed to grab the breed from user
                        String breed = recieve.nextLine();
                        // breed sent to ps.getAllProductsByName() so that the users input can be used in that method of that class to find stuff in the database
                        System.out.println(ps.getAllProductByName(breed));
                    } else if (selection.equals("Type")) {
                   //variable aType added to allow user to put in a type of product
                        String aType = recieve.nextLine();
                        //aType assigned by the user gets sent to ps.getAll....
                        System.out.println(ps.getAllProductByType(aType));
                    } else if (selection.equals("Stop")) {
                        System.out.println("You selected Stop");
                        look = false;

                    }
                }

            }
            else if(answer.equals("Restock")) {
                String name = recieve.nextLine();
                String type = recieve.nextLine();
                int quantity = recieve.nextInt();
                String Garbage = recieve.nextLine();
                double price = recieve.nextDouble();
                int pid = 0;
                ps.addProduct(name,type,quantity,price,pid);
            }
            else{

            }
        }


    }
}
