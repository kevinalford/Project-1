import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataAdapter implements IDataAdapter {

    Connection conn = null;

    @Override
    public int connect(String absolutePath) {
        try {
            String url= absolutePath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established");
            return OPEN_CONNECTION_OK;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return OPEN_CONNECTION_FAILED;
        }
    }

    @Override
    public int disconnect() {
        try {
            conn.close();
            return CLOSE_CONNECTION_OK;
        } catch (Exception e) {
            return CLOSE_CONNECTION_FAILED;
        }
    }

    @Override
    public  ProductModel loadProduct(int productID) {
        ProductModel product = new ProductModel();
        try {
            String sql = "SELECT ProductID, Name, Price, Quantity FROM Products WHERE ProductID = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(sql);
            product.setProductID(results.getInt("ProductID"));
            product.setName(results.getString("Name"));
            product.setPrice(results.getDouble("Price"));
            product.setQuantity(results.getInt("Quantity"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public int saveProduct(ProductModel product) {
        String sql = "INSERT INTO Products(ProductID, Name, Price, TaxRate, Quantity) VALUES (" + product + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed")) {
                return PRODUCT_DUPLICATE_ERROR;
            }
        }
        return PRODUCT_SAVED_OK;
    }

    @Override
    public CustomerModel loadCustomer(int customerID) {
        CustomerModel customer = new CustomerModel();
        try {
            String sql = "SELECT CustomerID, Name, Phone, PaymentInfo FROM Customers WHERE CustomerID = " + customerID;
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(sql);
            customer.setCustomerID(results.getInt("CustomerID"));
            customer.setName(results.getString("Name"));
            customer.setPhone(results.getString("Phone"));
            customer.setPaymentInfo(results.getString("PaymentInfo"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public int savePurchase(PurchaseModel purchase) {
        String sql = "INSERT INTO Purchases VALUES (" + purchase + ")";
        System.out.println(sql);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed")) {
                return PURCHASE_DUPLICATE_ERROR;
            }
        }
        return PURCHASE_SAVED_OK;
    }

    @Override
    public PurchaseModel loadPurchase(int id) {
        PurchaseModel purchase = new PurchaseModel();
        try {
            String sql = "SELECT * FROM Purchases WHERE PurchaseID = " + id;
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(sql);
            purchase.setProductID(results.getInt("ProductID"));
            purchase.setCustomerID(results.getInt("CustomerID"));
            purchase.setQuantity(results.getInt("Quantity"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return purchase;
    }

    @Override
    public int saveCustomer(CustomerModel customer) {
        String sql = "INSERT INTO Customers(CustomerID, Name, Phone, PaymentInfo) VALUES (" + customer + ")";
        System.out.println(sql);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed")) {
                return PRODUCT_DUPLICATE_ERROR;
            }
        }
        return PRODUCT_SAVED_OK;
    }

}
