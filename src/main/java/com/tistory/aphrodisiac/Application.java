package com.tistory.aphrodisiac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 현재 프로젝트의 메인 클래스 */

/*
@SpringBootApplication
1) 스프링 부트의 자동 설정
2) 스프링 Bean 읽기와 생성을 모두 자동으로 설정
3) @SpringBootApplication을 작성한 파일의 위치부터 설정을 읽기 때문에 항상 프로젝트 최상단에 위치해야함
*/

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
        내장 WAS를 실행(별도의 WAS를 설치하여 사용하는 것이 아니라 어플리케이션 내부에서 WAS를 실행하는 것)
        스프링 부트로 만들어진 Jar파일을 실행하면 별도의 WAS없이 실행이 가능
        */
        SpringApplication.run(Application.class, args);
    }
}