package com.tistory.aphrodisiac;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tistory.aphrodisiac.web.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
JUnit에 내장된 실행자를 사용하지 않고, 스프링 실행자를 사용하도록 한다.
스프링 부트 테스트와 JUnit을 연결해준다
*/
@RunWith(SpringRunner.class)

/*
선언하는 경우 @Controller, @ControllerAdvice 등은 사용가능
@Service, @Component, @Repository 등은 사용불가
*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
    1) 웹API 테스트에 사용
    2) 스프링MVC 테스트의 시작점
    3) 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음
    */
    // 객체 자동 생성
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))         // MockMvc를 통해 /hello 주소로 HTTP GET 요청함
                .andExpect(status().isOk())          // mvc.perform의 결과 검증, HTTP Header의 Status를 검증, 200인지 아닌지 검증
                .andExpect(content().string(hello)); // mvc.perform의 결과 검증, 응답 본문의 내용 검증, Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증
    }
}
