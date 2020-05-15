package Client;

import Product.Product;
import Storage.Storage;

import java.util.ArrayList;

public class User {
    private ArrayList<Product> paidProduct; // = new ArrayList<>();
    private ArrayList<Product> cart; // = new ArrayList<>();
    private ArrayList<Product> currentProductList;

    public User(Storage storage) {
        this.currentProductList = storage.productsList;
        this.paidProduct = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    public void showpaidProducts() {
        if (this.paidProduct.size() > 0) {
            for (int i = 0; i < this.paidProduct.size(); i++) {
                System.out.println(this.paidProduct.get(i).toString());
            }
        }else {
            System.out.println("No product had paid !");
        }
    }

    public void showProductsInCart() {
//        System.out.println(this.cart);
        if (this.cart.size() > 0){
            for (int i = 0; i < this.cart.size(); i++) {
                System.out.println(this.cart.get(i).toString());
            }
        }else {
            System.out.println("Cart is empty !");
        }

    }

    public void removeCart(String id){
        if (this.cart.size() < 1){
            System.out.println("You don't have any products in cart !");
        }else {
            for (int i = 0; i < this.cart.size(); i++) {
                if (this.cart.get(i).getId().equals(id)) {
                    this.cart.remove(i);
                    System.out.println("Removed product from cart !");
                }
            }
        }
    }

    public void addCart(String id){
        for (int i = 0; i < this.currentProductList.size(); i++){
            if (id.equals(this.currentProductList.get(i).getId())){
                this.cart.add(this.currentProductList.get(i));
                System.out.println("Added product to cart !");
            }
        }
    }

    public void pay() {
        if (this.cart.size()>0){
            this.paidProduct.addAll(this.cart);
            this.cart.clear();
        }else {
            System.out.println("Your cart is empty, choose at least 1 product");
        }

    }

    public void sort(boolean type) {     // return về mảng sản phẩm
        ArrayList<Product> sortList = this.currentProductList;
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
        for (int i = 0; i < this.currentProductList.size(); i++) {
            if (this.currentProductList.get(i).getName().equals(productName)) {
                System.out.println(this.currentProductList.get(i).toString());
            }
        }
    }

    public void findProductById(String productId) {
        for (int i = 0; i < this.currentProductList.size(); i++) {
            if (this.currentProductList.get(i).getId().equals(productId)) {
                System.out.println(this.currentProductList.get(i).toString());
            }
        }
    }

    public void showAllProducts() {
        for (int i = 0; i < this.currentProductList.size(); i++) {
            System.out.println(this.currentProductList.get(i).toString());
        }
    }
}
