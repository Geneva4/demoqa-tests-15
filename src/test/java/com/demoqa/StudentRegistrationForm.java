package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.sun.jdi.ByteValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $("#userNumber").setValue("89107479861");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2000");



    }

}









