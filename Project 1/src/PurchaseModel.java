public class PurchaseModel {
    int PurchaseID, ProductID, CustomerID;
    double Price, Tax, Cost, Total, Quantity;
    String Date;


    public void setProductID(int productID) { this.ProductID = productID; }
    public void setPurchaseID(int purchaseIDIn) { this.PurchaseID = purchaseIDIn; }
    public void setCustomerID(int customerIDIn) { this.CustomerID = customerIDIn; }
    public void setQuantity(double quantity) {
        this.Quantity = quantity;
    }
    public void setPrice(double price) { this.Price = price; }
    public void setTax(double tax) { this.Tax = tax; }
    public void setCost(double cost) { this.Cost = cost; }
    public void setTotal(double total) {this.Total =total; }
    public void setDate(String date) { this.Date = date; }

    public int getPurchaseID() { return PurchaseID; }
    public int getCustomerID() { return CustomerID; }
    public int getProductID() { return ProductID; }
    public double getQuantity() { return Quantity; }
    public double getPrice() { return Price; }
    public double getTax() { return Tax; }
    public double getCost() { return Cost; }
    public double getTotal() { return Total; }
    public String getDate() { return Date; }

    public String toString() {
        return getPurchaseID() + ","+ getCustomerID() +"," + getProductID() + "," + getQuantity() + "," + getPrice() + "," + getTax() + "," + getCost() + "," + getTotal() + ",\"" + getDate() + "\"";
    }
}