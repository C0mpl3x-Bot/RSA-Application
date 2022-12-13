import java.io.IOException;
import java.util.Scanner;

public class menu {
    menu() throws IOException {
        //ch is empty so it can take inputted information from terminal.
        char cha = ' ';
        //main menu first thing the user would see and would be called after a function is completed.
        System.out.println("IS53012C Computer Security Coursework\n");
        System.out.println("RSA Algorithm (Assignment 1) Implemented By:");
        System.out.println("Omer Guven(oguve001), Haider Khan(hkhan006), Amjad Hussain Ahmed(ahuss019)\n");
        System.out.println("Select the function you would like to perform");
        System.out.println("1) Run RSA Console UI System");
        System.out.println("2) Run RSA GUI System");
        System.out.println("3) Quit the System");
        //do while statement.
        do{
            cha = (char) System.in.read();
            System.in.read();

            //switch statement
            switch (cha) {
                //runs console UI
                case '1':
                    MainConsoleUI d = new MainConsoleUI();
                    MainConsoleUI.Run();
                    System.out.println("1) Run RSA Console UI System");
                    System.out.println("2) Run RSA GUI System");
                    System.out.println("3) Quit the System");
                    break;
                //runs GUI
                case '2':
                    MainGUI c  = new MainGUI();
                    System.out.println("1) Run RSA Console UI System");
                    System.out.println("2) Run RSA GUI System");
                    System.out.println("3) Quit the System");
                    break;
                //Closes Program
                case '3':
                    //if 3 is pressed then the code would stop
                    System.out.println("Exiting The Application");
                    break;

                default:
                    //if a key that does not have a case is pressed then it would print invalid key pressed.
                    System.out.println("Invalid Key Pressed");
                    break;
            }

        } while (cha != '3');//stops do while loop with the switch statements from taking anymore input so it stops the program from running if 3 is pressed.
    }

    public static void main(String[] args) throws IOException {
        new menu();
    }
}
