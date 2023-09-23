package com.JAVAEXERCISES;
import java.util.*;

class Book{
    String BookName;
    String BookAuthor;
    String BookSubject;
    public Book(String BookName,String BookAuthor, String BookSubject){
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookSubject = BookSubject;
    }
    public String getBookName(){
        return BookName;
    }


}

public class Library_management_system {
    public static void main(String[] args) {
        Book Books = new Book("maths","rs ","maths");
        List<Book> Library_list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n Welcome to Library Management System");
            System.out.println("Press 1 for adding book in library");
            System.out.println("Press 2 for checking out a book from library");
            System.out.println("Press 3 for reviewing books in library");
            System.out.println("Press 4 for returning books in library");
            System.out.println("Press 5 for searching books in library");
            System.out.println("Press 6 for exit");

            int user_choice = 0;
            try {

                user_choice = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid option.");
                sc.nextLine();
                continue;
            }
            switch (user_choice) {
                case 1:
                    System.out.println("Enter Book name");
                    String user_book = sc.nextLine();
                    System.out.println("Enter Book Author name");
                    String user_author = sc.nextLine();
                    System.out.println("Enter Book Subject");
                    String user_sub = sc.nextLine();
                    Book Added_book = new Book(user_book, user_author, user_sub);
                    Library_list.add(Added_book);
                    break;
                case 2:
                    System.out.println("Enter book name you want to checking out");
                    String checkOutBook = sc.nextLine();
                    System.out.println("Enter book author name you want to checking out");
                    String checkOutBookAuthor = sc.nextLine();
                    System.out.println("Enter book subject name you want to checking out");
                    String checkOutBookSub = sc.nextLine();
                    Iterator<Book> iterator = Library_list.iterator();
                    while (iterator.hasNext()) {
                        Book checking_out = iterator.next();
                        if (checking_out.getBookName().equalsIgnoreCase(checkOutBook) &&
                                checking_out.BookAuthor.equalsIgnoreCase(checkOutBookAuthor) &&
                                checking_out.BookSubject.equalsIgnoreCase(checkOutBookSub)) {
                            iterator.remove();
                            System.out.println("Thank you visit again!....");
                            break;
                        }
                        else System.out.println("Enter valid input");
                    }
                    break;

                case 3:
                    for (Book reviewing : Library_list) {
                        System.out.println("Book :" + reviewing.BookName);
                        System.out.println("Book Author :" + reviewing.BookAuthor);
                        System.out.println("Book Subject :" + reviewing.BookSubject);
                    }
                    break;
                case 4:
                    System.out.println("Enter book name you want to return");
                    String returnBook = sc.nextLine();
                    System.out.println("Enter book author name you want to return");
                    String returnBookAuthor = sc.nextLine();
                    System.out.println("Enter book subject name you want to return");
                    String returnBookSub = sc.nextLine();
                    Book returnedBook = new Book(returnBook, returnBookAuthor, returnBookSub);
                    Library_list.add(returnedBook);
                    System.out.println("Book returned successfully!");
                    break;

                case 5:
                    System.out.println("Enter Book name");
                    String searchBookName = sc.nextLine();
                    System.out.println("Enter Book Author name");
                    String searchBookAuthorName = sc.nextLine();
                    Iterator<Book> iterator1 = Library_list.iterator();
                    while (iterator1.hasNext()) {
                        Book checking_out = iterator1.next();
                        if (checking_out.getBookName().equalsIgnoreCase(searchBookName) &&
                                checking_out.BookAuthor.equalsIgnoreCase(searchBookAuthorName)) {
                            System.out.println("Found that book! you can read in library or can borrow");
                            break;
                        } else System.out.println("Book not found");
                    }break;
                case 6:
                    System.out.println("Thank you visit again! 👋");
                    System.exit(0);
                default:
                    System.out.println("Enter valid input");
                    break;
            }


            }

        }
    }

