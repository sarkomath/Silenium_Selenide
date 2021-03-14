import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class DebetCardFormTest {

    @Test
    // Ввод ФИО на английском
    void wrongNameTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("John Johnson"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766"); // ввод номера телефона
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_text > .input__inner > .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
        // Ввод неправильного номера телефона
    void wrongPhoneNumberTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("89998887766"); // ввод номера телефона
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_tel > .input__inner > .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
        // ВВод ФИО со спецсимволами
    void specialSymbolNameTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван!"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766"); // ввод номера телефона
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_text > .input__inner > .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
        // Ввод номера телефона со спецсимволами
    void specialSymbolPhoneNumberTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766@"); // ввод номера телефона
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_tel > .input__inner > .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
        // Отправка формы без чекбокса
    void noClickOnCheckbox() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766"); // ввод номера телефона
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_invalid").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
        // Отсправка пустой формы
    void emptyNameFieldTest() {
        open("http://localhost:9999/");
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_text > .input__inner > .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
        // Отправка формы без номера телефона
    void emptyPhoneNumberFieldTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $(".input_type_tel > .input__inner > .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
