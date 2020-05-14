package MenuInterface;

import Client.Client;
import Client.User;
import Storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    //    public ArrayList<User> UserList = new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        Storage storage = new Storage();
        Client client = new Client(storage);
        User user = new User(storage);

        System.out.println("Who are you?");
        System.out.println("1. Customer");
        System.out.println("2. Admin");
        System.out.println("-------------------------------------------------");
        System.out.print("Your choice: ");
        Scanner option = new Scanner(System.in);
        String choice = option.next();

        switch (choice){
            case "1":
                client.customerMenu();
                break;
            case "2":
                client.managerMenu();
                break;
            default:
                System.out.println("Wrong option, please option again !");
        }
//        client.managerMenu();
    }
}
