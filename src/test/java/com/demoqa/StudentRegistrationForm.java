package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    Configurations web = new Configurations();

    @BeforeAll
    static void conf() {
        Configurations web = new Configurations();
        web.browserConfig();
    }

    @Test
    void fillFormTest() {

        web.openBrowser();
        web.enterYourName("Evgenii");
        web.enterYourLastname("Milshin");
        web.enterYourEmail("zhenyamilshin@gmail.com");
        web.enterYourGender("Female");
        web.enterYourNumber("9107479861");
        web.enterYourBirthDate("2000", "March", "13");

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("23.jpg");
        $("#currentAddress").setValue("г.Курск, ул.Сторожевая 6А");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave((text("Evgenii Milshin")),

                text("zhenyamilshin@gmail.com"),
                text("Male"),
                text("9107479861"),
                text("16 March,2000"),
                text("Maths"),
                text("Reading"),
                text("23.jpg"),
                text("г.Курск, ул.Сторожевая 6А"),
                text("Haryana Karnal"));

        $("#closeLargeModal").click();


    }

}









