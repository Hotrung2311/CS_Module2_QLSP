package Storage;

import Product.Product;
import ProductCrawler.ProductCrawler;
import com.sun.source.tree.IfTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    public ArrayList<Product> productsList = new ArrayList();
    ;

    public Storage() throws InterruptedException, IOException {
//        productsList = new ArrayList<>();
//        ProductCrawler productCrawler = new ProductCrawler();


        BufferedReader bufReader = new BufferedReader(new FileReader("ProductList.txt"));
        String line = bufReader.readLine();

        if (line == null) {
            System.out.println("File rỗng !");
            ProductCrawler productCrawler = new ProductCrawler();
            productsList = productCrawler.productCrawList;
        }

        while (line != null) {
            Product a = new Product();
            String[] data = line.split(", ");

            switch (data[0]) {
                case "Laptop":
                    a.setCategory(data[0]);
                    a.setId(data[1]);
                    a.setName(data[2]);
                    a.setPrice(Integer.parseInt(data[3]));
                    a.setDescription(data[4]);
                    break;
                case "SmartPhone":
                    a.setCategory(data[0]);
                    a.setId(data[1]);
                    a.setName(data[2]);
                    a.setPrice(Integer.parseInt(data[3]));
                    a.setDescription(data[4]);
                    break;
            }
            productsList.add(a);
            line = bufReader.readLine();
        }
        bufReader.close();
    }
}

//class testStorage{
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Storage st = new Storage();
//        for (int i = 0; i < st.productsList.size(); i++){
//            System.out.println(st.productsList.get(i).toString());
//        }
//    }
//}
