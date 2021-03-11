package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class CheckTechnologyCenterTest {

    @Test
    @Tag("Negative")
    void techCenterTest() {
        String url = "https://www.db.com/russia/index_ru.htm";
        String professionalUrl = "https://dbtc-career.ru/prof/";
        String studentsUrl = "https://dbtc-career.ru/6/";
        String youTubeUrl = "https://www.youtube.com/user/dbtechcentre";
        String facebookUrl = "https://www.facebook.com/dbdevcenter.ru";
        String vKontakteUrl = "http://vk.com/dbdevcenter";
        String telegramUrl = "https://t.me/db_recruit_bot";
        String habraHabrUrl = "https://habrahabr.ru/company/dbtc/";

        step("Open main URL", () -> {
            open(url);
        });

        step("Go to the technology center", () -> {
            $x("//a[@id='pi_main_2561']").click();
        });

        step("Assert the technology center name", () -> {
            $x("//h1").shouldHave(text("Технологический Центр"));
        });

        step("Assert the professional link address", () -> {
            String professionalLink = $x("//table//td[1]/a").getAttribute("href");
            assert (professionalLink.equals(professionalUrl));
        });

        step("Assert student's link address", () -> {
            String studeutLink = $x("//table//td[2]/a").getAttribute("href");
            assert (studeutLink.equals(studentsUrl));
        });

        step("Assert Habrahabr link address", () -> {
            String habraHabrLink = $x("//a[text()='Habrahabr']").getAttribute("href");
            assert (habraHabrLink.equals(habraHabrUrl));
        });

        step("Go and assert HabraHabr", () -> {
            $x("//a[text()='Habrahabr']").click();
            switchTo().window(1);
            $x("//a[@href='https://habr.com/en/company/dbtc/blog/']/h3").shouldHave(text("Blog"));
        });

        step("Check is there any article on the HabraHabr", () -> {
            $x("//a[@href='https://habr.com/en/company/dbtc/blog/']/h3/span").should(visible);
        });
    }





}
