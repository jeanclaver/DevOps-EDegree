/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author vagrant
 */
import java.util.Scanner; //scanner class to take input from the user

public class Calculator {

    private static Scanner scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {  //loop to run the calculator continuously{
            scanner = new Scanner(System.in); //for the input from user
            System.out.println("Select the operation");
            System.out.println("1 for Addition");
            System.out.println("2 for Subtraction");
            System.out.println("3 for Multiplication");
            System.out.println("4 for Division");
            System.out.println("0 for EXIT\n");
            System.out.println("Enter the choice (1/2/3/4):");
            int option = scanner.nextInt(); //take the choice as an input from user
            /*
	         * if (option==0) System.out.println("EXIT"); System.exit(0);
             */
            if (option >= 1 && option <= 4) {
                System.out.println("Enter the first number:");
                double num1 = scanner.nextInt(); //take first number as an input
                System.out.println("Enter the second number:");
                double num2 = scanner.nextInt(); //take second number as an input
                double response = 0; //initialise an output variable
                switch (option) {  // //switch statement for the operator check
                    case 1:
                        response = num1 + num2;
                        break;
                    case 2:
                        response = num1 - num2;
                        break;
                    case 3:
                        response = num1 * num2;
                        break;
                    case 4:
                        response = num1 / num2;
                        break;
                    
                }
                System.out.println("Response =" + response);
            }else { //else it will check the operator either to exit or show error message
                if (option == 0){
                    System.out.println("EXIT");
                    System.exit(0); //exit the program if entered 0
                }else{
                    System.out.println("You have entered wrong choice"); //print wrong choice and continue the program in loop
                }
                
            }
        }
    }
}
