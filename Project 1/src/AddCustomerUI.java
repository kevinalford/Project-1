import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerUI {

    public JFrame view = new JFrame();

    public JButton addButton = new JButton("ADD CUSTOMER");
    public JButton cancelButton = new JButton("CANCEL");

    public JTextField txtCustomerID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPhone = new JTextField(20);
    public JTextField txtPaymentInfo = new JTextField(20);

    public AddCustomerUI() {
        view.setTitle("Store Manager - Add Customer");
        view.setSize(600, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        String[] labels = {"CustomerID", "Name", "Phone", "PaymentInfo"};
        String[] dbTypes = {"SQLite", "Oracle"};
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel(labels[0], JLabel.TRAILING));
        line1.add(txtCustomerID);
        view.getContentPane().add(line1);
        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel(labels[1], JLabel.TRAILING));
        line2.add(txtName);
        view.getContentPane().add(line2);
        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel(labels[2], JLabel.TRAILING));
        line3.add(txtPhone);
        view.getContentPane().add(line3);
        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel(labels[3], JLabel.TRAILING));
        line4.add(txtPaymentInfo);
        view.getContentPane().add(line4);

        //refactor the above code!!!

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(addButton);
        panelButtons.add(cancelButton);
        view.getContentPane().add(panelButtons);

        addButton.addActionListener(new AddCustomerUI.AddButtonListener());

        cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        view.dispose();
                    }
        });
    }

    public void run() {
        view.setVisible(true);
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Test");
            CustomerModel customer = new CustomerModel();
            if (txtName.getText().length() == 0 || txtCustomerID.getText().length() == 0 || txtPhone.getText().length() == 0 || txtPaymentInfo.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "invalid entry! Make sure you fill all of the fields");
                return;
            }
            try {
                customer.setCustomerID(Integer.parseInt(txtCustomerID.getText()));
                customer.setName(txtName.getText());
                customer.setPhone(txtPhone.getText());
                customer.setPaymentInfo(txtPaymentInfo.getText());
                System.out.println(customer);
                if (StoreManager.getInstance().getDataAdapter().saveCustomer(customer) == 0)
                    JOptionPane.showMessageDialog(null, "You clicked on the Add button! You add the customer with the customer ID: " + customer.getCustomerID());
                else
                    JOptionPane.showMessageDialog(null, "The customer was not added Successfully");
            } catch (Exception error) {
                System.out.println(error.getMessage());
                return;
            }
        }

    }

}
