import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static javax.sound.sampled.FloatControl.Type.BALANCE;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    SimpleAccount simpleAccount = new SimpleAccount();
    SimpleAccount simpleAccount2 = new SimpleAccount();





    @Test
    public void testTransfer() {
        assertEquals(0, simpleAccount.getBalance());
        assertEquals(0, simpleAccount2.getBalance());

        assertFalse(simpleAccount.transfer(simpleAccount2, 50));
        assertEquals(0, simpleAccount.getBalance());
        assertEquals(0, simpleAccount2.getBalance());

        assertTrue(simpleAccount.add(100));
        assertEquals(100, simpleAccount.getBalance());

        assertFalse(simpleAccount.transfer(simpleAccount2, 150));
        assertEquals(100, simpleAccount.getBalance());
        assertEquals(0, simpleAccount2.getBalance());

        assertTrue(simpleAccount.transfer(simpleAccount2, 50));
        assertEquals(50, simpleAccount.getBalance());
        assertEquals(50, simpleAccount2.getBalance());
    }

    @Test
    public void testAdd() {
        assertEquals(0, simpleAccount.getBalance());

        assertTrue(simpleAccount.add(100));
        assertEquals(100, simpleAccount.getBalance());

    }

    @Test
    public void testPay() {
        assertEquals(0, simpleAccount.getBalance());

        assertFalse(simpleAccount.pay(50));
        assertEquals(0, simpleAccount.getBalance());

        assertTrue(simpleAccount.add(100));
        assertEquals(100, simpleAccount.getBalance());

        assertTrue(simpleAccount.pay(50));
        assertEquals(50, simpleAccount.getBalance());

        assertFalse(simpleAccount.pay(100));
        assertEquals(50, simpleAccount.getBalance());
    }
}