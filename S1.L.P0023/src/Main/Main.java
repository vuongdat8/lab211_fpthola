/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.FruitShop;
import Utility.Utility;

/**
 *
 * @author Anh Dat
 */
public class Main {

    public static void main(String[] args) {
        Utility utility = new Utility();
        FruitShop furitShop = new FruitShop();
        
        while (true) {
            displayMenu();
            int choice = Utility.getInt("Chosse one option: ");
            switch (choice) {
                case 1:
                    furitShop.createProduct();
                    break;
                case 2:
                   furitShop.viewOrder();
                    break;
                case 3:
                    furitShop.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("------------ WELCOME TO STUDENT MANAGEMENT ------------\n"
                + "1. Create fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit"
        );
    }
}
