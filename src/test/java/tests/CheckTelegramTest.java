package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckTelegramTest {

    @Test
    void telegramLinkTest() {
        String url = "https://www.db.com/russia/index_ru.htm";

        step("Open main URL", () -> {
            open(url);
        });

        step("Go to the technology center", () -> {
            $x("//a[@id='pi_main_2561']").click();
        });

        step("Assert the technology center name", () -> {
            $x("//h1").shouldHave(text("Технологический Центр"));
        });

        step("Go and assert Telegram", () -> {
            $x("//a[text()='Чат-бот в Telegram']").click();
            switchTo().window(1);
            Selenide.confirm();
//            Selenide.switchTo().alert().accept();
//            $(".tgme_action_button").click();

        });
    }
}
