package Client;

import ProductManager.ProductManager;
import Storage.Storage;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    Storage storage = new Storage();
    ProductManager productManager = new ProductManager(storage);

    public Client() throws IOException, InterruptedException {

    }
    public void menu(){
        System.out.println("");
        System.out.println("------*** Menu ***------");
        System.out.println("1. Show all products");
        System.out.println("2. Add new product");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product");
        System.out.println("5. Sort products list");
        System.out.println("6. Find product");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Your choose: ");
        Scanner input = new Scanner(System.in);
        String choose = input.next();
        switch (choose){
            case "1":
//                System.out.println("Show all products");
                // Show all products
                productManager.showAllProducts();
                break;
            case "2":

                System.out.println("Show all products");
                break;
            case "3":
                System.out.println("Show all products");
                break;
            case "4":
                System.out.println("Show all products");
                break;
            case "5":
                System.out.println("Show all products");
                break;
            case "6":
                System.out.println("Show all products");
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Wrong input, please input again !");
        }
        menu();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.menu();
    }
}
