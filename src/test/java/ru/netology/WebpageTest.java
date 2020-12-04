package ru.netology;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebpageTest {

    @Test
    public void shouldSubmitRequest() {
        open("http://localhost:9999");
//        SelenideElement form = $("[data-test-id=callback-form]");
        $("[data-test-id=name] input").setValue("Иван Сидоров");
        $("[data-test-id=phone] input").setValue("+79270000001");
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        }

}
