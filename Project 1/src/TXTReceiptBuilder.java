public class TXTReceiptBuilder implements IReceiptBuilder {

    StringBuilder sb = new StringBuilder();

    @Override
    public void appendHeader(String header) {
        sb.append(header).append("\n");
    }

    @Override
    public void appendCustomer(CustomerModel customer) {
        sb.append("Customer ID: ").append(customer.getCustomerID()).append("\n");
        sb.append("Customer Name: ").append(customer.getName()).append("\n");
    }

    @Override
    public void appendProduct(ProductModel product) {
        sb.append("Product ID: ").append(product.getProductID()).append("\n");
        sb.append("Product Name: ").append(product.getName()).append("\n");
        sb.append("Product Price: ").append(product.getPrice()).append("\n");
    }

    @Override
    public void appendPurchase(PurchaseModel purchase) {
        sb.append("Purchase ID: ").append(purchase.getPurchaseID()).append("\n");
        sb.append("Cost: ").append(purchase.getCost()).append(" | ");
        sb.append("Tax: ").append(purchase.getTax()).append(" | ");
        sb.append("Total Cost: ").append(purchase.getTotal()).append("\n");
    }

    @Override
    public void appendFooter(String footer) {
        sb.append(footer).append("\n");
    }

    public String toString() {
        return sb.toString();
    }
}
