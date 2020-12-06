package ru.netology;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class WebpageTest {

    @Test
    public void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Иван Сидоров");
        $("[data-test-id=phone] input").setValue("+79270000001");
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldntSubmitRequestByName() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Ivan Сидоров");
        $("[data-test-id=phone] input").setValue("+79270000001");
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("#root > div > form > div:nth-child(1) > span > span > span.input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldntSubmitRequestByPhone() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Иван Сидоров");
        $("[data-test-id=phone] input").setValue("+792700000012");
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("#root > div > form > div:nth-child(2) > span > span > span.input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
@Test
    public void shouldntSubmitRequestByCheckbox() {
    open("http://localhost:9999");
    $("[data-test-id=name] input").setValue("Иван Сидоров");
    $("[data-test-id=phone] input").setValue("+79270000001");
    $(".form-field .button__content").click();
    $(".input_invalid>.checkbox__box");
}

@Test
    public void shouldntSubmitByEmptyFields () {
    open("http://localhost:9999");
    $(".form-field .button__content").click();
    $("#root > div > form > div:nth-child(1) > span > span > span.input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
}

}
