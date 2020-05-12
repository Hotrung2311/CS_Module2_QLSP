package ProductCrawler;

import Product.Product;
import Product.Laptop;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartPhoneCrawler implements Runnable{
    public ArrayList<Product> smList;
    public SmartPhoneCrawler(){

    }

    public void run() {
        smList = new ArrayList<>();
        String path1 = "https://fptshop.com.vn/dien-thoai/apple-iphone";
        String p1 = "'Home','(.*?)',(.*?),(.*?),0000,.*href=\"(.*?)\" title=";

        crawl(path1, p1);
//        printAll();
    }

    public void crawl(String webPath, String pattern) {
        try {
            URL url = new URL(webPath);

            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            // close scanner
            scanner.close();

//            System.out.println(content);

            // remove all new line
            content = content.replaceAll("\\n+", "");

            // regex
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(content);
            while (matcher.find()) {
                Product laptop = new Laptop();
                laptop.setName(matcher.group(1));
                laptop.setId(matcher.group(2));
                laptop.setPrice(Integer.parseInt(matcher.group(3)));
                laptop.setDescription("https://fptshop.com.vn" + matcher.group(4));
                laptop.setCategory("SmartPhone");
                this.smList.add(laptop);
            }

            saveProduct();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProduct() {
        String fileName = "SmartPhoneList.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(writer);
            for(Product pr:this.smList) {
                String laptopsInfo = pr.getCategory() + ", " + pr.getId() + ", " + pr.getName() + ", " + pr.getPrice() + ", " + pr.getDescription();
                bw.write(laptopsInfo);
                bw.newLine();
            }
            bw.close();

        } catch (IOException var6) {
            System.err.format("IOException: %s%n", var6);
        }
    }
    public void printAll(){
        for (int i = 0; i < smList.size(); i++){
            System.out.println(smList.get(i).toString());
        }
    }
}
class testSmartPhoneCrawler{
    public static void main(String[] args) {
        SmartPhoneCrawler a = new SmartPhoneCrawler();
        Thread t = new Thread(a);
        t.start();
    }
}

