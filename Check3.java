package simple_calculator_with_java_jframe;

import javax.swing.*;
import java.awt.*;

public class Check3 {
    private JButton jbutton, submit, clear;
    private JTextField firstNumberField, secondNumberField, resultField;
    private JComboBox arithmeticSigns;
    private boolean isOperatorChosen = false;
    public Check3() {
        JFrame jframe = new JFrame();
        jframe.setTitle("Calculator");
        jframe.setLayout(new BorderLayout());
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setSize(300,400);

        JPanel numsRow1 = new JPanel(new GridLayout(1,3));
        JPanel numsRow2 = new JPanel(new GridLayout(1,3));
        JPanel numsRow3 = new JPanel(new GridLayout(1,3));
        JPanel numsRow4 = new JPanel(new GridLayout(1,3));
        JPanel allNumsRows = new JPanel(new GridLayout(4,3));

        numsRow1.add(createNumberButtons(1));
        numsRow1.add(createNumberButtons(2));
        numsRow1.add(createNumberButtons(3));
        numsRow2.add(createNumberButtons(4));
        numsRow2.add(createNumberButtons(5));
        numsRow2.add(createNumberButtons(6));
        numsRow3.add(createNumberButtons(7));
        numsRow3.add(createNumberButtons(8));
        numsRow3.add(createNumberButtons(9));
        numsRow4.add(createNumberButtons(0));
        allNumsRows.add(numsRow1);
        allNumsRows.add(numsRow2);
        allNumsRows.add(numsRow3);
        allNumsRows.add(numsRow4);

        createSigns();
        createField();

        JPanel field1 = new JPanel(new GridLayout(1,1));
        JPanel field2 = new JPanel(new GridLayout(1,1));
        JPanel field3 = new JPanel(new GridLayout(2,1));
        JPanel submitxClear = new JPanel(new GridLayout(1,2));
        JPanel allFields = new JPanel(new GridLayout(5,1));

//        field1.add(new JLabel("First Number:"));
        field1.add(firstNumberField);
//        field2.add(new JLabel("Second Number:"));
        field2.add(secondNumberField);

        field3.add(new JLabel("Result"));
        field3.add(resultField);



        submit = new JButton("Submit");
        submit.setToolTipText("Submit");
        clear = new JButton("C");
        clear.setToolTipText("Clear All");
        submit.addActionListener(e -> calculateResult());
        clear.addActionListener(event -> clearFunction());
        submitxClear.add(submit);
        submitxClear.add(clear);

        allFields.add(field1);
        allFields.add(arithmeticSigns);
        allFields.add(field2);
        allFields.add(submitxClear);
        allFields.add(field3);

        jframe.add(allNumsRows, BorderLayout.NORTH);
        jframe.add(allFields, BorderLayout.CENTER);

        jframe.setVisible(true);
    }

    private JButton createNumberButtons(int number){
        jbutton = new JButton(String.valueOf(number));
        jbutton.addActionListener(e -> {
            if (!isOperatorChosen){
                firstNumberField.setText(firstNumberField.getText()+number);
            } else if (isOperatorChosen=true){
                secondNumberField.setText(secondNumberField.getText()+number);
            }
        });
    return jbutton;
    }

    private void clearFunction(){
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
        isOperatorChosen = false;
    }
    private void createSigns() {
        // Create combobox
        String[] arithmeticSignsArray = {"+", "x", "/", "-"};
        arithmeticSigns = new JComboBox<>(arithmeticSignsArray);
        arithmeticSigns.addActionListener(event -> isOperatorChosen=true);
        arithmeticSigns.setToolTipText("Operators");
    }
    private void calculateResult() {
        try {
            int num1 = Integer.parseInt(firstNumberField.getText());
            int num2 = Integer.parseInt(secondNumberField.getText());
            double result = 0;

            String selectedOperation = (String) arithmeticSigns.getSelectedItem();
            switch (selectedOperation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = (double) num1 / num2;
                    }
                    break;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void createField(){
        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);
//        firstNumberField.setFocusable(true);
//        secondNumberField.setFocusable(true);
    }

    public static void main(String[] arg){
        new Check3();
    }
}
