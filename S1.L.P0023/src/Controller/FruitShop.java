/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.Manager;
import Model.Fruit;
import Model.Order;
 import java.util.ArrayList;
import java.util.Hashtable;
import Utility.Utility;
/**
 *
 * @author Anh Dat
 */
public class FruitShop {


    static int id=0, fr_quantity;
    static double price;
    static String fr_name, origin;
    static ArrayList<Fruit> fr_list = new ArrayList<>();
    static Manager manage = new Manager();
    static Hashtable<String, ArrayList<Order>> ord_ht = new Hashtable<String, ArrayList<Order>>();
    
    public static void createProduct(){
        boolean loop=true;
        do{
            id++;
            System.out.println("--- Create a new fruit ---");
            boolean loop2=true;
            do{  
                 fr_name = Utility.GetString("Enter fruit's name: ", false);
                 if(fr_list.size()>=1){
                    for(Fruit fr : fr_list){
                        if(fr_name.equalsIgnoreCase(fr.getFr_name())){
                            loop2=true;
                            System.out.println("This fruit has already existed!");
                            break;
                        } else loop2=false;
                    }                   
                 } else loop2=false;
               } while(loop2);
            origin = Utility.GetString("Enter fruit's origin: ", false);
            fr_quantity = Utility.getInt("Enter fruit's quantity: ");
            price = Utility.getDouble("Enter fruit's price: ");
            Fruit fr = new Fruit(id, fr_quantity, price, fr_name, origin);
            fr_list.add(fr);
            if(Utility.GetYesNo("Do you want to continue (Y/N)? /n")==false) loop=false;
        } while(loop);
            Manager.displayCreatedFruit(fr_list);
    }
    
    public static void shopping(){
        int select_item;
        int input_quantity;
        String fr_name="";
        double price=0;
        String customer="";
        ArrayList<Order> ord_list = new ArrayList<>();
        boolean loop=true;
        do{
            Manager.displayShopFruit(fr_list);
            
            boolean loop1=true;
            do{
               select_item=Utility.getInt("Select item: ");
               loop1 = Manager.checkFruitbyItem(select_item, fr_list);    
            } while(loop1);
            
            for(Fruit fr : fr_list){
                if(select_item==fr.getFruitID()){
                    fr_name = fr.getFr_name();
                    price = fr.getPrice();
                }
            }
            
            boolean loop2=true;
            do{
               input_quantity = Utility.getInt("Please input quantity: ");
               loop2 = Manager.inputValidQuantity(select_item, fr_list, input_quantity);
            } while(loop2);
            
            for(Fruit fr : fr_list){
                if(select_item==fr.getFruitID()){
                    fr.setQuantity(fr.getQuantity()-input_quantity);
                }
            }
            
            Order ord = new Order(fr_name, input_quantity, price);
            ord_list.add(ord);
            
            if(Utility.GetYesNo("Do you want to order now (Y/N)? ")==true){
               Manager.displayOrderList(ord_list);
               loop = false;
            } 
        } while(loop);
        customer = Utility.GetString("Input your name: ", false);
        ord_ht.put(customer, ord_list);
    }
    
    public static void viewOrder(){
        if(ord_ht.size()<1){
            System.out.println("There have not any orders yet!");
            return;
        }
        for(String name:ord_ht.keySet()){
            System.out.println("Customer: "+name);
            ArrayList<Order> ord_list = ord_ht.get(name);
            Manager.displayOrderList(ord_list);
        }
    }
}
