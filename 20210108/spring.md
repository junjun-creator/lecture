오늘은 Spring Boot 8번째 시간입니다.

> ## Today I Learned
  - 검색기능 + 페이저
  
### 검색기능
  - queryString과 기본값을 통한 검색
    - 기본값 설정을 통해 값이 전달되지 않아도 정상적인 쿼리를 실행할 수 있도록 세팅
  
![](https://images.velog.io/images/junjun-creator/post/db9f409c-3af5-4aa1-92b5-824032c71f74/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%203.23.43.png)![](https://images.velog.io/images/junjun-creator/post/4ab9a52c-b9bf-4807-97d1-1f3dc9adec9f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%203.24.21.png)

  - 기본값을 사용하지 않고, MyBatis가 제공하는 조건절을 사용하여 쿼리 수행하기
    - 전달된 값이 없는데도 궂이 기본값을 통해서 조회하는 일을 방지
    - Dynamic Query( 동적 쿼리 )
    - 이럴경우 requestParam으로 값을 받는것이 required=false가 되야한다. (default가 true라서 필수)
  
![](https://images.velog.io/images/junjun-creator/post/d5add0a5-ee7b-4b2d-ac12-1a452dd58e0b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%203.54.38.png)![](https://images.velog.io/images/junjun-creator/post/92763e0a-5df2-42f8-9948-e3dd6a7f867e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%203.54.49.png)

  - 검색카테고리가 많은 경우 <where\>를 사용하여 발생될 수 있는 문제들을 해결할 수 있다
    - where만 남겨지는 문제
    - where and 와 같은 쿼리가 되는 문제
    
![](https://images.velog.io/images/junjun-creator/post/7200a031-8cf0-4cde-9465-1249af461a64/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%203.59.58.png)

### 페이저
  - 전체 페이지 수 불러오기
  - (다음시간에 이어서 하겠습니다)
