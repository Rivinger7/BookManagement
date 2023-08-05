/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.*;
import Model.*;
import Controller.Bookstore;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String options[] = {
            "Add a new item to the cart",
            "Add a new customer",
            "Create an invoice",
            "Sort the invoice list by the customer name",
            "Search the invoice list",
            "Exit"
        };
        
        final String fileBook = "src\\Input\\ListOfBooks.txt";
        final String fileUser = "src\\Input\\ListOfUsers.txt";
        int choice = 0;
        Bookstore bookstore = null;
        bookstore = new Bookstore(fileBook, fileUser);
        boolean checkUser = bookstore.checkUser();
        
        
        do {
            while(!checkUser) {
                checkUser = bookstore.checkUser();
            } 
            System.out.println("\nBook Management Program");
            choice = Menu.getChoice(options);
            switch(choice) {
                case 1:
                    System.out.println("1");
                    break;
                default:
                    System.out.println("Good bye!");
            }
        } while(choice > 0 && choice < 6);
    }
}
