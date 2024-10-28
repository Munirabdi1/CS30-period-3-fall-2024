package Masterys;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocalBank {

    private JFrame frame;
    private JTextField txtFirstName, txtLastName, txtAmount, txtBalance, txtAccountNumber;
    private JComboBox<String> actionComboBox;
    private JLabel lblBalance;
    private double balance = 0.0;

    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(() -> {
            try {
                LocalBank window = new LocalBank();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LocalBank() {
        initialize();
    }

    private void initialize() {
        // Set up the frame
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblAction = new JLabel("Select an action:");
        lblAction.setBounds(30, 20, 150, 14);
        frame.getContentPane().add(lblAction);

        // ComboBox for action selection
        actionComboBox = new JComboBox<>(new String[]{"Deposit", "Withdraw"});
        actionComboBox.setBounds(170, 17, 150, 22);
        frame.getContentPane().add(actionComboBox);

        JLabel lblAccountNumber = new JLabel("Account number:");
        lblAccountNumber.setBounds(30, 50, 150, 14);
        frame.getContentPane().add(lblAccountNumber);

        txtAccountNumber = new JTextField();
        txtAccountNumber.setBounds(170, 47, 150, 22);
        frame.getContentPane().add(txtAccountNumber);
        txtAccountNumber.setColumns(10);

        JLabel lblAmount = new JLabel("Amount of deposit/withdraw:");
        lblAmount.setBounds(30, 80, 180, 14);
        frame.getContentPane().add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(220, 77, 100, 22);
        frame.getContentPane().add(txtAmount);
        txtAmount.setColumns(10);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(30, 110, 150, 14);
        frame.getContentPane().add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(170, 107, 150, 22);
        frame.getContentPane().add(txtFirstName);
        txtFirstName.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(30, 140, 150, 14);
        frame.getContentPane().add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(170, 137, 150, 22);
        frame.getContentPane().add(txtLastName);
        txtLastName.setColumns(10);

        JLabel lblBalanceLabel = new JLabel("Beginning Balance:");
        lblBalanceLabel.setBounds(30, 170, 150, 14);
        frame.getContentPane().add(lblBalanceLabel);

        lblBalance = new JLabel("$0.00");
        lblBalance.setBounds(170, 170, 150, 14);
        frame.getContentPane().add(lblBalance);

        JButton btnProcessTransaction = new JButton("Process Transaction");
        btnProcessTransaction.setBounds(120, 210, 180, 23);
        frame.getContentPane().add(btnProcessTransaction);

        // Action listener for processing the transaction
        btnProcessTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processTransaction();
            }
        });
    }

    // Function to process the deposit/withdrawal
    private void processTransaction() {
        String action = (String) actionComboBox.getSelectedItem();
        String accountNumber = txtAccountNumber.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        double amount = Double.parseDouble(txtAmount.getText());

        if (accountNumber.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
   
       
        if (action.equals("Deposit")) {
            balance += amount;
        } else if (action.equals("Withdraw")) {
            if (amount > balance) {
                JOptionPane.showMessageDialog(frame, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            balance -= amount;
        }

        // Update the balance label
        lblBalance.setText(String.format("$%.2f", balance));

    }
}
