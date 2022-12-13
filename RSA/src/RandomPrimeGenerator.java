import java.math.BigInteger;

public class RandomPrimeGenerator {
    //initialise new private variables
    private long pPrime;
    private long qPrime;

    //getters and setters for Prime p and Prime q

    public long getpPrime(){
        return pPrime;
    }

    public void setpPrime(int pPrime){
        this.pPrime = pPrime;
    }

    public long getqPrime(){
        return qPrime;
    }

    public void setqPrime(int qPrime){
        this.qPrime = qPrime;
    }

    //function primeGenerator generates the prime numbers for p and q
    public void PrimeGenerator(){
        //sets pPrimeBoolean and qPrimeBoolean to false
        boolean pPrimeBoolean = false;
        boolean qPrimeBoolean = false;

        //while pPrimeBoolean is false
        while(!pPrimeBoolean){
            //generate random p number between 100 - 10000
            long min = 100;
            long max = 10000;
            long pPrimeNumber = min + (long)(Math.random() * ((max - min) + 1));
            //call the checkForPrimeWithFermat to see if the generated number p is a prime.
            if(checkForPrimeWithFermat(pPrimeNumber) == true){
                //sets pPrimeBoolean to true
                pPrimeBoolean = true;
                //sets pPrime to the prime number generated
                pPrime = pPrimeNumber;
            }
        }
        //while qPrimeBoolean is false
        while (!qPrimeBoolean){
            //generate random q number between 100 - 10000
            long min = 100;
            long max = 10000;
            long qPrimeNumber = min + (long)(Math.random() * ((max - min) + 1));
            //call the checkForPrimeWithFermat to see if the generated number q is a prime.
            if(checkForPrimeWithFermat(qPrimeNumber) == true){
                //sets qPrimeBoolean to true
                qPrimeBoolean = true;
                //sets qPrime to the prime number generated
                qPrime = qPrimeNumber;
            }
        }
    }

    //generates A for fermat
    public long Agen(long GeneratedNumber){
        long min = 2;
        long max = GeneratedNumber - 1;
        long aForFermat = min + (long)(Math.random() * ((max - min) + 1));
        return aForFermat;
    }

    //fermat only works if p or q is a prime otherwise it can still return 1 even if it is not a prime number
    //we check if it is a prime
    //then we do fermat on the prime number using mod expo
    //function that if checks input number is a prime
    public boolean checkForPrimeWithFermat(long GeneratedNumber)
    {
        //check if the GeneratedNumber is a prime
        boolean IsPrime = true;
        if(GeneratedNumber <= 1)
        {
            IsPrime  = false;
            return IsPrime ;
        }
        else
        {
            //checks if Generated Number is not a prime and if it is not a prime it sets IsPrime to false else it stays true
            for (int i = 2; i<= GeneratedNumber/2; i++)
            {
                if ((GeneratedNumber % i) == 0)
                {
                    IsPrime  = false;
                    break;
                }
            }
        }
       //perform fermat if the number is a prime as for fermat's little theorem to work you assume its a prime or require a prime number.
       if(IsPrime  == true){
            long aForFermat = Agen(GeneratedNumber);
            long PMinus1  = GeneratedNumber - 1;
            long P = GeneratedNumber;
            long answer = ModularExponentiation.ModEx(aForFermat,PMinus1,P);

            if ((answer == 1)) {
                IsPrime  = true;
            }
            else{
                IsPrime  = false;
            }
        }
       return IsPrime;
    }
}
