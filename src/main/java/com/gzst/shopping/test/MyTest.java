package com.gzst.shopping.test;

import com.gzst.shopping.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {
    @Autowired
    Person person;

    @Test
    public void jdbcTest() {

        System.out.println(person);

    }
}
