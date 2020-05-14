package Client;

import ProductManager.ProductManager;
import Storage.Storage;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    //    public Storage storage = new Storage();
    ProductManager productManager; // = new ProductManager(storage);
    User customer;

    public Client(Storage storage) throws IOException, InterruptedException {
        this.productManager = new ProductManager(storage);
        this.customer = new User(storage);
    }

    public void managerMenu() {
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
        System.out.print("Your choice: ");
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
                while (productManager.checkExistId(id)) {
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
                System.out.print("Edit product id: ");
                String editId = input.next();
                System.out.print("New product name: ");
                String editName = input.next();
                System.out.print("New product price: ");
                String editPrice = input.next();
                System.out.print("New product description: ");
                String editDescription = input.next();
                System.out.print("New product category: ");
                String editCategory = input.next();
                productManager.editProduct(editId, editName, editPrice, editDescription, editCategory);
                break;
            case "4":
                // Delete
                System.out.print("Delete product id: ");
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
                switch (sortOption) {
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
                switch (findOption) {
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
        managerMenu();
    }

    public void customerMenu() {
        System.out.println("");
        System.out.println("------------------*** Menu ***------------------");
        System.out.println("1. Show all products");
        System.out.println("2. Add product to cart");
        System.out.println("3. Remove product from cart");
        System.out.println("4. Show products in cart");
        System.out.println("5. Show paid products");
        System.out.println("6. Sort products list");
        System.out.println("7. Find product");
        System.out.println("8. Pay");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------");
        System.out.print("Your choice: ");
        Scanner option = new Scanner(System.in);
        String choice = option.next();

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        switch (choice) {
            case "1":
                customer.showAllProducts();
                break;
            case "2":
                System.out.print("Input product id: ");
                String addId = input.next();
                customer.addCart(addId);
                System.out.println("Added product to cart !");
                break;
            case "3":
                System.out.print("Input product id: ");
                String removeId = input.next();
                customer.removeCart(removeId);
                System.out.println("Removed product from cart !");
                break;
            case "4":
                customer.showProductsInCart();
                break;
            case "5":
                customer.showpaidProducts();
                break;
            case "6":
                System.out.println("Sort option:");
                System.out.println("1. Ascending");
                System.out.println("2. Descending ");
                System.out.print("Your choose: ");
                int sortOption = option.nextInt();
                switch (sortOption) {
                    case 1:
                        System.out.println("");
                        System.out.println("Ascending price list");
                        customer.sort(true);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Descending price list");
                        customer.sort(false);
                        break;
                }

                break;
            case "7":
                System.out.println("Find option:");
                System.out.println("1. Find by name");
                System.out.println("2. Find by id ");
                System.out.print("Your choose: ");
                int findOption = option.nextInt();
                switch (findOption) {
                    case 1:
                        System.out.print("Input product name: ");
                        String productName = input.next();
                        customer.findProductByName(productName);
                        break;
                    case 2:
                        System.out.print("Input product id: ");
                        String productId = input.next();
                        customer.findProductById(productId);
                        break;
                }
                break;
            case "8":
                System.out.print("Confirm your pay (y/n): ");
                String confirm = input.next();
                switch (confirm){
                    case "y":
                        customer.pay();
                        break;
                    case "n":
                        break;
                    default:
                        System.out.println("Payment failed !");
                }
                customerMenu();
            case "0":
                //productManager.update();
                System.exit(0);
            default:
                System.out.println("Wrong option, please option again !");
        }
        customerMenu();
    }

}

//class testMenu{
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Storage storage = new Storage();
//        Client client = new Client(storage);
//        User user = new User(storage);
//
//        System.out.println("Who are you?");
//        System.out.println("1. Customer");
//        System.out.println("2. Admin");
//        System.out.println("-------------------------------------------------");
//        System.out.print("Your choice: ");
//        Scanner option = new Scanner(System.in);
//        String choice = option.next();
//
//        switch (choice){
//            case "1":
//                break;
//            case "2":
//                client.managerMenu();
//                break;
//            default:
//                System.out.println("Wrong option, please option again !");
//        }
////        client.managerMenu();
//    }
//}
