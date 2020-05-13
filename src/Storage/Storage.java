package Storage;

import Product.Product;
import ProductCrawler.ProductCrawler;
import com.sun.source.tree.IfTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Storage {
    public ArrayList<Product> productsList = new ArrayList();

    private boolean checkId(String[] arr, String id) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (id.equals(arr[i])) {
                result = true;
            }
        }
        return result;
    }

    public Storage() throws InterruptedException, IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("ProductList.txt"));
        String line = bufReader.readLine();

        ProductCrawler productCrawler = ProductCrawler.getInstance();
//        ProductCrawler productCrawler = new ProductCrawler();

        if (line == null) {
            System.out.println("File rỗng !");
            productsList = productCrawler.productCrawList;
        } else {
            while (line != null) {
                Product a = new Product();
                String[] data = line.split(", ");

                a.setCategory(data[0]);
                a.setId(data[1]);
                a.setName(data[2]);
                a.setPrice(Integer.parseInt(data[3]));
                a.setDescription(data[4]);

//                switch (data[0]) {
//                    case "Laptop":
//                        a.setCategory(data[0]);
//                        a.setId(data[1]);
//                        a.setName(data[2]);
//                        a.setPrice(Integer.parseInt(data[3]));
//                        a.setDescription(data[4]);
//                        break;
//                    case "SmartPhone":
//                        a.setCategory(data[0]);
//                        a.setId(data[1]);
//                        a.setName(data[2]);
//                        a.setPrice(Integer.parseInt(data[3]));
//                        a.setDescription(data[4]);
//                        break;
//                }
                productsList.add(a);
                line = bufReader.readLine();
            }

            // Thêm khi file product đã có sản phẩm
//            String[] existId = new String[productsList.size()];
//            for (int i = 0; i < productsList.size(); i++){
//                existId[i] = productsList.get(i).getId();
//            }
//
//            for (int i = 0; i < productCrawler.productCrawList.size(); i++) {
//                if(!checkId(existId, productCrawler.productCrawList.get(i).getId())){
//                    productsList.add(productCrawler.productCrawList.get(i));
//                }
//            }

            bufReader.close();
        }


    }

//        while (line != null) {
//            Product a = new Product();
//            String[] data = line.split(", ");
//
//            switch (data[0]) {
//                case "Laptop":
//                    a.setCategory(data[0]);
//                    a.setId(data[1]);
//                    a.setName(data[2]);
//                    a.setPrice(Integer.parseInt(data[3]));
//                    a.setDescription(data[4]);
//                    break;
//                case "SmartPhone":
//                    a.setCategory(data[0]);
//                    a.setId(data[1]);
//                    a.setName(data[2]);
//                    a.setPrice(Integer.parseInt(data[3]));
//                    a.setDescription(data[4]);
//                    break;
//            }
//            productsList.add(a);
//            line = bufReader.readLine();
//        }
//        bufReader.close();
//    }
}

//class testStorage{
//    public static void main(String[] args) throws IOException, InterruptedException {
//        Storage st = new Storage();
//        for (int i = 0; i < st.productsList.size(); i++){
//            System.out.println(st.productsList.get(i).toString());
//        }
//    }
//}
