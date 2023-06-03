/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightconversion;

import java.util.Scanner;

/**
 *
 * @author vagrant
 */
public class WeightConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double kgweight, gramweight, poundweight, ounceweight;
        while (true) {  //loop to run the calculator continuously{
            Scanner userInput = new Scanner(System.in); //for the input from user
            System.out.println("--- Weight Conversion ---");
            System.out.println("Which operation you want to perform:");
            System.out.println("1 for Kilogram -> Gram = (kilogram_value * 1000) grams");
            System.out.println("2 for Gram -> Kilogram = (gram_value / 1000) kilograms");
            System.out.println("3 for Pound -> Ounce = (pound_value * 16) oz");
            System.out.println("4 for Ounce -> Pound = (ounce_value / 16) lb");
            System.out.println("5 for Kilogram -> Pound = (kilogram_input * 2.205) lb");
            System.out.println("6 for Pound -> Kilogram = (pound_input / 2.205) kg");
            System.out.println("0 for Exit\n");
            System.out.println("Enter your option:");
            int option = userInput.nextInt(); //take the choice as an input from user
            /*
	    * if (choice==0) System.out.println("EXIT"); System.exit(0);
             */
            if (option >= 1 && option <= 6) {

                switch (option) {  // //switch statement for the operator check
                    case 1:
                        //Kilogram -> Gram = (kilogram_value * 1000) grams
                        System.out.println("What is the weight in kilograms?");
                        gramweight = 0.0;
                        kgweight = userInput.nextInt(); //take the value entered  as an input
                        gramweight = kgweight * 1000;
                        System.out.println("Converting the weight from kilogram in gram");
                        System.out.println("" + gramweight + "gram");
                        break;
                    case 2:
                        //Gram -> Kilogram = (gram_value / 1000) kilograms
                        System.out.println("What is the weight in grams?");
                        kgweight = 0.0;
                        gramweight = userInput.nextInt(); //take the value entered  as an input
                        kgweight = gramweight / 1000;
                        System.out.println("Converting the weight from gram in kilogram");
                        System.out.println("" + kgweight + "kgs");
                        break;
                    case 3:
                        // Pound -> Ounce = (pound_value * 16) oz
                        System.out.println("What is the weight in Pounds?");
                        ounceweight = 0.0;
                        poundweight = userInput.nextInt(); //take the value entered  as an input
                        ounceweight = poundweight * 16;
                        System.out.println("Converting the weight from Pound  in Ounce");
                        System.out.println("" + ounceweight + "oz");
                        break;
                    case 4:
                        // Ounce -> Pound = (ounce_value / 16) lb
                        System.out.println("What is the weight in ounce?");
                        poundweight = 0.0;
                        ounceweight = userInput.nextInt(); //take the value entered  as an input
                        poundweight = ounceweight / 16;
                        System.out.println("Converting the weight from Ounce in Pounds");
                        System.out.println("" + poundweight + "lbs");
                        break;
                    case 5:
                        //Kilogram -> Pound = (kilogram_input * 2.205) lb
                        System.out.println("What is the weight in kilograms?");
                        poundweight = 0.0;
                        kgweight = userInput.nextInt(); //take the value entered  as an input
                        poundweight = kgweight * 2.205;
                        System.out.println("Converting the weight from kilogram in Pounds");
                        System.out.println("" + poundweight + "lbs");
                        break;
                    case 6:
                        //Pound -> Kilogram = (pound_input / 2.205) kg
                        System.out.println("What is the weight in Pounds?");
                        kgweight = 0.0;
                        poundweight = userInput.nextInt(); //take the value entered  as an input
                        kgweight = poundweight / 2.205;
                        System.out.println("Converting the weight from Pound in kilogram");
                        System.out.println("" + kgweight + "kgs");
                        break;
                }

            } else { //else it will check the operator either to exit or show error message
                if (option == 0) {
                    System.out.println("EXIT");
                    System.exit(0); //exit the program if entered 0
                } else {
                    System.out.println("You have entered wrong option"); //print wrong choice and continue the program in loop
                }

            }
        }
    }

}
