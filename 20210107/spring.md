오늘은 Spring Boot 7번째 시간입니다.

> ## Today I Learned
  - xml방식의 MyBatis rowMapping
  
### xml방식의 MyBatis rowMapping
  - 2가지 방법
    - select문에서 별칭사용하기
    - resultMap 사용하기(resultMap 정의하고 resultType대신 사용)

![](https://images.velog.io/images/junjun-creator/post/3c17b65b-37d4-4764-a3b6-0abc89c03a8a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%202.43.29.png)

### 날짜 포맷 

![](https://images.velog.io/images/junjun-creator/post/cc621a7b-a2d3-44b6-9e90-0ed53ba8b333/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%202.48.58.png)

### View 만들기
  - view entity와 데이터베이스 컬럼을 mapping시켜서 세팅해주면 됨
  
![](https://images.velog.io/images/junjun-creator/post/40f225ad-3d27-4a65-9509-5df6680c122b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%203.03.05.png)

  - MyBatis는 오버로드를 지원하지 않음
    - 인자가 가장 많은 메소드를 구현하고, 나머지는 구현된 메소드를 기본값으로 채워서 사용하는 방식으로 활용
    
![](https://images.velog.io/images/junjun-creator/post/b35c8696-e560-4707-bba9-e2dd2de849f2/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%203.49.20.png)

  - 그렇다면 전달된 인자는 어떻게 MyBatis에서 읽어들이는것인가?
    - RTTI Reflection
      - 객체의 메모리(class)를 통해 객체의 상태(정보)를 얻어오는 것
        - .class 또는 getClass()
        
    - 파라미터 이름 > getter
      - 객체로 파라미터가 전달 될 때에는 getter를 통해 인식하게 된다.
      - 전달되는 이름은 AA, BB이지만 이는 사실 getAA, getBB로 인식
      
    ![](https://images.velog.io/images/junjun-creator/post/2f903236-4e54-4072-92d3-33968c88dad5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%204.06.28.png)
      
    - 하지만 우리는 이것을 약속처럼 param1,2,...으로 사용할 수 있다.
    
    ![](https://images.velog.io/images/junjun-creator/post/34ad9c10-6499-4a29-9f47-df2607b974cb/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%204.05.09.png)


### QueryString을 이용한 페이저 만들기
  - queryString을 이용한 파라미터 전달 및 컨트롤러 적용
    - @RequestParam(name="전달된 변수명", defaultValue="초기값") Integer 사용할변수명
    - Request로 전달된 파라미터를 꺼내는 방법이다.

![](https://images.velog.io/images/junjun-creator/post/ad09136d-ad2d-4b1a-b5c1-a4457bc1d478/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%204.26.07.png)
