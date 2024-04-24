package me.kazura233.todomvc.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodomvcServiceTests {
    @Resource
    private TodomvcService todomvcService;

    @Test
    public void demo() {
        System.out.println("----------END----------");
    }

}
