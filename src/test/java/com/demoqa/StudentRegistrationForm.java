package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

 public class StudentRegistrationForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen =  true;
        Configuration.browserSize = "1265x689";
    }
    @Test
    void fillFormTest() {

        open("automation-practice-form");

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
    }

}









