/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Anh Dat
 */
public class Utility {
    public static boolean GetYesNo(String msg)
    {
        String s = "";
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                s = sc.next("[yn]");
                loop = false;
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.nextLine();
            }
        }while(loop);
        if(s.charAt(0) == 'y') return true;
        else return false;
    }
    public static String GetString(String msg, boolean isEmpty)
    {
        String s = "";
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                s = sc.nextLine();
                if(isEmpty)
                    loop = false;
                else if(!s.isEmpty())
                    loop = false;
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.nextLine();
            }
        }while(loop);
        System.out.println();
        return s;
    }
//    public static int getInt(String msg){
//        int i = 0;
//        Scanner sc = new Scanner(System.in);
//        boolean loop = true;
//        do
//        {
//            System.out.print(msg);
//            try
//            {
//                i = Integer.parseInt(sc.nextLine());
//                if(i<=0){
//                    System.out.println("Invalid input!");
//                    loop = true;
//                } else loop = false;
//            }
//            catch(NumberFormatException e)
//            {
//                System.out.println("Need number format!");
//                sc.nextLine();
//            }
//        }while(loop);
//        System.out.println();
//        return i;
//    }
    public static int getInt(String msg){
        int val=0;
        boolean check=false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            try{
              val = Integer.parseInt(sc.nextLine());
              if((val>=1)&&(val<=4)){
                    check = true;
              }
              else{
                  System.out.println("Wrong Input!!");
              }
            } catch(NumberFormatException e){
                System.out.println("Wrong Input!!");
            }
        } while(check==false); 
        return val;
     }
    int getUserChoices(){
        return getInt("Please enter 1,2,3 and 4: ");
    }


    public static double getDouble(String msg){
        double i = 0;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                i = Double.parseDouble(sc.nextLine());
                if(i<=0){
                    System.out.println("Invalid input!");
                    loop = true;
                } else loop = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Need number format!");
                sc.nextLine();
            }
        }while(loop);
        System.out.println();
        return i;
    }
}
