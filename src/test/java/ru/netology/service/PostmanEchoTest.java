package ru.netology.service;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class PostmanEchoTest {

    @Test
    void shouldReturnSendData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Всем привет!")
                // Выполняемые действия
                .when().log().all()
                .post("/post")
                // Проверки
                .then().log().all()
                .statusCode(200)
                .body( "data", org.hamcrest.Matchers.equalTo("Всем здравствуйте!"));
    }
}