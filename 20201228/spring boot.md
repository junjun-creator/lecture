오늘은 Spring framework에 대해 알아보았습니다.

> ## Today I learned
  - Spring Boot
  
### Spring Boot Install 및 서버 실행하기
  - https://spring.io/tools 접속
  
![](https://images.velog.io/images/junjun-creator/post/d6096825-9240-4654-9e1b-f4e49b34340e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%205.19.30.png)

  - 설치 후 spring starter project 생성하기

![](https://images.velog.io/images/junjun-creator/post/7533b522-2686-44ac-b903-ba9b2e421531/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%203.25.13.png)

  - 서버 실행하기

![](https://images.velog.io/images/junjun-creator/post/4ed8ecdc-7704-4697-ba52-c0f3300c2136/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%205.22.40.png)

### Spring Boot
  - 지금까지 웹서버의 메인함수는 톰캣이 가지고 있었다.
  - 하지만, 스프링부트는 본인이 메인함수를 가지고 있다.(스프링이 중심이 되어 톰캣을 컨트롤)
  
![](https://images.velog.io/images/junjun-creator/post/f283a910-2303-40fd-b531-3af446a789ee/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%203.37.46.png)

  - Controller
    - 과거 서블릿으로 웹을 개발할 때에는 페이지 하나당 컨트롤러 1개를 만들어서 사용했다.
    - 하지만, spring boot에서는 하나의 디렉토리당 하나의 컨트롤러를 사용할 수 있다.(하나의 컨트롤러에 여러개의 url매핑 가능)
    - 또한, 공통적인 매핑주소(경로)는 공통으로 관리할 수 있다.
    
![](https://images.velog.io/images/junjun-creator/post/12cc7649-dc01-4552-bf6f-e331ee3eefe6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%204.04.51.png)

  - RESTful API
    - 객체나 상태가 다른곳으로 그냥 전달 될 수 없다.
    - 전달하기 위해 representation해줘야 함.
    - API는 절차 언어가 호출하는 약속(함수형태)이다.
    - RESTful API는 함수형태는 아니지만 데이터를 전송 하기 위한 약속이다.
  - 컨트롤러의 클래스 이름이 같은경우
    - 서버에서 실행할때 각각 객체를 만드는데, 이름이 같을경우에 충돌이 난다.
    - 이를 해결하기 위해 컨트롤러에 이름을 달아줘서 해당 이름으로 객체를 생성하게끔 해주면 된다.
    
![](https://images.velog.io/images/junjun-creator/post/424fce77-f3fe-4caa-bf6f-a69a04684b3f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%ED%9B%84%204.28.16.png)

### 정리

Spring Boot 2.x
Spring 5.x 최신 라이브러리를 이용하여 웹 개발을 하는 것이 기본
=>톰캣 설정 + Servlet/JSP+JSTL+Spring 라이브러리 + Spring dependency..
=>실행환경 + 라이브러리 + 구성하기 설정=>부트

1. 프로젝트 만들기
2. 컨트롤러 추가 => URL 매핑하는 기능을 추가 : URL 매핑 엄청 편해졌다.
             => 출력 방법이 엄청 쉬워졌다.
   (1) 매핑
   (2) 출력
   (3) 입력
