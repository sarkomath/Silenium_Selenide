import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class DebetCardFormTest {
//    private WebDriver driver;
//
//    @BeforeAll
//    static void setUpAll() {
//        System.setProperty("webdriver.firefox.driver", "C:\\tmp\\geckodriver.exe");
//    }
//
//    @BeforeEach
//    void SetUp() {
//        driver = new FirefoxDriver();
//    }

    @Test
    void fullPositiveTest() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Иванов Иван"); // ввод имени в поле ФИО
        $("[data-test-id=phone] input").setValue("+79998887766"); // ввод номера телефона
        $("[data-test-id=agreement] input").click(); // отмечаем чекбокс
        $("[type=button] input").click(); // нажимаем "Продолжить"
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! " + "Наш менеджер свяжется с вами в ближайшее время."));
    }

}
