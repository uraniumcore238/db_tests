package tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


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


}