오늘은 Spring Framework 3번째 시간입니다.
> ## Today I Learned
  - Spring JDBC

### Spring JDBC
  - 일체형 부품 조립하는 방법
    - a > b > c

![](https://images.velog.io/images/junjun-creator/post/9aa90461-f3d5-4315-b853-64ee5056709e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%203.31.44.png)

  - 삽입형 부품 조립 방법
    - c > b > a
    
![](https://images.velog.io/images/junjun-creator/post/a7725898-d1f9-446c-9846-ac3fad49bfe8/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%203.32.41.png)

  - 기존에는 코드상에서 일일이 부품을 조립하는 과정이 필요했음.
    - 사용하고자 하는 부품이 미리 준비되어있고, 그 부품을 다 알고 있어야 했음
    - Spring에서는 부품의 객체 생성을 직접 하지 않음.
  - 이런 과정이 많아질수록 코드 복잡도 증가.
  - Spring은 IoC(Inversion of Container)에 객체(부품)를 저장하고, DI(Dependency Injection,부품조립)를 하는 과정을 Annotaion을 통해 스스로 진행
  - @Component Annotaion을 달아줌으로써 IoC에 담음
    - 구성요소, 스프링 어플리케이션을 구성하는 구성요소 객체입니다.
    - 3가지 Component
    	- @Controller
        - @Service
        - @Repository(주로 dao에 씀)
  - @Autowired > 담겨져 있는 component를 가져와서 사용함
    - 사용하는 곳에서 import되어있는 경로를 모두 탐색해서 담겨진 component들을 모두 사용 할 수 있음
  
![](https://images.velog.io/images/junjun-creator/post/ce593f08-8d52-4816-9b7f-76763839f0a3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%204.24.55.png)

  - jdbc 라이브러리 설정하기
    - spring-boot-starter-data-jdbc 라이브러리 추가
    - application.properties 설정하기
    
![](https://images.velog.io/images/junjun-creator/post/1c63db10-b5f3-4d44-a2f2-565c29e19e7f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%204.26.55.png)

![](https://images.velog.io/images/junjun-creator/post/9d0bf300-8ed0-4dca-b1f7-ca7e0bc0e9f5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%204.27.10.png)
