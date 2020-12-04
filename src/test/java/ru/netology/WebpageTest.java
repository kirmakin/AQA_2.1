package ru.netology;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebpageTest {

    @Test
    public void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Иван Сидоров");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
        }
//        driver.get("http://localhost:9999");
//        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иван Сидоров");
//        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79881112233");
//        driver.findElement(By.cssSelector("[data-test-id=agreement] .checkbox__box")).click();
//        driver.findElement(By.cssSelector(".form-field .button__content")).click();
//        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);
//    }
}
