오늘은 Spring Boot 6번째 시간입니다

> ## Today I Learned
  - PathVariable
  - MyBatis - xml 활용
  - 의존성 주입(DI) 3가지 방법
  
### PathVariable
  - queryString을 사용하지 않고, 값으로 경로를 바로 지정할 수 있다.
  - 매핑은 @RequestMapping("{id}") 과같은 방식으로 설정한다
    - 함수내에서는 id라는 이름으로 전달된 pathvariable 값을 사용하기 위해 이름을 일치시켜야한다
    - @PathVariable("id") Integer id

![](https://images.velog.io/images/junjun-creator/post/1f59f14a-4fe2-4f6e-90c3-0ad0512dc1b2/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%203.34.53.png)

### MyBatis - xml 활용
  - 인터페이스에 어노테이션을 덕지덕지 붙여서 구현하는것이 간편하고 좋지만, 만약 MyBatis가 아닌 JDBC를 함께 이용할 경우 해당 인터페이스를 따로 구현해야하고, @Mapper 어노테이션과 같은 MyBatis설정을 다 제거해줘야한다.
  - 또한, 인터페이스 함수가 많고, select구문이 복잡해질 경우 코드가 난잡해진다.
  - 그래서 인터페이스를 분리 시켜서 구현하는 방법을 쓰기도 한다.
    - xml에 sql과 인터페이스 함수를 매핑 하는 정보를 저장하는 방식
  - xml 설정 방법
    - namespace : 구현할 인터페이스 경로 지정
    - resultMap : 컬럼과 엔티티의 속성 매핑 정보 저장
    - select id : 구현하고자 하는 인터페이스 함수명
  - xml 장점
    - 쿼리 수정이 쉬움
    - 쿼리가 아무리 길어도 텍스트형식으로 작성되므로 쉬움
    - 인터페이스를 따로 분리시켜둘수 있어서 본래의 취지에 맞음
  - xml 단점
    - 인터페이스 함수명, 리턴타입 등 수정이 생기면 바꿔야 할 것이 많아짐
  - @mapper, XML 어떤 방식을 이용하든 MyBatis는 인터페이스 구현체를 저장하고 있는 저장공간을 갖고있음
    - 저장소 : factory
    - factory에서 구현체를 가져다 쓸수 있는 도구 : SqlSession
      - '나 지금 뭐 필요해' 하면 전달해줌
      - getMapper("") 매퍼를 꺼내서 반환
      - IoC에 담겨져 있음(MyBatis가 담아둠)

![](https://images.velog.io/images/junjun-creator/post/06c6ee24-5c04-40f0-b73f-2465aed43a90/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%204.58.37.png)

  - Dao 인터페이스 구현체에서는 매퍼를 통해 구현한 구현체를 session을 통해 반환 받아서 구현해주면 된다.
  
![](https://images.velog.io/images/junjun-creator/post/95b6aad4-31fb-465f-9b5f-46dce9843d92/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%205.02.59.png)


### 의존성 주입(DI) 3가지 방법
  - Field DI
    - 멤버변수에서 바로 의존성 주입

![](https://images.velog.io/images/junjun-creator/post/0bc001b8-61eb-4109-aafa-d6eafa3ace55/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%205.44.27.png)

  - Setter DI
    - setter 메소드에서 의존성 주입

![](https://images.velog.io/images/junjun-creator/post/b4c54430-50d6-4826-a0f7-9eb75a087a91/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%205.46.19.png)

  - Constructor DI
    - 생성자에서 의존성 주입
    
![](https://images.velog.io/images/junjun-creator/post/43339e60-f251-446c-aebb-b91eb4848292/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-06%20%EC%98%A4%ED%9B%84%205.48.10.png)

  - Autowired는 의존성 주입을 위한 Spring이 제공하는 기능이다.
  - 의존성 주입을 위해 IoC에서 해당 객체를 알아서 탐색하고 의존성 주입을 하게된다.
  - 이때, spring은 mybatis가 IoC에 넣어둔 SqlSession 객체를 찾아서 DI를 해준다.
