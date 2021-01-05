오늘은 Spring Boot 5번째 시간입니다.

> ## Today I Learned
  - MyBatis

### MyBatis
  - sql이랑 구현할 인터페이스 메소드만 알려줘(매핑) 그럼 내가 다 알아서 구현해줄게
  - 설정(라이브러리 추가)
  
![](https://images.velog.io/images/junjun-creator/post/9ed15e24-3f03-4b25-914c-7d04fe013ba3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%203.22.38.png)

  - 사용법(select)
    - 구현하고자 하는 dao 인터페이스에 Mapper 어노테이션 달기
    - 구현하고자 하는 함수에 sql 매핑을 위한 어노테이션 달기

![](https://images.velog.io/images/junjun-creator/post/c016fe72-b6b1-4ce4-ae29-f3551da8519b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%203.23.49.png)

  - select절에 where 구문이 있다면?
    - ${} 또는 #{}로 적용가능하다.
      - @Select("SELECT * FROM NOTICE WHERE ID=${id}")
      - ${}는 값, #{}는 키(문자열로 한번 더 감싸서 들어감).
    - 그렇다면 그 값은 어떻게 전달 받나?
      - queryString(request객체를 통해 받거나, 전달된 값의 이름의 변수로 받을 수 있음. spring은 쿼리스트링으로 값이 전달된다는것을 알고 있기 때문에 가능)
      - {}(PathVariable, 매핑 pathvariable 이름을 꼭 일치시켜줘야 한다.)
      
![](https://images.velog.io/images/junjun-creator/post/5825a269-369c-4228-b468-a64905903d0d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%204.20.32.png)

![](https://images.velog.io/images/junjun-creator/post/c8633ea1-afa0-40c0-a493-49cbe16ea8a4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%204.27.06.png)

### 번외
  - controller에서 인자로 전달되는 model은 어떻게 생성되고 사용되나?
    - dispatcherServlet(front controller)에서 handleRequest를 통해 request 매핑을 해줌
    - @RequestMapping 어노테이션을 통해 dispatcherServlet은 RTTI 정보를 가지고 해당 어노테이션이 달려있는 아이의 매개변수 정보등을 알아서 가져다 씀

### 번외 2 (spring jdbc rowMapper)

![](https://images.velog.io/images/junjun-creator/post/944d74f7-009d-4c82-81dd-d52f1c94c8ec/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%204.53.51.png)
