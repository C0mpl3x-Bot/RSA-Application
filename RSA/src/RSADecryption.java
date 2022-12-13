import java.util.ArrayList;

public class RSADecryption{

    //function used to decrypt the encrypted message
    public static String Decrypt(){
        //gets the size of arraylist that contains the encrypted message from RSEncryption
        long EncryptedMessageSize = RSAEncryption.C().size();

        //initialise new arraylist
        ArrayList DecryptedMessage = new ArrayList();

        //for loop that loops over the size of the arraylist that contains the encrypted message
        for(int i  = 0; i<EncryptedMessageSize; i++){
            //using modular exponentiation with the private key d and value n it starts to decrypt the elements in the array one by one
            int ModExAnswer = (int) ModularExponentiation.ModEx((Long) RSAEncryption.C().get(i), PrivateKeyD(), RSAEncryption.PublicKeyN());
            //saves the decrypted form of the message which is in ascii form to the new arraylist
            DecryptedMessage.add(ModExAnswer);
        }
        //create a new array list
        ArrayList AsciiNumbersToTextList = new ArrayList();

        String AsciiNumbersToText;
        //for loop that iterates over the size of the decryptedMessage size
        for(int j = 0; j<DecryptedMessage.size();j++) {

            //converts each element in the array list from ascii form to letters, numbers and symbols form
            int i = (int) DecryptedMessage.get(j);
            AsciiNumbersToText = Character.toString(i);

            //adds the fully decrypted message into a new arraylist
            AsciiNumbersToTextList.add(AsciiNumbersToText);
        }
        //create a new empty string
        String DecryptedMessageString = " ";
        //for loop over the size of the arraylist called AsciiNumbersToTextList
        for(int i = 0; i<AsciiNumbersToTextList.size(); i++){
            //add each of the letters,symbols and numbers to the string
            //which would display the message sent by the user allowing the receiver to view the message
            DecryptedMessageString += AsciiNumbersToTextList.get(i);
        }
        //return the decrypted message
        return DecryptedMessageString;


    }

    //used to get access to the private key D from keygen
    public static long PrivateKeyD(){
        long N = KeyGen.DCalc();
        return N;
    }
}
