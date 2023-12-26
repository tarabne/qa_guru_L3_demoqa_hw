package ru.tarabne;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("FirstNameValue");
        $("#lastName").setValue("LastNameValue");
        $("#userEmail").setValue("useremail@value.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9183214567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("com").pressTab();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpeg");
        $("#currentAddress").setValue("CurrentAddressValue");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("FirstNameValue LastNameValue"));
        $(".table").shouldHave(text("useremail@value.com"));
        $(".table").shouldHave(text("Female"));
        $(".table").shouldHave(text("9183214567"));
        $(".table").shouldHave(text("17 May,1990"));
        $(".table").shouldHave(text("Computer Science"));
        $(".table").shouldHave(text("Music, Sports"));
        $(".table").shouldHave(text("1.jpeg"));
        $(".table").shouldHave(text("CurrentAddressValue"));
        $(".table").shouldHave(text("Rajasthan Jaipur"));

    }
}
