package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class Configurations {
    private SelenideElement nameField = $("#firstName"),
            lastnamefield = $("#lastName"),
            emailField = $("#userEmail"),
            genderField = $("#genterWrapper"),
            phoneNumberField = $("#userNumber"),
            birthdayField = $("[id=dateOfBirthInput]"),
            maleField = $(byText("Male")),
            femaleField = $(byText("Female")),
            birthdayYear = $(".react-datepicker__year-select"),
            birthdayMonth = $(".react-datepicker__month-select"),
            dayOfBirth = $(".react-datepicker__day--016");
    StringBuilder selector = new StringBuilder(String.valueOf($(".react-datepicker__day--016")));


    public void browserConfig() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    public void openBrowser() {
        open("automation-practice-form");
        executeJavaScript("$('footer').remove()");
    }

    public void enterYourName(String name) {
        nameField.setValue(name);
    }

    public void enterYourLastname(String lastname) {
        lastnamefield.setValue(lastname);
    }

    public void enterYourEmail(String mail) {
        emailField.setValue(mail);
    }

    public void enterYourGender(String gender) {
        if (gender.equals("Male")) {
            genderField.$(byText("Male")).click();
        } else {
            gender.equals("Female");
            genderField.$(byText("Female")).click();

        }
    }

    public void enterYourNumber(String number) {
        phoneNumberField.setValue(number);
    }

    public void enterYourBirthDate(String year, String month, String day) {
        birthdayField.click();
        birthdayYear.selectOption(year);
        birthdayMonth.selectOption(month);
        selector.replace(26, 28, day);
        String finalSelector = selector.toString();
        $(finalSelector).click();


    }

}


