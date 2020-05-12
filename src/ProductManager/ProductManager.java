package ProductManager;

import Product.Product;
import Storage.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductManager {
    public ArrayList<Product> prlist = new ArrayList<>();
    public ProductManager(Storage stlist) {
        this.prlist = stlist.productsList;
        update();
    }

    public void showAllProducts(){
        for (int i = 0; i<this.prlist.size(); i++){
            System.out.println(this.prlist.get(i).toString());
        }
    }

    public void addProduct() {

    }
    public void editProduct(){

    }
    public void deleteProduct(){

    }
    public void sort(){     // return về mảng sản phẩm

    }
    public void findProduct(){

    }
    public void update(){
        try {
            FileWriter writer = new FileWriter("ProductList.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < this.prlist.size(); i++) {
                Product updateProduct = this.prlist.get(i);
                String content = updateProduct.getCategory()+ ", " + updateProduct.getId() + ", " + updateProduct.getName() + ", " + updateProduct.getPrice() + ", " + updateProduct.getDescription();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
