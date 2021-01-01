오늘은 Spring Framework 3번째 시간입니다.

> ## Today I Learned
  - Tiles Library
  - 스프링의 흐름 이해하기

### Tiles Library
  - 기존 페이지 모듈 집중화의 문제점 해결
    - 레이아웃 + 콘텐트를 각각 분리해서 만든뒤 조합해서 사용할거야(마치 타일을 가져다 이어 붙이듯이)
    - 레이아웃이 중심 + 헤더,푸터,어사이드,비주얼,메인컨텐츠 를 붙임
  - 의존성 라이브러리 추가
  
![](https://images.velog.io/images/junjun-creator/post/2a002ef6-8647-466d-aa7e-1480ca8c4949/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%203.24.39.png)

  - tiles 설정을 위한 tiles.xml(/WEB-INF/tiles.xml) 생성

![](https://images.velog.io/images/junjun-creator/post/c706b549-cfe9-480c-ace2-926d54463513/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%203.25.37.png)

  - controller view return을 타일과 연결
    - tiles.xml에서 definition name과 각 attribute의 value(경로)가 공통된 부분들은 \* 을 통해서 집중화 할 수 있다.
    - name에 \* 로 지정한 경로의 경우 \*의 갯수에 따라, {1},{2} 순서대로 value의 경로에 매핑해주면 된다.
  
![](https://images.velog.io/images/junjun-creator/post/f6d597cc-a909-47ec-ba77-ae1cba525629/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%203.50.59.png)

  - tiles 이름과 경로를 매칭시켜서 설정하기
  
![](https://images.velog.io/images/junjun-creator/post/1b29fb2e-2566-4b94-aeeb-eb6be9f761df/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%203.52.35.png)

  - tiles 인스턴스를 생성하여 tiles가 작동되도록 하기
  
![](https://images.velog.io/images/junjun-creator/post/7353ff23-e3b2-48b3-9edc-c02cb4d2e74b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%204.26.24.png)

### 스프링의 흐름 이해하기(출처: 뉴렉처)

![](https://images.velog.io/images/junjun-creator/post/547d9faa-fb96-455e-ad1b-ec1510c58b78/dispatcher%EB%A5%BC%20%EC%A7%91%EC%A4%91%ED%99%94%20%ED%95%9C%20%ED%9B%84%20%EB%AA%A8%EB%8D%B8.png)

  - 클라이언트로부터 요청 > 모든 url을 Dispatcher에서 받아들임 > 요청 매핑 정보에 따라, 각 컨트롤러 메소드 호출(컨트롤러 객체 생성, IoC에 요청<request\>을 handling하기 위한 객체가 준비되어있음) > 컨트롤러에서 model(값)과 view를 return 받음 > return받은 view를 생성해주기 위해 Dispatcher는 viewResolver를 찾음 > 이때 기본적으로 존재하는 viewResolver가 있지만, viewResolver중에서도 setOrder가 1번으로 설정되어있는 viewResolver를 찾게됨.(현재 실습내용의 경우 TilesViewResolver) > TilesViewResolver는 리턴받은 view의 이름과, tilesConfigurer()로 설정된 tiles설정파일인 tiles.xml에서 매칭이 되는 이름이 있는지를 확인 한 뒤 있다면 해당 view를 전달한다.(만약 이 리졸버에서 view의 이름과 매칭되는것이 없다면, 기본 viewResolver에게 다시 확인하고, 그래도 없다면 404에러를 반환한다)
