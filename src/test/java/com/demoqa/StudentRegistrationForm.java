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

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen =  true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {

        open("automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Evgenii");
        $("#lastName").setValue("Milshin");

        $("#userEmail").setValue("zhenyamilshin@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9107479861");
        $("[id=dateOfBirthInput]").click();

        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--016").click();

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









