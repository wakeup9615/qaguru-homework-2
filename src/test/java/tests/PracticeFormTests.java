package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {

        String firstName = "Test";
        String lastName = "Testov";
        String email = "test@test.ru";
        String number = "1231231230";
        String address = "Test, 1-2";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("February")).click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").sendKeys("Hindi");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/summer.jpeg"));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Male"),
                text(number),
                text("15 February,1999"),
                text("Hindi"),
                text("Sports"),
                text("summer.jpeg"),
                text(address),
                text("NCR Delhi"));
    }
}
