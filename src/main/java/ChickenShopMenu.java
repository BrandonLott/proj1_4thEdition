//import Model.Product;
//import Service.ProductService;
//import Util.ConnectionUtil;
//
//import javax.management.StringValueExp;
//import java.io.BufferedReader;
//import java.sql.Connection;
//import java.util.Scanner;
//
//public class ChickenShopMenu {
//    public static void main(String[] args) {
////        Connection conn = ConnectionUtil.getConnection();
//
//        boolean visitingShop = true;
//        //create new painting service class, so I can use my methods in my Product service class ex .getProductByName...
//        ProductService ps = new ProductService();
//
//        while (visitingShop){
//            System.out.println("Welcome to my chicken shop");
//            System.out.println("What would you like to do");
//            System.out.println("Browse, Leave, Restock.");
//            Scanner recieve = new Scanner(System.in);
//            String answer = recieve.nextLine();
//            if(answer.equals("Leave")){
//                visitingShop = false;
//            }
//            else if (answer.equals("Browse")) {
//                for (int i = 0; i < ps.getAllProducts().size(); i++) {
//                    System.out.println(ps.getAllProducts().get(i));
//                }
//                boolean look = true;
//                LOOK:
//                while (look) {
//                    System.out.println("Select how you would like to browse from the following");
//                    System.out.println("Breed, Type, Stop");
//                    String selection = recieve.nextLine();
//                    if (selection.equals("Breed")) {
//                        System.out.println("What Breed are you looking for?");
//                     //variable breed to grab the breed from user
//                        String breed = recieve.nextLine();
//                        // breed sent to ps.getAllProductsByName() so that the users input can be used in that method of that class to find stuff in the database
//                        for (int i = 0; i < ps.getAllProductByName(breed).size(); i++) {
//                            System.out.println(ps.getAllProductByName(breed).get(i));
//                        }
//                    } else if (selection.equals("Price")) {
//                        System.out.println("What Type of Product are you looking for?");
//                   //variable aType added to allow user to put in a type of product
//                        String aType = recieve.nextLine();
//                        //aType assigned by the user gets sent to ps.getAll....
//                        for (int i = 0; i < ps.getAllProductByPrice(Double.parseDouble(aType)).size(); i++) {
//                            System.out.println(ps.getAllProductByPrice(Double.parseDouble(aType)).get(i));
//                        }
//                    } else if (selection.equals("Stop")) {
//                        System.out.println("You selected Stop");
//                        look = false;
//
//                    }
//                }
//
//            }
//            else if(answer.equals("Restock")) {
//                String name = recieve.nextLine();
//                String type = recieve.nextLine();
//                int quantity = recieve.nextInt();
//                String Garbage = recieve.nextLine();
//                double price = recieve.nextDouble();
//
//               // ps.addProduct(name,type,quantity,price);
//            }
//            else{
//
//            }
//        }
//
//
//    }
//}
