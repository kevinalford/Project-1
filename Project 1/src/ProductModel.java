public class ProductModel {
    int ProductID;
    String Name, Vendor, Description;
    double Price, Quantity;

    public void setProductID(int productID) { this.ProductID = productID; }
    public void setName(String name) { this.Name = name; }
    public void setVendor(String vendor) { this.Vendor = vendor; }
    public void setDescription(String description) { this.Description = description; }
    public void setPrice(double price) { this.Price = price; }
    public void setQuantity(double quantity) {
        this.Quantity = quantity;
    }

    public int getProductID() { return ProductID; }
    public String getName() {
        return Name;
    }
    public String getVendor() { return Vendor; }
    public String getDescription() { return Description; }
    public double getPrice() { return Price; }
    public double getQuantity() { return Quantity; }

    public String toString() {
        return getProductID() + ",'"+ getName() +"'," + getPrice() + "," + getQuantity();
    }

}
