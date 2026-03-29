package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumControllerTest {

    @Test
    void digitSum() {
        DigitSumController dSCont = new DigitSumController();
        int number = 1234;
        assertEquals(10, dSCont.digitSum(number));
    }
    @Test
    void usage(){
        DigitSumController dSCont = new DigitSumController();
        dSCont.digitSum(1234);
        dSCont.digitSum(5678);
        assertEquals(2, dSCont.usage());
    }
}