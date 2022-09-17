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
                    System.out.println("Breed, Price, Stop");
                    String selection = recieve.nextLine();
                    if (selection.equals("Breed")) {
                        System.out.println("you picked breed");
                    } else if (selection.equals("Price")) {
                        System.out.println("you selected Price");
                    } else if (selection.equals("Stop")) {
                        System.out.println("You selected Stop");
                        look = false;

                    }
                }

            }
            else if(answer.equals("Restock")) {
                System.out.println("you have chosen to restock");
            }
            else{

            }
        }


    }
}
