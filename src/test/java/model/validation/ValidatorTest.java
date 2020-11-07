package model.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ValidatorTest {
    // given for all
    Validator validator = new Validator(); //TODO usunac wszedzie validatory w metodach
    @ParameterizedTest
    @MethodSource("dataCash")
    void checkCash_cashFromData_resultAsInData(String cash, boolean expectedResult) {
        //when
        boolean result = validator.checkCash(cash);
        //then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataCash() {
        return Stream.of(of("123", true),
                of("123,23", true),
                of("123.54", true),
                of("123.245", false),
                of("sadsad", false),
                of("1223332231321", true),
                of("1223332231321,2332", false),
                of("1a", false),
                of("", false)
        );
    }

    // true -> kiedy wystepuje chociaz jeden zank bez znakow bialych na poczatku i na koncu
    @ParameterizedTest
    @MethodSource("dataTitle")
    void checkTitle_titleFromData_resultAsInData(String title, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkTitle(title);
        //then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataTitle() {
        return Stream.of(of("trakaka", true),
                of("", false),
                of("t", true),
                of(" ", false),
                of("to musi dzialac ", true)
        );
    }

    // true -> kazda zwykla liczba, piewsza nie moze byc 0
    @ParameterizedTest
    @MethodSource("dataUserRecipient")
    void checkIdUserRecipient_userRecipientFromData_resultAsInData(String id, boolean exceptedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkIdUserRecipient(id);
        //then
        assertEquals(result, exceptedResult);
    }

    private static Stream<Arguments> dataUserRecipient() {
        return Stream.of(of("12", true),
                of("ads", false),
                of("12 ", false),
                of("1a", false),
                of("12,3", false),
                of("", false),
                of("12!", false),
                of("-1", false),
                of("1", true),
                of("0", false),
                of("01", false),
                of("10", true)
        );
    }

    // true -> jedna duza, jedna mala litera, znak specjalny, jedna liczbe  co najmniej 8 znakow;
    @ParameterizedTest
    @MethodSource("dataPassword")
    void checkPassword_passwordFromData_resultAsInData(String password, boolean expectResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkPassword(password);
        //then
        assertEquals(result, expectResult);
    }

    private static Stream<Arguments> dataPassword() {
        return Stream.of(of("asdasS@12s", true),
                of("asdasS12s", false),
                of("asdas@12s", false),
                of("asdasS", false),
                of("asdasSSfddf@a", false),
                of("asdasS@1", true),
                of("asdasSSf@2ds    ddf@a", false)
        );
    }

    // true -> jeden wyraz o dlugosci 8 liter posiadajace jedna duza litere
    @ParameterizedTest
    @MethodSource("dataLogin")
    void checkLogin_loginFromData_resultAsInData(String login, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkLogin(login);
        //then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataLogin() {
        return Stream.of(of("Mama", false),
                of("321dscMama", true),
                of("Mama ma Kota", false),
                of("MamaMusi", true),
                of("mamaMusi", true),
                of("mAma", false),
                of("Mama sds", false)
        );
    }

    // true -> pierwsza duza litera druga mala
    @ParameterizedTest
    @MethodSource("dataNameSurname")
    void checkNameSurname(String nameSurname, boolean expectedResult) {
        // given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkNameSurname(nameSurname);
        // then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataNameSurname() {
        return Stream.of(of("Ewa", true),
                of("Ewa konewa", false),
                of("Ew", true),
                of("E", false),
                of("sdawa", false),
                of("sdAwa", false),
                of("WsdadA", false),
                of("Sdawa32", false)
        );
    }

    // true -> XX-XX-XXXX
    @ParameterizedTest
    @MethodSource("dataBirth")
    void checkDataOfBirth_birthFromData_resultAsInData(String date, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkDataOfBirth(date);
        //then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataBirth() {
        return Stream.of(of("12-02-2020", true),
                of("12-13-2020", true),
                of("12 02 2020", false),
                of("12.02.2020", false),
                of("2020-12-3", false),
                of("2020-22-3", false),
                of("12-13-2020", true),
                of("12-13-3020", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataPesel")
    void checkPesel_peselFromData_resultAsInData(String pesel, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkPesel(pesel);
        //then
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataPesel() {
        return Stream.of(of("11123456789", true),
                of("123456789343242", false),
                of("12345678", false),
                of("1s23456789", false)
        );
    }
}
