package Product;

public class Laptop extends Product{
    public Laptop(){

    }
    public Laptop(String id, String name, int price, String description, String category){
        super(id, name, price, description, category);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
