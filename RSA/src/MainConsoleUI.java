import java.io.IOException;
import java.util.Scanner;

public class MainConsoleUI {

    //allows us to get the message and use it in the encryption process
    public static String Message;
    public static String MessageToEncrypt(String m) {
        Message = m;
        return m;
    }
    //IOEXCEPTION is used to throw a failure in input and output operations
    public static void Run() throws IOException {
        //ch is empty so it can take inputted information from terminal.
        char ch = ' ';
        //do while statement.
        do{
            //main menu first thing the user would see and would be called after a function is completed.
            System.out.println("RSA Algorithm Implemented By:");
            System.out.println("Omer Guven(oguve001), Haider Khan(hkhan006), Amjad Hussain Ahmed(ahuss019)");
            System.out.println("Select the function you would like to perform");
            System.out.println("1) Run RSA System");
            System.out.println("2) Quit the program");
            ch = (char) System.in.read();
            System.in.read();

            //switch statement
            switch (ch) {
                case '1':
                    //prints all the information gathered that will be used during the key generation, encryption process and decryption process
                    //user inputs the message they would like to send and the message would be encrypted and sent to bob to decrypt
                    ConsoleUI();
                    Scanner in = new Scanner(System.in);
                    System.out.println("Hello, Please enter the message you would like to send");
                    String Len = in.nextLine();
                    Message = Len;
                    //this shows the encrypted version of the message and the decrypted version of the message
                    System.out.println("=======================================================================");
                    System.out.println("Encryption");
                    System.out.println("Encrypted version of message using mod exponentiation with e and n ");
                    System.out.println(" Ascii form of inputted message");
                    System.out.println(" Message in ascii form = " + String.valueOf(RSAEncryption.AsciiForm()));
                    System.out.println();
                    System.out.println("Encrypted version of message using mod exponentiation with e and n ");
                    System.out.println(" Encrypted message = " + String.valueOf(RSAEncryption.C()));
                    System.out.println("=======================================================================");
                    System.out.println("Decryption");
                    System.out.println(" The message bob will see after decryption is: ");
                    System.out.println(String.valueOf(RSADecryption.Decrypt()));
                    System.out.println("=======================================================================");
                    break;

                case '2':
                    //if 2 is pressed then the code would stop
                    System.out.println("Exiting The Application");
                    break;

                default:
                    //if a key that does not have a case is pressed then it would print invalid key pressed.
                    System.out.println("Invalid Key Pressed");
                    break;
            }

        } while (ch != '2');//stops do while loop with the switch statements from taking anymore input so it stops the program from running if 2 is pressed.
    }


   //gathering all important information so the marker can see how everything is computed
   private static void ConsoleUI(){
       long e = KeyGen.FinalE;
       long r = KeyGen.originalr;
       long d = KeyGen.ModInv(e, r);
       long test = e*d;
       long result = test % r;
       System.out.println("=======================================================================");
       System.out.println("Generated Prime p and Prime q");
       System.out.println(" p = " + KeyGen.Finalp);
       System.out.println(" q " + KeyGen.Finalq);
       System.out.println(" ");
       System.out.println("Value of n is found by doing p * q ");
       System.out.println(" n = " + KeyGen.n());
       System.out.println();
       System.out.println("Value of r is found by doing (p-1) * (q-1) ");
       System.out.println(" r = " + KeyGen.originalr);
       System.out.println();
       System.out.println("Value of e is a number between 1 and r and has no common factors with r");
       System.out.println(" e = " + KeyGen.FinalE);
       System.out.println();
       System.out.println("Value of d is the mod inverse of e and r");
       System.out.println(" d = " + KeyGen.DCalc());
       System.out.println(" ");
       System.out.println();
       System.out.println("Check if d is correct by calculating e*d mod r which should return 1");
       System.out.println(" Checking if e*d mod r returns 1 and the return is = " + result);
       System.out.println();
       System.out.println("=======================================================================");

   }

}
