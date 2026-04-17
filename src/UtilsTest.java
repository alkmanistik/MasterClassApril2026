import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    private final Utils utils = new Utils();

    @Test
    @DisplayName("Обычный пользователь")
    void testUsual() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Обычный пользователь")
    void testUsual2() {
        User user = new User(
                "тест",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }


    @Test
    @DisplayName("Нулловое имя")
    void testNullName() {
        User user = new User(
                null,
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Через дефис имя")
    void testSign() {
        User user = new User(
                "test-test",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("знак не обычный")
    void testSignNotAllowed() {
        User user = new User(
                "test:test",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Иврит")
    void testEvrit() {
        User user = new User(
                "testʁ",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Пустое имя")
    void testEmptyName() {
        User user = new User(
                "",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Очень маленькое имя")
    void testVerySmallName() {
        User user = new User(
                "K",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Маленькое имя")
    void testSmallName() {
        User user = new User(
                "Ka",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Большое имя")
    void testBigName() {
        User user = new User(
                "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Очень большое имя")
    void testVeryBigName() {
        User user = new User(
                "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Нуловый age")
    void testNullAge() {
        User user = new User(
                "testman",
                null,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.AGE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Школьник 14 лет")
    void testSchoolBoy() {
        User user = new User(
                "testman",
                14,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Дедсад")
    void testNewBorn() {
        User user = new User(
                "testman",
                0,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.AGE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Минусовые даты")
    void testNegativeAge() {
        User user = new User(
                "testman",
                Integer.MIN_VALUE,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.AGE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Старый чувак")
    void testOldMan() {
        User user = new User(
                "testman",
                120,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Очень старый чувак")
    void testVeryOldMan() {
        User user = new User(
                "testman",
                121,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.AGE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Офигеть ему лет")
    void testGigaOldMan() {
        User user = new User(
                "testman",
                Integer.MAX_VALUE,
                "Мужской",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.AGE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Женщина")
    void testWoman() {
        User user = new User(
                "testman",
                21,
                "Женский",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Что это за гендер?")
    void testBoeing() {
        User user = new User(
                "testman",
                21,
                "Модель Boeing 767-300",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.GENDER_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Нулловый гендер")
    void testNullGender() {
        User user = new User(
                "testman",
                21,
                null,
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.GENDER_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Пустой гендер")
    void testEmptyGender() {
        User user = new User(
                "testman",
                21,
                "",
                "89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.GENDER_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Нуловый телефон")
    void testNullPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                null,
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Пустой телефон")
    void testEmptyPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Плюс в середине телефон")
    void testPlusPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "7+9232525233",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Плюс в начале но 8 телефон")
    void testPlusEightPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "+89000000000",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Буквы в телефоне")
    void testSignInPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "892325fb719",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Телефон с 7")
    void testNormanSevenPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "79232525233",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Телефон с 10 знаками")
    void testTenSignPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "7923252871",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Телефон с 10 знаками и +")
    void testPlusSevenTenSignPhone() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "+7923252871",
                "test.testov.21@test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.PHONE_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Нулловый etest")
    void testNullEtest() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                null
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.EMAIL_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("пустой etest")
    void testEmptyEtest() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                ""
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.EMAIL_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("без собачки")
    void testWithoutA() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21test.ru"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.EMAIL_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("без домена")
    void testWithoutDot() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test"
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.EMAIL_ERROR);

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Необычный домен")
    void testUnUsualDomen() {
        User user = new User(
                "testman",
                21,
                "Мужской",
                "89000000000",
                "test.testov.21@test.tv"
        );

        List<FormError> expectedError = new ArrayList<>();

        executeTest(user, expectedError);
    }

    @Test
    @DisplayName("Сквозная проблема")
    void testManyError() {
        User user = new User(
                null,
                21,
                "Мужской",
                "89000000000",
                null
        );

        List<FormError> expectedError = new ArrayList<>();
        expectedError.add(FormError.NAME_ERROR);
        expectedError.add(FormError.EMAIL_ERROR);

        executeTest(user, expectedError);
    }

    private void executeTest(User user, List<FormError> expected) {
        List<String> actual = utils.validateUser(user);

        List<String> result = expected.stream().map(FormError::getTitle).toList();

        assertEquals(result, actual,
                String.format("❌ ОШИБКА в тесте [%s]\n" +
                                "   Ожидалось: %s\n" +
                                "   Получено:  %s\n",
                        user, result, actual)
        );
    }
}