public class KeyGen {
    // gathers all the information about the key generation, encryption and decryption process and saves them to a string called message which is being returned by the function.
    public static String information(){
        long e = FinalE;
        long r = originalr;
        long d = ModInv(e, r);
        long test = e*d;
        String message =
                "<html>"
                + Finalp + " This is Random Prime Number p " + "<br/>"
                + Finalq + " This is Random Prime Number q " + "<br/>"
                + String.valueOf(n()) + " This is the number for N after doing p*q "+ "<br/>"
                + String.valueOf(originalr) + " This is the number for R after doing (p-1) * (q-1) "+ "<br/>"
                + String.valueOf(FinalE) + " This is e which is a number between 1 and r and has no common factors with r" + "<br/>"
                + String.valueOf(DCalc()) + " This is the number for D after doing mod inverse e and r"+ "<br/>"
                + String.valueOf(test%r) + " This is calculating e*d mod r which should be 1 "+ "<br/>"
                + String.valueOf(RSAEncryption.AsciiForm() + " This is the Ascii form of the message so it can be encrypted") + "<br/>"
                + String.valueOf(RSAEncryption.C()) + " This is the encrypted version of the message "  + "<br/>"
                +"</html>";

        return message;
    }

    //initialisation of new variables.
    public static long FinalN;
    public static long Finalp;
    public static long Finalq;

    public static long r(){
        //initialises new instance of RandomPrimeGenerator
        RandomPrimeGenerator c  = new RandomPrimeGenerator();
        //call the function that generates prime numbers p and q
        c.PrimeGenerator();
        //gets the prime p and saves it to p
        long p = c.getpPrime();
        //gets the prime q and saves it to q
        long q = c.getqPrime();
        Finalp = p;
        Finalq = q;

        //calculates n using the formula p*q
        long n = p * q;

        //sets finalN to n
        FinalN = n;

        //calculates the r value
        //calculates p-1 and saves it to pPrimeSubtracted
        long pPrimeSubtracted = p-1;
        //calculates q-1 and saves it to qPrimeSubtracted
        long qPrimeSubtracted = q-1;
        //calculates r by doing pPrimeSubtracted * qPrimeSubtracted
        long r = pPrimeSubtracted * qPrimeSubtracted;

        //returns r
        return r;
    }

    public static long originalr = r();
    public static long FinalE = ECheck();


    public static long n() {
        return FinalN;
    }

    //Generates potential Number for e
    public static long EGenerate() {

        long min = 1;
        long max = 10000;
        long x = min + (long)(Math.random() * ((max - min) + 1));
        return x;
    }

    //E Checker
    //Checks if e is less than r and has no common factors with r if these are true then it would return e else it would generate a new E number
    public static long ECheck(){

        long ENumber = EGenerate();
        long r = originalr;
            if (ENumber < r) {
                long gcfResult = gcf(r, ENumber);
                if (gcfResult == 1) {
                    return ENumber;
                }
            }

        return ECheck();
    }

    //greatest common factor checks for common factors between two numbers we are using this to check if r and enumber have any factors in common
    //if there are no factors in common then it should return 1
    static long gcf(long a, long b)
    {
        if (b == 0) {
            return a;
        }
        return gcf(b, a % b);
    }

    //this function calculates the value for d which would be used in the decryption process.
    //D is calculated by performing modular inverse on E and r
    public static long DCalc(){
        long r = originalr;
        long ENumber = FinalE;

        long D = ModInv(ENumber,r);

        return D;
    }

    //Modular inverse, calculates the mod inverse of two given numbers
    //this method will try all numbers from 1 to m and for each number check if a times x mod m is equal to 1.
    //https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
    public static long ModInv(long a, long m){
        for (long x = 1; x < m; x++)
            if (((a%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }

}
