package org.example;
import rpnpackage.RPNParser;
import rpnpackage.SimpleRPNParser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RPNParser parser = new SimpleRPNParser();
        System.out.println("RPN Calc");
        System.out.println("Type '.exit' to quit");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input a RPN expression");
            System.out.print("-> ");
            String input = scanner.nextLine();

            try {
                parser.parseAndDisplayResult(input);
            } catch (Exception e) {
                System.out.println(e.getMessage()+", Try again or type '.exit' to quit");
            }
            if (input.equals(".exit")) {
                scanner.close();
                break;
            }
        }

    }
}