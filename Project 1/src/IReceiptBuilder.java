public interface IReceiptBuilder {
    /**
     * [Header:Store Information]
     *
     * [Customer]
     *
     * [Product]
     *
     * cost
     * tax
     * total
     *
     * [Footer]
     */


    public void appendHeader(String header);
    public void appendCustomer(CustomerModel customer);
    public void appendProduct(ProductModel product);
    public void appendPurchase(PurchaseModel purchase);
    public void appendFooter(String footer);

    public String toString();
}
