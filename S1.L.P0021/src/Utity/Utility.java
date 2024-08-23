/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Anh Dat
 */
public class Utility {
 

    public final String REGEX_CODE = "[a-zA-Z0-9]+";
    public final String REGEX_NAME = "[a-zA-Z ]+";
    public final String REGEX_YesNo = "[yYnN]";
    public final String REGEX_Update = "[uUdD]";

    // access modifier + (static) +return type + name method
    public int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not found!");
                } else {
                    int number = Integer.parseInt(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Enter number " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public  double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not found!");
                } else {
                    double number = Double.parseDouble(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else if (number % 0.5 != 0) {
                        System.out.println("Must be modulo 0.5");

                    } else {
                        System.err.println("Enter number " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public  float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not found!");
                } else {
                    float number = Float.parseFloat(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Enten number " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //nhap vao
            System.out.print(message);
            String input = scanner.nextLine();
            //kiem tra xem input co rong hay khong
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty !!");
            } else {
                //kiem tra xem input co matches regex hay ko
                //neu nhu matches voi regex => return string
                if (input.matches(regex)) {
                    return input;
                } else {
                    //tell error
                    System.err.println(error);
                }
            }
        }
    }

    public String getDate(String message, String error) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            //check format
            if (input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}") == false) {
                System.err.println(error);

            } else {
                //check date exist
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);

                try {
                    Date dateInput = dateFormat.parse(input);
                    Date currentDate = new Date();
                    //format  date to String and format back date
                    currentDate = dateFormat.parse(dateFormat.format(currentDate));

                    //so sanh date
                    if (dateInput.before(currentDate)) {
                        System.err.println("Date input must be greater or equal current date");
                    } else {
                        return input;
                    }

                } catch (ParseException ex) {
                    System.err.println(error);

                }
            }
        }
    
}
}
