package Product;

public class SmartPhone extends Product{
    public SmartPhone(){

    }
    public SmartPhone(String id, String name, int price, String description, String category){
        super(id, name, price, description, category);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
