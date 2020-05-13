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

    public void menu() {
        System.out.println("");
        System.out.println("------------------*** Menu ***------------------");
        System.out.println("1. Show all products");
        System.out.println("2. Add new product");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product by id");
        System.out.println("5. Sort products list");
        System.out.println("6. Find product");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------");
        System.out.print("Your choose: ");
        Scanner option = new Scanner(System.in);
        String choose = option.next();

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        switch (choose) {
            case "1":
                // Show all products
                productManager.showAllProducts();
                break;
            case "2":
                // Add new product
                String id = "";
                System.out.print("New product id: ");
                id = input.nextLine();
                while (productManager.checkExistId(id)){
                    System.out.println("This id already exist !");
                    System.out.print("New product id: ");
                    id = input.next();
                }

                System.out.print("Categoty: ");
                String category = input.next();

                System.out.print("Name: ");
                String name = input.next();

                System.out.print("Price: ");
                String price = input.next();

                System.out.print("Description: ");
                String description = input.next();
                productManager.addProduct(category, id, name, price, description);
                break;
            case "3":
                // Edit product
                System.out.println("Edit product id: ");
                String editId = input.next();
                System.out.println("New product name: ");
                String editName = input.next();
                System.out.println("New product price: ");
                String editPrice = input.next();
                System.out.println("New product description: ");
                String editDescription = input.next();
                System.out.println("New product category: ");
                String editCategory = input.next();
                productManager.editProduct(editId, editName, editPrice, editDescription, editCategory);
                break;
            case "4":
                // Delete
                String deleteId = option.next();
                productManager.deleteProduct(deleteId);
                break;
            case "5":
                // Sort
                System.out.println("Sort option:");
                System.out.println("1. Ascending");
                System.out.println("2. Descending ");
                System.out.print("Your choose: ");
                int sortOption = option.nextInt();
                switch (sortOption){
                    case 1:
                        System.out.println("");
                        System.out.println("Ascending price list");
                        productManager.sort(true);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Descending price list");
                        productManager.sort(false);
                        break;
                }

                break;
            case "6":
                // Find product
                System.out.println("Find option:");
                System.out.println("1. Find by name");
                System.out.println("2. Find by id ");
                System.out.print("Your choose: ");
                int findOption = option.nextInt();
                switch (findOption){
                    case 1:
                        System.out.print("Input product name: ");
                        String productName = input.next();
                        productManager.findProductByName(productName);
                        break;
                    case 2:
                        System.out.print("Input product id: ");
                        String productId = input.next();
                        productManager.findProductById(productId);
                        break;
                }
                break;
            case "0":
                productManager.update();
                System.exit(0);
            default:
                System.out.println("Wrong option, please option again !");
        }
        menu();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.menu();
    }
}
