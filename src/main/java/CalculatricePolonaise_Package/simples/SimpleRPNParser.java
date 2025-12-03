package CalculatricePolonaise_Package.simples;

import CalculatricePolonaise_Package.exceptions.DivideByZeroException;
import CalculatricePolonaise_Package.exceptions.NotEnoughOperandsOnStackException;
import CalculatricePolonaise_Package.interfaces.Calc;

import java.text.ParseException;

public class SimpleRPNParser implements CalculatricePolonaise_Package.interfaces.RPNParser {

    Calc calculator = new NPICalc();

    @Override
    public double parseAndDisplayResult(String toParse) throws
            NotEnoughOperandsOnStackException, DivideByZeroException, ParseException {

        if (toParse == null || toParse.trim().isEmpty()) {
            throw new ParseException("Empty expression", 0);
        }

        // Split with spaces
        String[] elements = toParse.split("\\s+");

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
                    double nombre = Double.parseDouble(element);
                    calculator.enterValue(nombre);
                }
                // Catch parsing errors
                catch (Exception e) {
                    throw new ParseException("Invalid Expression " + element, 0);
                }
            }
        }

        // Retrieve the result
        double result = calculator.displayValueOnTop();

        // If the double is an integer, convert it to int for display
        if (result == (int) result) {
            System.out.println("The result is: " + (int) result);
        } else {
            System.out.println("The result is: " + result);
        }
        return result;
    }

}
