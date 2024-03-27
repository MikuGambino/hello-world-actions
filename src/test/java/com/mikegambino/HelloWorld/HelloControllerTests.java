package com.mikegambino.HelloWorld;

import com.mikegambino.HelloWorld.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTests {
    @InjectMocks
    HelloController helloController;

    @Test
    void checkHello() {
        String expectedBody = "Hello, world";

        ResponseEntity<String> actual = helloController.hello();

        assertThat(actual.getBody()).isEqualTo(expectedBody);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}
