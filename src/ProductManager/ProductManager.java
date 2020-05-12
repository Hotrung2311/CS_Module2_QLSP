package ProductManager;

import Product.Product;
import Storage.Storage;

import java.util.ArrayList;

public class ProductManager {
    public ArrayList<Product> prlist = new ArrayList<>();
    public ProductManager(Storage stlist) {
        this.prlist = stlist.productsList;
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

    }
}
