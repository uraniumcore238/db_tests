package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.impl.WebElementSelector;
import com.codeborne.selenide.impl.WebElementsCollectionWrapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


import java.util.Iterator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;


public class CheckTheMainMenuTest extends TestBase {


    @Test
    void headerValidationTest() {
        step("Open main URL", () -> {
            String url = "https://www.db.com/russia/index_ru.htm";
            open(url);
        });
        step("Check the header menu", () -> {
            $x("//a[@id='pi_main_1204']").shouldHave(text("Группа Дойче Банк"));
            $x("//a[@id='pi_main_1199']").shouldHave(text("Контакты"));
            $x("//a[@id='pi_main_1205']").shouldHave(text("Карта сайта"));
            $x("//li[@id='langSwitch_ENG']").shouldHave(text("English"));
        });
    }

    @Test
    void mainMenuValidationTest() {
        String url = "https://www.db.com/russia/index_ru.htm";
        String mainPageUrl = "https://db.com/russia/index_ru.htm";
        String ourCompanyUrl = "https://www.db.com/russia/ru/content/758.htm";
        String productsUrl = "https://www.db.com/russia/ru/content/756.htm";
        String corpCommunicationsUrl = "https://www.db.com/russia/ru/content/corporate-communications.htm";
        String techCenterUrl = "https://www.db.com/russia/ru/content/technology-centre.htm";
        String careerUrl = "https://dbtc-career.ru/";

        step("Open main URL", () -> {

            open(url);
        });
        step("Check the main menu name items", () -> {
            WebElement mainUrlLink = $x("//a[@id='pi_main_529']").shouldHave(text("На главную"));
            String mainLink = mainUrlLink.getAttribute("href");
            assert (mainLink.equals(mainPageUrl));

            WebElement ourCompanyUrlLink = $x("//a[@id='pi_main_758']").shouldHave(text("Наша компания"));
            String ourCompanyLink = ourCompanyUrlLink.getAttribute("href");
            assert (ourCompanyLink.equals(ourCompanyUrl));

            WebElement productsLink = $x("//a[@id='pi_main_757']").shouldHave(text("Продукты и услуги"));
            String productsUrlLink = productsLink.getAttribute("href");
            assert (productsUrlLink.equals(productsUrl));

            WebElement techCenterLink = $x("//a[@id='pi_main_2561']").shouldHave(text("Технологический центр"));
            String techCenterUrlLink = techCenterLink.getAttribute("href");
            assert (techCenterUrlLink.equals(techCenterUrl));

            WebElement corpCommunicationsLink = $x("//a[@id='pi_main_756']").shouldHave(text("Корпоративные коммуникации"));
            String corpCommunicationsUrlLink = corpCommunicationsLink.getAttribute("href");
            assert (corpCommunicationsUrlLink.equals(corpCommunicationsUrl));

            WebElement careerLink = $x("//a[@id='pi_main_754']").shouldHave(text("Карьера"));
            String careerUrlLink = careerLink.getAttribute("href");
            assert (careerUrlLink.equals(careerUrl));
        });
    }

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


    @Test
    void vkontakteLinkTest() {
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

        step("Go and assert Vkontakte", () -> {
            $x("//a[text()='Vkontakte']").click();
            switchTo().window(1);
            $x("//h1").shouldHave(text("Технологический Центр Дойче Банка"));
        });
    }

    @Test
    void youtubeLinkTest() {
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

        step("Go and assert Youtube", () -> {
                $x("//a[text()='Youtube']").click();
                switchTo().window(1);
                $("#inner-header-container #text-container .ytd-channel-name").shouldHave(text("Технологический Центр Дойче Банка"));
            });
    }

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
            $(".tgme_action_button").click();
            Selenide.switchTo().alert().accept();
        });
    }


}