import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculationWindow extends JFrame {
    private JLabel resultLabel;

    public CalculationWindow() {
        setTitle("Calculation Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Set the blue color scheme
        Color blueColor = new Color(0, 153, 255);
        Color lightBlueColor = new Color(153, 204, 255);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBackground(blueColor);

        JTextField num1Field = new JTextField();
        num1Field.setBackground(lightBlueColor);
        panel.add(num1Field);

        JTextField num2Field = new JTextField();
        num2Field.setBackground(lightBlueColor);
        panel.add(num2Field);

        JButton addButton = new JButton("Add");
        addButton.setBackground(lightBlueColor);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("+", num1Field.getText(), num2Field.getText());
            }
        });
        panel.add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBackground(lightBlueColor);
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("-", num1Field.getText(), num2Field.getText());
            }
        });
        panel.add(subtractButton);

        resultLabel = new JLabel();
        resultLabel.setForeground(Color.WHITE);
        panel.add(resultLabel);

        // Set the panel background color
        panel.setOpaque(true);
        panel.setBackground(blueColor);

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
                CalculationWindow window = new CalculationWindow();
                window.setVisible(true);
            }
        });
    }
}
