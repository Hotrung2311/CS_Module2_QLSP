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

    public boolean checkExistId(String id) {
        boolean result = false;
        for (int i = 0; i < this.prlist.size(); i++) {
            if (id.equals(this.prlist.get(i).getId())) {
                result = true;
            }
        }
        return result;
    }

    public void showAllProducts() {
        for (int i = 0; i < this.prlist.size(); i++) {
            System.out.println(this.prlist.get(i).toString());
        }
    }

    public void addProduct(String category, String id, String name, String price, String description) {
        Product product = new Product();
        product.setCategory(category);
        product.setId(id);
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setDescription(description);

        this.prlist.add(product);
        update();
    }

    public void editProduct(String id, String name, String price, String description, String category) {
        for (int i = 0; i < this.prlist.size(); i++){
            if (id.equals(this.prlist.get(i).getId())){
                this.prlist.get(i).setName(name);
                this.prlist.get(i).setCategory(category);
                this.prlist.get(i).setPrice(Integer.parseInt(price));
                this.prlist.get(i).setDescription(description);
            }
        }
        update();
    }

    public void deleteProduct(String id) {
        for (int i = 0; i < this.prlist.size(); i++) {
            if (this.prlist.get(i).getId().equals(id)) {
                this.prlist.remove(i);
            }
        }
        update();
    }

    public void sort(boolean type) {     // return về mảng sản phẩm
        ArrayList<Product> sortList = this.prlist;
        Product tempPro;
        if (type) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                for (int j = 0; j < sortList.size() - 1; j++) {
                    if (sortList.get(j).getPrice() > sortList.get(j + 1).getPrice()) {
                        Product temp;
                        temp = sortList.get(j);
                        sortList.set(j, sortList.get(j + 1));
                        sortList.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < sortList.size() - 1; i++) {
                for (int j = 0; j < sortList.size() - 1; j++) {
                    if (sortList.get(j).getPrice() < sortList.get(j + 1).getPrice()) {
                        Product temp;
                        temp = sortList.get(j);
                        sortList.set(j, sortList.get(j + 1));
                        sortList.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < sortList.size(); i++) {
//            System.out.print("Product " + (Integer) (i + 1) + ": ");
            System.out.println(sortList.get(i).toString());

        }
    }

    public void findProductByName(String productName) {
        for (int i = 0; i < this.prlist.size(); i++) {
            if (this.prlist.get(i).getName().equals(productName)) {
                System.out.println(this.prlist.get(i).toString());
            }
        }
    }

    public void findProductById(String productId) {
        for (int i = 0; i < this.prlist.size(); i++) {
            if (this.prlist.get(i).getId().equals(productId)) {
                System.out.println(this.prlist.get(i).toString());
            }
        }
    }

    public void update() {
        try {
            FileWriter writer = new FileWriter("ProductList.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < this.prlist.size(); i++) {
                Product updateProduct = this.prlist.get(i);
                String content = updateProduct.getCategory() + ", " + updateProduct.getId() + ", " + updateProduct.getName() + ", " + updateProduct.getPrice() + ", " + updateProduct.getDescription();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
