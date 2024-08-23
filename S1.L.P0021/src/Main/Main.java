/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Manage;
import Utity.Utility;

/**
 *
 * @author Anh Dat
 */
public class Main {
     public static void main(String[] args) {
        Utility util = new Utility();
        Manage manage = new Manage();
        

        while (true) {
            displayMenu();
            int option = util.getInteger("Chosse one option: ", "err", 1, 5);   

            switch (option) {
                case 1:
                    //input studnet
                    manage.inputStudents();

                    break;

                case 2:
                    //find ans sort
                    manage.findAndSort();

                    break;
                case 3:
                    //Update/Delete student
                    manage.updateDelete();

                    break;
                case 4:
                    //Report
                    manage.report();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }

        }
    }

    private static void displayMenu() {
        System.out.println("------------ WELCOME TO STUDENT MANAGEMENT ------------\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit");
    }
}
