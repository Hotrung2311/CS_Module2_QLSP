package Product;

public class Product {
    protected String id;
    protected String name;
    protected int price;
    protected String description;
    protected String category;

    public Product(){

    }

    public Product(String id, String name, int price, String description, String category){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "category: " + category +
                ", id: " + id +
                ", name: " + name +
                ", price : " + price +
                ", description: " + description;
    }
}
