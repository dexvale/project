package dextersystem;

import java.util.ArrayList;
import java.util.Scanner;
// Class to represent a Product
class Product {
    String name;
    int quantity;
    double price;
    // Constructor to initialize a product
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    // Constructor to initialize a product
    public boolean decreaseQuantity(int amount) {
        if (this.quantity >= amount) {
            this.quantity -= amount;
            return true;
        }
        return false;
    }
}
// Class to represent the Admin functionality
class Admin {
    // List to store all products
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        // Add initial products to the list
        products.add(new Product("Hawaian Supreme Pan Pizza", 100, 449.21));
        products.add(new Product("Meat Lovers Pan Pizza", 100, 485.33));
        products.add(new Product("Pepperoni Lovers Pan Pizza", 100, 429.22));
        products.add(new Product("Seafood Supreme Pan Pizza", 100, 485.44));
        products.add(new Product("Carbonara Supreme Pan Pizza", 100, 485.66));
        products.add(new Product("Vegie Lovers Pan Pizza", 100, 419.55));
        products.add(new Product("Cheese Supreme Pizza", 100, 499.44));
        products.add(new Product("Bacon Supreme Pizza", 100, 499.22));
    }
    // Handling to add product
    public static void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\t\t\t\t\tEnter product name: ");
        String productName = sc.nextLine();
        System.out.print("\n\t\t\t\t\t\tEnter product quantity: ");
        int productQuantity = sc.nextInt();
        System.out.print("\n\t\t\t\t\t\tEnter product price: ");
        double productPrice = sc.nextDouble();
        
        products.add(new Product(productName, productQuantity, productPrice));
    }
    // Overloaded method to add a new product directly with parameters
    public static void addProduct(String productName, int productQuantity, double productPrice) {
    products.add(new Product(productName, productQuantity, productPrice));
}

    // To Print All Products
    public static void printProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("\t\t\t\t\t\t" + (i + 1) + ". " + product.name + "  - Quantity: " + product.quantity + " - Php " + product.price);
        }
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}

public class DexterSystem {
 
    public static void main(String[] args) {
        while (true) {
            product(); 
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\n\t\t\t\t\t\tPress 'm' to return main menu or press any other key to exit program: ");
            int b = sc.nextLine().toLowerCase().charAt(0);
            if (b == 'm') {
                
                continue;
            } else {
                
                System.out.println("\t\t\t\t\t\tExiting the program.....");
                break;
            }
        }
    }
    
    
    public static void product() {
        System.out.println("\t\t\t\t\t\t-------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\tWelcome to Pizza Hut!");
        System.out.println("\t\t\t\t\t\t=============================================================");
        System.out.println("\t\t\t\t\t\t-------------------------------------------------------------");
        Admin.printProducts();

        System.out.println("\n");
        // 1D Array
        String[] choices = {"1. New Customer", "2. Old Customer", "3. Admin", "4. Exit"};
        for (String str : choices) {
            System.out.println("\t\t\t\t\t\t" + str);
        }
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\t\t\t\t\tPlease Press(1/2/3): ");
        c = sc.nextLine().charAt(0);
        switch (c) {
            case '1' -> {
                
                newc.customer(); 
            }
            case '2' -> {
                
                oldc.customer(); 
            }
            case '3' -> {
               
                logIn();
                
            }
            case '4'->{
                System.exit(0);
               
            }
            
            default -> product();
        }
    }
    
    public static void logIn(){
        Scanner sc= new Scanner(System.in);
        String pass= "1234";
       String password; 
                char tryAgain;
                do{
                System.out.print("\t\t\t\t\t\tEnter a password: ");
                password = sc.nextLine();
                if(password.equals(pass)){
                
                Admin.addProduct();
                break;
                }else{
                    System.out.println("\t\t\t\t\t\tInvalid pasword!! Enter a correct password!");
                }
                }while(true);
        
        
    }

    // Class for handling new customers
    static class newc {
        static int id = 123; 
        static double total1 = 0;

        // Method for handling new customer details
        public static void customer() {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\t\t\t\t\t\tCustomer name: ");
            String customerName = sc.nextLine(); 
            System.out.printf("\t\t\t\t\t\tCustomer id: %d\n", id++);
            // Calling method to handle product selection and pricing
            prices(Admin.getProducts());
            NewCustomer nc = new NewCustomer();
            // Calling footer method to display footer
            nc.footer();
        }

        public static void prices(ArrayList<Product> products) {
            double tp = 0;
            double total = 0;
            Scanner pr = new Scanner(System.in);

            for (int j = 0; j < 100; j++) {
               // System.out.println("\n\t\t\t\t\t\t(Press [t/T] to calculate total : \n");
                System.out.print("\n\t\t\t\t\t\tEnter product number or Press [t/T] to calculate total: ");
                String input = pr.nextLine().toUpperCase(); // To uppercase string

                if ("T".equals(input)) {
                    break;
                }

                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= products.size()) {
                        Product product = products.get(choice - 1);
                        if (product.decreaseQuantity(1)) {
                            tp += product.price;
                            System.out.println("\t\t\t\t\t\tProduct: " + product.name);
                            System.out.println("\t\t\t\t\t\tPrice: Php " + product.price);
                        } else {
                            System.out.println("\t\t\t\t\t\tInsufficient quantity for: " + product.name);
                        }
                    } else {
                        System.out.print("\t\t\t\t\t\tPlease enter a valid product number");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\t\t\t\t\t\tPlease enter a valid product number");
                }
            }

            total += tp;
            total1 = total;
            double roundOff = Math.round(total);

            System.out.println("\t\t\t\t\t\tCalculating total...");
            System.out.println("\t\t\t\t\t\tTotal order: Php " + roundOff);
        }
    }

    // Class for handling old customers
    static class oldc {
        public static void customer() {
            Scanner pr = new Scanner(System.in);
            System.out.print("\n\t\t\t\t\t\tCustomer Id: ");
            int i = pr.nextInt();
            pr.nextLine();  // Consume the newline character
            if (i >= 123 && i <= newc.id) {
                // Calling method to handle product selection and pricing
                newc.prices(Admin.getProducts());
                System.out.println("\t\t\t\t\t\tYou got 5% discount");
                newc.total1 = newc.total1 - (0.05 * newc.total1);
                System.out.println("\t\t\t\t\t\tTotal with Discount: Php " + Math.ceil(newc.total1));
                
                NewCustomer nc = new OldCustomer();
                nc.footer();
            } else {
                System.out.println("\t\t\t\t\t\tSorry! You are not our old Customer");
                newc.customer();
            }
        }
    }
}
