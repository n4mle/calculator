import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationApp extends JFrame {
    private JLabel resultLabel;

    public CalculationApp() {
        setTitle("Calculation Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBackground(new Color(0, 153, 255));

        JTextField num1Field = new JTextField();
        num1Field.setBackground(new Color(153, 204, 255));
        panel.add(num1Field);

        JTextField num2Field = new JTextField();
        num2Field.setBackground(new Color(153, 204, 255));
        panel.add(num2Field);

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(153, 204, 255));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("+", num1Field.getText(), num2Field.getText());
            }
        });
        panel.add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBackground(new Color(153, 204, 255));
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("-", num1Field.getText(), num2Field.getText());
            }
        });
        panel.add(subtractButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
    }

    private void performOperation(String operator, String num1Str, String num2Str) {
        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        } catch (IllegalArgumentException ex) {
            resultLabel.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculationApp window = new CalculationApp();
                window.setVisible(true);
            }
        });
    }
}
