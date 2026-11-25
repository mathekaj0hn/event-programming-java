
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void handleNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        String digit = button.getText();

        if (startNewNumber || display.getText().equals("0")
                || display.getText().equals("Error")) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        try {
            Button button = (Button) event.getSource();

            firstOperand = Double.parseDouble(display.getText());
            operator = button.getText();
            startNewNumber = true;

        } catch (NumberFormatException e) {
            display.setText("Error");
            startNewNumber = true;
        }
    }

    @FXML
    private void handleEquals(ActionEvent event) {
        if (operator.isEmpty()) {
            return;
        }

        try {
            double secondOperand = Double.parseDouble(display.getText());
            double result;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;

                case "-":
                    result = firstOperand - secondOperand;
                    break;

                case "*":
                    result = firstOperand * secondOperand;
                    break;

                case "/":
                    if (secondOperand == 0) {
                        display.setText("Error");
                        operator = "";
                        startNewNumber = true;
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;

                default:
                    return;
            }

            display.setText(formatResult(result));
            operator = "";
            startNewNumber = true;

        } catch (NumberFormatException e) {
            display.setText("Error");
            operator = "";
            startNewNumber = true;
        }
    }

    @FXML
    private void handleClear(ActionEvent event) {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        }
        return String.valueOf(result);
    }
}

