public class ModularExponentiation {

    //https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
    static long ModEx(long x, long n, long m)
    {
        // Initialize result variable for modular exponentiation
        long y = 1;

        x = x % m; // Update x with x mod m

        //if x is equal to 0 return 0
        if (x == 0)
            return 0;

        while (n > 0)
        {
            // If n is odd, multiply x with result and mod m
            if ((n & 1) != 0)
                y = (y * x) % m;

            // n must be even now, multiply x with x
            n = n >> 1;
            x = (x * x) % m;
        }
        return y;
    }
}
