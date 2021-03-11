package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class CheckFacebookTest {

    @Test
    void facebookLinkTest() {
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

        step("Go and assert Facebook link", () -> {
            $x("//a[text()='Facebook']").click();
            switchTo().window(1);
            $x("//a[@class='_64-f']/span").shouldHave(text("Технологический Центр Дойче Банка"));
        });
    }



}
