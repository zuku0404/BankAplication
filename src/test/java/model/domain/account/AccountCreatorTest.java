package model.domain.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountCreatorTest {
    @Test
    void name() {
        // given
        AccountCreator ac = new AccountCreator();
        // when
        String exceptedAccountNumber = ac.generateAccountNumber2();

        // then
        assertTrue(exceptedAccountNumber.startsWith("1140"));
        assertEquals(26, exceptedAccountNumber.length());
    }
}