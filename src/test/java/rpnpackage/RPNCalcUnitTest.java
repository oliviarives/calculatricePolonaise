package rpnpackage;

import org.junit.Test;
import rpnpackage.exceptions.DivideByZeroException;
import rpnpackage.exceptions.NotEnoughOperandsOnStackException;
import stackpackage.SimpleStackStub;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class RPNCalcUnitTest {
    RPNCalc calc = new RPNCalc(new SimpleStackStub());

}