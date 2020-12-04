package ru.netology;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
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
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
}
