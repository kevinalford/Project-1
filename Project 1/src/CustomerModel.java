public class CustomerModel {
    int CustomerID;
    String Name, Phone, PaymentInfo;

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }
    public void setName(String name) { this.Name = name; }
    public void setPhone(String phone) { this.Phone = phone; }
    public void setPaymentInfo(String paymentInfo) {
        this.PaymentInfo = paymentInfo;
    }

    public int getCustomerID() {
        return CustomerID;
    }
    public String getName() {
        return Name;
    }
    public String getPhone() {
        return Phone;
    }
    public String getPaymentInfo() {
        return PaymentInfo;
    }

    public String toString() {
        return getCustomerID() + ",'"+ getName() +"','" + getPhone() + "','" + getPaymentInfo()+"'";
    }

}
