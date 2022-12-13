import java.security.Key;
import java.util.ArrayList;

public class RSAEncryption {
    //gets the message that was inputted by the user and converts the letters in the message in to ascii form and saves them one by one in to the arraylist
    //then gets the arraylist and performs modular exponentiation on each element from the arraylist and saves them to a new arraylist
    //which is the encrypted message that is being returned in an arraylist form
    public static ArrayList C() {
        //sets m to the message that the user inputted
        String m = MainGUI.Message;
        if(MainGUI.Message == null){
            m = MainConsoleUI.Message;

        }
        m.length();
        long PublicKEYNLENGTH = String.valueOf(PublicKeyN()).length();
        char stringMToNumber;
        ArrayList<Integer> a = new ArrayList();
        int i = 0;
        while(i < m.length()){
                stringMToNumber = m.charAt(i);
                char ascii = stringMToNumber;
                a.add((int) ascii);
                i++;
        }
        ArrayList c = new ArrayList();
        for(int j = 0; j < a.size(); j++){
            long SizeCheck = String.valueOf(a.get(j)).length();
            if(PublicKEYNLENGTH >= SizeCheck) {
                long ModExAnswer = ModularExponentiation.ModEx(a.get(j), PublicKeyE(), PublicKeyN());
                c.add(ModExAnswer);
            }

        }
        //returns the encrypted message in an arraylist
        return (c);
    }
    //gets the ascii form of the arraylist so it can be used to display what the message looks like when it is in ascii form within the arraylist
    public static ArrayList AsciiForm(){
        String m = MainGUI.Message;
        if(MainGUI.Message == null){
            m = MainConsoleUI.Message;

        }
        m.length();
        char stringMToNumber;
        ArrayList<Integer> a = new ArrayList();
        int i = 0;
        while(i < m.length()){
            stringMToNumber = m.charAt(i);
            char ascii = stringMToNumber;
            a.add((int) ascii);
            i++;
        }
        return a;
    }

    //gets the value of N from KeyGen and returns it
    public static long PublicKeyN(){
        long N = KeyGen.n();
        return N;
    }

    //gets the value of E from KeyGen and returns it
    public static long PublicKeyE(){
        long E = KeyGen.FinalE;
        return E;
    }

}
