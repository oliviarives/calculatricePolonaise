package rpnpackage;

import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.ParseException;

public class SimpleRPNParser implements RPNParser {

    private Calc calculator;

    public SimpleRPNParser() {
        this.calculator = new RPNCalc();
    }

    //For UnitTest
    public SimpleRPNParser(Calc calc) {
        this.calculator = calc;
    }

    @Override
    public double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {

        // Split with spaces
        String[] elements = toParse.split(" ");

        // Process each element
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];

            // Check if it's an operator
            if (element.equals("+")) {
                calculator.add();
            }
            else if (element.equals("-")) {
                calculator.subtract();
            }
            else if (element.equals("*")) {
                calculator.multiply();
            }
            else if (element.equals("/")) {
                calculator.divide();
            }
            else {
                // Otherwise it's a number
                try {
                    double number = Double.parseDouble(element);
                    this.calculator.enterValue(number);
                }
                // Catch parsing errors
                catch (Exception e) {
                    throw new ParseException();
                }
            }
        }

        // Retrieve the result
        double result = calculator.displayValueOnTop();

        System.out.println(result);

        return result;
    }
}