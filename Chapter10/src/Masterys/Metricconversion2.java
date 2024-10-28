package Masterys;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Metricconversion2 {

    private JFrame frame;
    private JLabel lblResult;
    private JComboBox<String> conversionComboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Metricconversion2 window = new Metricconversion2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Metricconversion2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Set up the frame
        frame = new JFrame("Metric Conversion");
        frame.getContentPane().setBackground(new Color(192, 192, 192));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label for selecting a conversion type
        JLabel lblSelect = new JLabel("Select a conversion type:");
        lblSelect.setBounds(30, 20, 180, 20);
        frame.getContentPane().add(lblSelect);

        // ComboBox with conversion options
        String[] conversions = {
                "inches to centimeters",
                "feet to meters",
                "gallon to liters",
                "pound to kilograms"
        };

        conversionComboBox = new JComboBox<>(conversions);
        conversionComboBox.setBounds(200, 20, 180, 25);
        frame.getContentPane().add(conversionComboBox);

        // Label to display the conversion result
        lblResult = new JLabel();
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBounds(30, 70, 320, 25);
        frame.getContentPane().add(lblResult);

        // Action listener to handle selection changes in the ComboBox
        conversionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayConversionFormula();
            }
        });

        // Set default conversion formula when the GUI opens
        displayConversionFormula();
    }

    // Method to display the selected conversion formula
    private void displayConversionFormula() {
        String selectedConversion = (String) conversionComboBox.getSelectedItem();
        switch (selectedConversion) {
            case "inches to centimeters":
                lblResult.setText("1 inch = 2.54 centimeters");
                break;
            case "feet to meters":
                lblResult.setText("1 foot = 0.3048 meters");
                break;
            case "gallon to liters":
                lblResult.setText("1 gallon = 4.5461 liters");
                break;
            case "pound to kilograms":
                lblResult.setText("1 pound = 0.4536 kilograms");
                break;
            default:
                lblResult.setText("");
        }
    }
}
