abstract public interface IDataAdapter {

    public static final int PURCHASE_SAVED_OK = 300;
    public static final int PURCHASE_DUPLICATE_ERROR =301;

    public static final int PRODUCT_SAVED_OK = 0;
    public static final int PRODUCT_DUPLICATE_ERROR = 1;

    public static final int OPEN_CONNECTION_OK= 100;
    public static final int OPEN_CONNECTION_FAILED = 101;

    public static final int CLOSE_CONNECTION_OK = 200;
    public static final int CLOSE_CONNECTION_FAILED = 201;

    public int connect(String absPath);
    public int disconnect();

    public int saveProduct(ProductModel model);
    public ProductModel loadProduct(int id);

    public int saveCustomer(CustomerModel model);
    public CustomerModel loadCustomer(int id);

    public int savePurchase(PurchaseModel purchase);
    public PurchaseModel loadPurchase(int id);


}
