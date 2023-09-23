package com.JAVAEXERCISES;

import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class product{
    public String Product;
    public int price;
    public String category;
    public int quantity;
    public product(String product,int price,String category,int quantity){
        this.Product = product;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    public String getProduct(){

        return Product;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getCategory(){
        return category;
    }
    public int getPrice(){
        return price;
    }
    public void updateQuantity(int new_quantity){
        quantity = new_quantity;
    }public void updateName(String new_name){
        Product = new_name;
    }public void updatePrice(int new_price){
        price = new_price;
    }
}
public class Inventory_management_system {
    public static void main(String[] args) {
        product thing = new product("Biscuit",5,"Beverages",10);
        List<product> inventory = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nBasic Inventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Update Product Quantity , Name,Price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int User = 0;
            try {

             User = sc.nextInt();
            sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid option.");
                sc.nextLine();
                continue;
            }
            switch (User){
                
                case 1:
                    System.out.println("Enter product name");
                    String user_product = sc.nextLine();
                    System.out.println("Enter product price ");
                    int user_price = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter product category");
                    String user_cat = sc.nextLine();
                    System.out.println("Enter product quantity");
                    int user_quantity = sc.nextInt();
                    sc.nextLine();
                    product list = new product(user_product,user_price,user_cat,user_quantity);
                    inventory.add(list);
                    break;
                   
                case 2:
                        System.out.println("This is your product list: ");
                    for (product p:inventory) {
                        System.out.println("Product "+p.getProduct());
                        System.out.println("Price "+p.getPrice());
                        System.out.println("Category "+p.getCategory());
                        System.out.println("Quantity "+p.getQuantity());
                        break;
                    }
                case 3:
                    System.out.println("Enter 1 for update name");
                    System.out.println("Enter 2 for update quantity");
                    System.out.println("Enter 3 for update price");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the product name you want to change");
                            String Updatename = sc.nextLine();
                            System.out.println("Enter new product name");
                            String newname = sc.nextLine();

                            for (product name : inventory) {
                                if (name.getProduct().equalsIgnoreCase(Updatename)) {
                                    name.updateName(newname);
                                }
                                System.out.println("New product list: ");
                                System.out.println(name.getProduct());
                                System.out.println(name.getPrice());
                                System.out.println(name.getCategory());
                                System.out.println(name.getQuantity());
                            }
                            break;
                        case 2:
                            System.out.println("Enter the product name for changing value");
                            String productname = sc.nextLine();
                            System.out.println("Enter new product quantity");
                            int newquantity = sc.nextInt();

                            for (product name : inventory) {
                                if (name.getProduct().equalsIgnoreCase(productname)) {
                                    name.updateQuantity(newquantity);
                                }
                                System.out.println("New product list: ");
                                System.out.println(name.getProduct());
                                System.out.println(name.getPrice());
                                System.out.println(name.getCategory());
                                System.out.println(name.getQuantity());
                            }
                            break;
                            case 3:
                            System.out.println("Enter the product name for changing value");
                            String priceproductname = sc.nextLine();
                            System.out.println("Enter new product price");
                            int newprice = sc.nextInt();

                            for (product name : inventory) {
                                if (name.getProduct().equalsIgnoreCase(priceproductname)) {
                                    name.updatePrice(newprice);
                                }
                                System.out.println("New product list: ");
                                System.out.println(name.getProduct());
                                System.out.println(name.getPrice());
                                System.out.println(name.getCategory());
                                System.out.println(name.getQuantity());
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                case 4:
                    System.out.println("Thank you visit again! 👋");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
