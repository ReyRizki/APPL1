
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RatePanel extends JPanel {
    private static final long serialVersionUID = 8723783211268116514L;
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    private JComboBox<String> cb;
    private JTextField textField;

    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel() {
        JLabel title = new JLabel("How much is that in dollars?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));

        // Set up the arrays for the currency conversions
        currencyName = new String[] { "Select the currency..", "European Euro",
                "Canadian Dollar", "Japanese Yen", "Australian Dollar",
                "Indian Rupee", "Mexican Peso" };

        rate = new double[] { 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880 };
        result = new JLabel(" ------------ ");
        add(title);

        // ComboBox
        cb = new JComboBox<String>(currencyName);
        cb.addActionListener(new ConvertListener());
        add(cb, BorderLayout.CENTER);

        // Text Field
        textField = new JTextField(16);
        textField.addActionListener(new ConvertListener());
        add(textField);

        add(result);
    }

    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ConvertListener implements ActionListener {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            try {
                int index = cb.getSelectedIndex();
                double amount = Double.parseDouble(textField.getText());
                double converted = amount * rate[index - 1];

                result.setText(amount + " " + currencyName[index] + " = "
                        + converted + " U.S. Dollars");
            } catch (NumberFormatException e) {
                result.setText("Input a number");
            } catch (ArrayIndexOutOfBoundsException e) {
                result.setText("Select a currency");
            }
        }
    }
}
