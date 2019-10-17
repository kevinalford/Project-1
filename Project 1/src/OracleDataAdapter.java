public class OracleDataAdapter implements IDataAdapter {


    @Override
    public int connect(String absPath) {
        return 0;
    }

    @Override
    public int disconnect() {
        return CLOSE_CONNECTION_OK;
    }

    @Override
    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVED_OK;
    }

    @Override
    public ProductModel loadProduct(int id) {
        return null;
    }

    @Override
    public int saveCustomer(CustomerModel model) {
        return 1;
    }

    @Override
    public CustomerModel loadCustomer(int id) {
        return null;
    }

    @Override
    public int savePurchase(PurchaseModel purchase) {
        return 0;
    }

    @Override
    public PurchaseModel loadPurchase(int id) {
        return null;
    }


}
