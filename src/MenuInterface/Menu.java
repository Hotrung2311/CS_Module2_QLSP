package MenuInterface;

import Client.Client;
import Client.User;
import Storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException, InterruptedException {
        mainMenu();
    }

    private static void mainMenu() throws InterruptedException, IOException {
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
        System.out.println();

        switch (choice){
            case "1":
                client.customerMenu();
                break;
            case "2":
                System.out.print("Enter password: ");
                Scanner input = new Scanner(System.in).useDelimiter("\n");
                String password = input.next();
                if (password.equalsIgnoreCase("kiều anh xinh")){
                    client.managerMenu();
                }else {
                    System.out.println("Wrong password !");
                    System.out.println();
                    mainMenu();
                }
                break;
            default:
                System.out.println("Wrong option, please choose again !");
                System.out.println();
                mainMenu();
        }
    }
}
