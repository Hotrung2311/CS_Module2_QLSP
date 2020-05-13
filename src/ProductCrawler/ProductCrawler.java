package ProductCrawler;

import Product.Product;

import java.util.ArrayList;

public class ProductCrawler {
    private static volatile ProductCrawler instance;

    public ArrayList<Product> productCrawList = new ArrayList<>();

    private ProductCrawler() throws InterruptedException {
        LaptopCrawler ltCrawler = new LaptopCrawler();
        SmartPhoneCrawler smCrawler = new SmartPhoneCrawler();

        Thread t1 = new Thread(ltCrawler);
        Thread t2 = new Thread(smCrawler);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        productCrawList.addAll(ltCrawler.ltList);
        productCrawList.addAll(smCrawler.smList);
    }
    public static ProductCrawler getInstance() throws InterruptedException {
        if (instance == null){
//            instance = new ProductCrawler();
            instance = new ProductCrawler();
        }
        return instance;
    }
}
//class testProductCrawler{
//    public static void main(String[] args) throws InterruptedException {
//        ProductCrawler pdc = new ProductCrawler();
//        for (int i =0; i < pdc.productCrawList.size(); i++){
//            System.out.println(pdc.productCrawList.get(i).toString());
//        }
//    }
//}
