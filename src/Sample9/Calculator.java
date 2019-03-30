package Sample9;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

/**
 * Created by Alex on 30.03.2019
 */
public class Calculator implements Callable<BigInteger> {
    private final int x;

    public Calculator(int x) {
        this.x = x;
    }

    @Override
    public BigInteger call() throws Exception {
        if(x < 0) {
            throw new InvalidParameterException("Wrong x: " + x);
        }
        return fact(BigInteger.valueOf(x));
    }

    private BigInteger fact(BigInteger x) {
        if(x.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return x.multiply(fact(x.subtract(BigInteger.ONE)));
        }
    }
}
