package org.example;

import java.util.Scanner;
import java.lang.Thread;

//This template is to help you know where certain code should live
//This is to help you along if you're stuck
public class Main {
    public static void main(String[] args) throws InterruptedException  {
        //You'll need an array of 20 books, put it here
        Book[] book = new Book[20];

        book[0] = new Book(101,"9798838091642","Frankenstein; Or, The Modern Prometheus by Mary Wollstonecraft Shelley",false,"");
        book[1] = new Book(102,"9781981294022","Moby Dick; Or, The Whale by Herman Melville",false,"");
        book[2] = new Book(103,"9780743477116","Romeo and Juliet by William Shakespeare",false,"");
        book[3] = new Book(104,"9781986016636","Pride and Prejudice by Jane Austen",false,"");
        book[4] = new Book(105,"9781975942366","Alice's Adventures in Wonderland by Lewis Carroll",false,"");
        book[5] = new Book(106,"9781015519930","Fables of La Fontaine — a New Edition, with Notes by Jean de La Fontaine",false,"");
        book[6] = new Book(107,"9781678625733","The Strange Case of Dr. Jekyll and Mr. Hyde by Robert Louis Stevenson",false,"");
        book[7] = new Book(108,"9781626860988","The Complete Works of William Shakespeare by William Shakespeare",false,"");
        book[8] = new Book(109,"9798710826423","Beowulf: An Anglo-Saxon Epic Poem by J. Lesslie Hall",false,"");
        book[9] = new Book(110,"9780143107668","The Scarlet Letter by Nathaniel Hawthorne",false,"");
        book[10] = new Book(111,"9781981474592","A Room with a View by E. M. Forster",false,"");
        book[11] = new Book(112,"9781545469880","How to Live on 24 Hours a Day by Arnold Bennett",false,"");
        book[12] = new Book(113,"9798612394785","Middlemarch by George Eliot",false,"");
        book[13] = new Book(114,"9781544938585","Little Women; Or, Meg, Jo, Beth, and Amy by Louisa May Alcott",false,"");
        book[14] = new Book(115,"9781979587402","Dracula by Bram Stoker",false,"");
        book[15] = new Book(116,"9798317279431","The Blue Castle: a novel by L. M. Montgomery",false,"");
        book[16] = new Book(117,"9798364626363","The Enchanted April by Elizabeth Von Arnim",false,"");
        book[17] = new Book(118,"9798357618153","Jane Eyre: An Autobiography by Charlotte Brontë",false,"");
        book[18] = new Book(119,"9780353423589","Everyman, with other interludes, including eight miracle plays by Ernest Rhys",false,"");
        book[19] = new Book(120,"9781095442470","The Adventures of Ferdinand Count Fathom — Complete by T. Smollett",false,"");

        //You'll need a scanner to take in user input. Make one.
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int intInput;

        boolean isEmpty;

        //You'll need a menu. A while(true) loop will be helpful
        while(true){
            isEmpty = false;
            System.out.println("Welcome to The Library! Would you like to:");
            System.out.println("1) Show Available Books.");
            System.out.println("2) Show Checked Out Books.");
            System.out.println("3) Exit.");
            userInput = scanner.nextLine();

            //Based on what they type, make a switch case to handle it
            //Be sure they can exit the program!
            switch (userInput){
                case "1":
                    System.out.println("----------------------");
                    for (Book item : book) {
                        if (!item.isCheckOut()) {
                            System.out.println(item.getId() + ") | " + item.getIsbn() + " | " + item.getTitle());
                            isEmpty = true;
                        }
                    }
                    while(true){
                        try{
                            if(isEmpty){
                                System.out.println("----------------------");
                                System.out.println("Type the ID (101-120) of a book to check it out, or type 'X' to exit.");

                                userInput = scanner.nextLine();

                                if (!userInput.equalsIgnoreCase("x"))
                                {
                                    intInput = Integer.parseInt(userInput) - 101;
                                    if (intInput >= 0 && intInput < book.length) {
                                        if (book[intInput].isCheckOut()) {
                                            System.out.println(book[intInput].getTitle() + " is already checked out.");
                                            Thread.sleep(1000);
                                        }
                                        else {
                                            if (!userInput.isEmpty()){
                                                System.out.println("You have selected " + book[intInput].getTitle());
                                                System.out.println("Please enter you name to check out.");
                                                userInput = scanner.nextLine();
                                                book[intInput].checkOut(userInput);
                                                System.out.println("Congratulations, " + book[intInput].getCheckedOutTo() + ". You checked out " + book[intInput].getTitle() + ".");
                                                Thread.sleep(1000);
                                                break;
                                            }
                                            else {
                                                System.out.println("Blank input detected. Going back.");
                                                Thread.sleep(1000);
                                            }
                                        }
                                    } else {
                                        System.out.println("Wrong input detected.");
                                        Thread.sleep(1000);
                                    }
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                System.out.println("There's no books to look at!");
                                Thread.sleep(1000);
                                break;
                            }
                        } catch (Exception e){
                            System.out.println("Wrong input detected.");
                            Thread.sleep(1000);
                        }

                    }
                    break;
                case "2":
                    System.out.println("----------------------");
                    while(true){
                        try{
                            for (Book value : book) {
                                if (value.isCheckOut()) {
                                    System.out.println(value.getId() + ") | " + value.getIsbn() + " | " + value.getTitle() + " | is checked out to " + value.getCheckedOutTo());
                                    isEmpty = true;
                                }
                            }
                            if(isEmpty){
                                System.out.println("----------------------");
                                System.out.println("Would you like to check in any books? Type 'X' to exit.");

                                userInput = scanner.nextLine();

                                if (!userInput.equalsIgnoreCase("x"))
                                {
                                    intInput = Integer.parseInt(userInput) - 101;
                                    if (intInput >= 0 && intInput < book.length) {
                                        if (!book[intInput].isCheckOut()) {
                                            System.out.println(book[intInput].getTitle() + " is already checked in.");
                                        } else {
                                            System.out.println("You have selected " + book[intInput].getTitle());
                                            System.out.println("Please type 'C' to check the book back in.");
                                            userInput = scanner.nextLine();
                                            if (userInput.equalsIgnoreCase("c")){
                                                book[intInput].checkIn();
                                                System.out.println(book[intInput].getTitle() + " has been checked in!");
                                                Thread.sleep(1000);
                                                break;
                                            }
                                            else {
                                                System.out.println("Cancelling.");
                                                Thread.sleep(1000);
                                            }
                                        }
                                    } else {
                                        System.out.println("Wrong input detected.");
                                        Thread.sleep(1000);
                                    }
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                System.out.println("There's no books to look at!");
                                Thread.sleep(1000);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong input detected.");
                            Thread.sleep(1000);
                        }

                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    Thread.sleep(100);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please type a number: 1, 2, or 3.");

            }
            System.out.println("----------------------");
        }

        //Use a for loop and sout to print all the book titles
        //remember to use your Book class getters
        //Use if statements to filter out books that are checkedin/out
        //as need be

        //You will call the checkIn() and checkOut() methods
        //If the user wants to check in or out
        //Remember if they check out you must ask for their name!
        //example: book.checkOut(name) or book.checkIn()
    }
}