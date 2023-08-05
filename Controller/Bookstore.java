/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import Model.Book;
import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Bookstore {

    private List<Book> bookList = null;
    private List<User> userList = null;
    Scanner sc = new Scanner(System.in);

    public Bookstore(String path1, String path2) throws Exception {
        bookList = loadBooks(path1);
        userList = loadUsers(path2);
    }

    public List<Book> loadBooks(String path1) throws Exception {
        try {
            File bookInfo = new File(path1);
            String fullPath = bookInfo.getAbsolutePath();
            FileInputStream bookInfoByte = new FileInputStream(fullPath);
            BufferedReader myInputBooksInfo = new BufferedReader(new InputStreamReader(bookInfoByte));
            String thisLine;
            while ((thisLine = myInputBooksInfo.readLine()) != null) {
                Book book = null;
                if (!thisLine.trim().isEmpty()) {
                    String split[] = thisLine.split(",");
                    String id = split[1].trim();
                    String name = split[2].trim();
                    String type = split[3].trim();
                    double price = Double.parseDouble(split[4].trim());
                    int quantity = Integer.parseInt(split[5].trim());

                    book = new Book(id, price, name, type, quantity);
                }
                if (bookList == null) {
                    bookList = new ArrayList<>();
                }
                bookList.add(book);
            }
            myInputBooksInfo.close();
        } catch (Exception ex) {
            throw ex;
        }
        for (Book obj1 : bookList) {
            System.out.println(obj1);
            System.out.println("");
        }
        return bookList;
    }

    public List<User> loadUsers(String path2) throws Exception {
        try {
            File userInfo = new File(path2);
            String fullPath = userInfo.getAbsolutePath();
            FileInputStream userInfoByte = new FileInputStream(fullPath);
            BufferedReader myInputUsersInfo = new BufferedReader(new InputStreamReader(userInfoByte));
            String thisLine;
            HashMap<String, String> userSystem = null;
            while ((thisLine = myInputUsersInfo.readLine()) != null) {
                User user = null;
                if (!thisLine.trim().isEmpty()) {
                    String split[] = thisLine.split(",");
                    if (userSystem == null) {
                        userSystem = new HashMap<>();
                    }
                    String userName = split[1].trim();
                    String password = split[2].trim();

                    user = new User(userName, password);

                    userSystem.put(userName, password);
                }
                if (userList == null) {
                    userList = new ArrayList<>();
                }
                userList.add(user);
            }
            myInputUsersInfo.close();
        } catch (Exception ex) {
            throw ex;
        }
        for (User obj1 : userList) {
            System.out.println(obj1);
            System.out.println("");
        }
        return userList;
    }

    public boolean checkUser() {
        try {
            System.out.println("\nLogin System");
            System.out.print("User Name: ");
            String userName = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            for (User obj1 : userList) {
                if (userName.equals(obj1.getUserName()) && password.equals(obj1.getPassword())) {
                    return true;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        System.out.println("Username or Password is invalid");
        return false;
    }
}
