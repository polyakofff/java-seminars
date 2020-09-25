package sem02;

import java.math.BigInteger;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<BigInteger> res = FactorialCalculator.factorial(1);

        System.out.println(res.isPresent());


        
    }
}

class FactorialCalculator {

    static Optional<BigInteger> factorial(int n) {
        if (n < 0) {
            return Optional.empty();
        }

        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return Optional.of(f);
    }
}