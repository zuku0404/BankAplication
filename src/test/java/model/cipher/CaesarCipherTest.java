package model.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CaesarCipherTest {
    @ParameterizedTest
    @MethodSource("data")
    void encryptPassword_nonEncryptedInput_encryptedOutput (String password, String expectedResult){
        //given
        CaesarCipher caesarCipher = new CaesarCipher();
        //when
        String passwordFromCesarCipher = caesarCipher.encryptPassword(password);
        //then
        Assertions.assertEquals(passwordFromCesarCipher,expectedResult);
    }

    private static Stream<Arguments> data(){
        return Stream.of(Arguments.of("abcd","klmn"),
                Arguments.of("ABCD","KLMN"),
                Arguments.of("zuzia","jejsk")
                );}

}