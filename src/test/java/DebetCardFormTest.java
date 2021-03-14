import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class DebetCardFormTest {

    @Test
    // Полностью позитивный тест
    void fullPositiveTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766"); // ввод номера телефона
        $("[data-test-id=agreement]").click(); // отмечаем чекбокс
        $("[type=button]").click(); // нажимаем "Продолжить"
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
