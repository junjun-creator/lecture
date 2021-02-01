오늘은 NodeJS를 학습하였습니다.

> ## Today I Learned
  - NodeJS 등장
  - NodeJS core

### NodeJS 등장
  - 스크립트가 웹에서만 동작하는 것이 아닌, 외부에서 동작할수 있는 v8 엔진 개발
    - 탈 브라우저
  - 브라우저가 아닌 터미널에서 스크립트 인터프리터를 작동 시킬 수 있음
  - 이를 이용하여 서버 구현이 가능해짐
  - 스크립트는 비동기 형식의 단일 스레드 구조
    - 실행속도가 아주 빠름
  - 모듈 단위로 설계
    - 기존 : commonJS module
    - 10버전 이후 : ES module
    - 모듈의 고립성을 유지한 채로, 허가된 것만 가져다 쓸 수 있음
  ![](https://images.velog.io/images/junjun-creator/post/7290e5d0-792d-4c4a-83fd-b185bf2171f6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%EC%A0%84%2011.49.11.png)![](https://images.velog.io/images/junjun-creator/post/ff7b7215-262f-4a14-9891-c86d9d980643/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%EC%A0%84%2011.49.24.png)
  
  - 파일 시스템(fs)
    - 내장모듈
    - fs.readFile("파일경로","인코딩방식",콜백)
    ![](https://images.velog.io/images/junjun-creator/post/742443fc-fbc7-4294-8cda-e33f3848bafe/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%2012.01.47.png)
    
### NodeJS core 모듈
  - http 모듈 : 웹에서 입출력을 할 수 있음
  - fs 모듈 : 파일을 읽어올 수 있음
  ![](https://images.velog.io/images/junjun-creator/post/c6d12af1-8852-4b3b-b03e-3b2e39e086b7/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%202.33.20.png)
  
### 사용자 입력을 받아 요청을 제공
  - request 객체 속성
    - url
    - header 등등
    - 여기서 디렉토리를 읽어서 서버를 구현한다는것은 너무 맨땅에 헤딩
  - connect framework(middleware 프레임워크)
    - http갖고있는것 중에서 파일을 읽어서 출력
    - 요청시 파일을 알아서 읽어줌
    - 라우팅도 알아서 해줌
    - 인증, 인코딩 등 수행을 위한 코드 추가/삭제
    - 마치 서블릿에서 필터처럼 사용자에게 view를 제공해주기 전에 보안, 인증 등을 수행하게끔 함
  - express(출력)
    - 현재 우리가 사용하고있는 mvc 모델을 그대로 구현해놓은것
    
### Connect 모듈을 이용한 웹 서버 구현
  - extensible HTTP server framework for node using plugins
  - npm 설치
    - maven같은 아이, 패키지에서 사용하는 모듈들을 관리해주는 역할을 함
    - node package manager
    - 메이븐 저장소에서 dependency들을 다운받듯이 npm 노드 패키지 저장소가 있음. 거기서 모듈을 가져와서 사용
    - $ <span style="color:red;">npm i connect</span>
      - connect 모듈 다운로드
      - connect 모듈이 사용하는 모듈들도 자동으로 설치됨
    - package.json
      - 자동으로 설치되는줄 알았으나, 따로 해줘야함...!! 주의!!
      - 설치한 dependency들의 목록을 관리함.
      - 메이븐처럼 dependency 추가 및 관리 가능
      ![](https://images.velog.io/images/junjun-creator/post/74a1160a-e1d9-4650-8d3e-467293f14bfa/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-27%20%EC%98%A4%ED%9B%84%2011.53.36.png)
      
  - connect 모듈 사용하기
    - 서버 연결
    ![](https://images.velog.io/images/junjun-creator/post/f90df464-322c-4e70-b2de-c6b59be49fb2/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2012.03.40.png)
    - connect().use()를 사용하여 url 매핑
      - req : 응답 정보
      - res : 결과 정보
      - next : 미들웨어 로직 연결해주는 역할(filter chain처럼)
    ![](https://images.velog.io/images/junjun-creator/post/cbedd3d3-81a7-4e7b-a288-5aa13a925b5a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2012.29.17.png)

### express 모듈을 사용하여 서버 구현
  - HTTP
    - networking
    - request, response
    - event
    - listening
  - CONNECT
    - middleware
    - static file
    - badyParser
  - EXPRESS 
    - routing
    - template view engine
    - 웹 개발하는데 사용되는 모든 기능들이 여기에 들어있음(web framework)
      - 파일 업로드
      - 인증
      - 기타 등등
  - connect(압축, 인코딩, csrf 공격, static 파일에대한 내용 꽂아넣기) + view 엔진 + routing 기능 포함
  - java + tomcat의 관계와 같음
    - 백엔드단(api 제공)
  - view 엔진
    - 모델의 데이터를 view에 꽂아주는 역할
  - express 모듈 설치
    - $ <span style="color:red;">npm i express</span>
  - 서버 실행
  ![](https://images.velog.io/images/junjun-creator/post/70f8f5b3-acfe-470f-8a68-e2c9c04eb824/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%201.03.44.png)
  - url 매핑
  ![](https://images.velog.io/images/junjun-creator/post/61f39f18-b437-4c80-8130-b3619145285f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%201.09.21.png)
  - express 만을 사용하여 서버를 만들 경우, 온전한 http의 기능을 쓰는것이 아닌 express를 통해서 쓰는것이 됨
    - http를 온전히 쓰는것이 아닌 express로 wrapping된 기능만 사용하는 것이 됨
    - 이 경우엔 express를 통해 네트워킹을 하고있음
    - 네트워크 설정을 위해 express와 http를 분리한뒤 나중에 결합해서 사용하는 방식 사용
    - 이 방식을 통해 http의 기능을 맨땅으로 사용 가능하고 + express에 추가된 기능들도 사용할 수 있다.
  - routing
    - 스프링에서 컨트롤러가 url매핑과 관련된 작업을 했다면, router를 이용해 url 매핑을 컨트롤러처럼 구현할 수 있다
    ![](https://images.velog.io/images/junjun-creator/post/2ee57f1b-e696-4447-b4e7-88e2ed0c660f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2011.13.12.png)![](https://images.velog.io/images/junjun-creator/post/8cf2cb8a-6427-45b4-aed2-4c6e2a21e2f4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2011.13.28.png)
  - express view 엔진
    - ejs : 짜여진 html 코드에 el태그처럼 값을 꽂아넣을 수 있음
    - 다른 view 엔진(jade, pug 등)
      - 기존 html코드에 값을 끼워넣는게 아니고, html코드를 쉽게 generating 해서 값을 꽂아서 사용하는 방식...
      - 대용량 view를 구현하는데 효율적이지 못해보임.
  - ejs 설치(view 엔진)
    - $ <span style="color:red;">npm i ejs</span>
  - view 렌더링
    - .ejs view 파일 생성
    ![](https://images.velog.io/images/junjun-creator/post/82ffe52e-e75f-4af7-a745-832dea4dbc5b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2011.53.50.png)
    - expres가 사용할 view 경로 설정
      - express().set()
      ![](https://images.velog.io/images/junjun-creator/post/2d680c3c-d421-476a-bbef-a86cefa1ea3a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2011.54.32.png)
    - 렌더링
    ![](https://images.velog.io/images/junjun-creator/post/998c5c27-6a71-48e7-a387-9df07bfb3f3c/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%EC%A0%84%2011.55.13.png)
  - view 데이터 binding
  ![](https://images.velog.io/images/junjun-creator/post/d12904a0-b871-4020-a6bb-e23121a6a697/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%ED%9B%84%2012.06.45.png)![](https://images.velog.io/images/junjun-creator/post/e8c5a9a5-11ac-4dd0-8962-b81beaeb666d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%ED%9B%84%2012.16.18.png)
  - 라우터를 활용하여 json 객체를 반환하는 api 만들기
  ![](https://images.velog.io/images/junjun-creator/post/32857202-fdfa-4bd6-bc85-81c837c2944e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-28%20%EC%98%A4%ED%9B%84%2012.24.25.png)
  
### express generator
  - nodejs + express를 활용하여 웹 개발을 할때 기본적인 설정을 해둔 상태로 그것을 모듈로 제공한다면? 편리할 것이다.
  - http, path, express 등 모듈들의 기본 세팅
  - 그것을 제공하는 것이 express generator이다.
  - $ <span style="color:red;">npx express-generator [--view=view엔진명] [폴더이름]</span>
    - 현재 디렉토리에 있는 모듈들을 설치해야함
      - $ <span style="color:red;">npm i</span>
  - package.json의 scripts에 간편 명령어들을 정의할 수 있다.
    - start : 서버 실행을 위한 명령어
  - 주의사항
    - Root 디렉토리(/)의 경우엔 express가 static 문서들을 먼저 참조한다면 index.html을 먼저 찾게됨.
    - 라우터를 먼저 연결해주고 static을 연결 해주면 해결됨
    ![](https://images.velog.io/images/junjun-creator/post/813e1ad8-991f-4e70-ab6e-8e764ed72c00/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%EC%A0%84%2010.52.26.png)

### url 매핑 및 view rendering
  - controller(router) 만들기
  ![](https://images.velog.io/images/junjun-creator/post/7186556e-d9ae-4c76-8be7-af4a502a3560/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%EC%A0%84%2011.26.16.png)
  - express가 해당 controller 사용하게 하기(app.js에서)
  ![](https://images.velog.io/images/junjun-creator/post/3e2e09ce-0785-4b86-ae74-c2bb4fbde289/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%EC%A0%84%2011.27.18.png)
  - controller(router)에서 url 매핑 및 렌더링 설정하기
  ![](https://images.velog.io/images/junjun-creator/post/c6ff9faf-e3ed-44d6-b2ce-6a4c2836f632/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%EC%A0%84%2011.28.07.png)
  
### database 모듈 사용
  - 모듈 설치
    - $ <span style="color:red;">npm i mysql</span>
  - connection 객체를 통해 query 실행
  ![](https://images.velog.io/images/junjun-creator/post/3b5850ca-9a6b-4fba-9efd-26f83e322cf4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%ED%9B%84%2012.27.50.png)
  - view에 값 넣기
  ![](https://images.velog.io/images/junjun-creator/post/3ff59ce4-8200-4831-bed0-43c6dc54c9c5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%ED%9B%84%2012.28.49.png)
  
### 데이터베이스 모듈 분리
  - 매 라우터마다 데이터베이스 모듈을 사용하는 코드가 있다면 비효율적이다.
  - 집중화하여 필요한 곳에 꺼내 쓸 수 있도록 구성한다.
  ![](https://images.velog.io/images/junjun-creator/post/df032a4b-1aa8-49b7-b887-728bd84e0847/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-01%20%EC%98%A4%EC%A0%84%2010.13.00.png)![](https://images.velog.io/images/junjun-creator/post/f7f3d5a2-ba04-49dc-b0bb-ab0da0cca0fd/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-01%20%EC%98%A4%EC%A0%84%2010.13.13.png)![](https://images.velog.io/images/junjun-creator/post/6d63d572-951c-425c-b7dc-9fc9fd8c7931/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-01%20%EC%98%A4%EC%A0%84%2010.13.28.png)
  
### nodeJS와 ReactApp 연동
  - Node > ReactApp > Babel > Module(X):WebPack > bundle(배포본) > pure js
  - 페이지를 컴포넌트 단위로 쪼개서 갈아끼우는 형식으로 SPA 구현
    - App.js에 각각에 컴포넌트들을 끼워넣고 조립된 것을 리턴
    ![](https://images.velog.io/images/junjun-creator/post/2aa6be59-5eb4-42da-8019-987be01e8ef0/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-01%20%EC%98%A4%ED%9B%84%2012.37.49.png)
    - index.js에서 그 조립된 App을 사용
    ![](https://images.velog.io/images/junjun-creator/post/32876a63-72bf-4301-82fb-fed9d1f863e5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-01%20%EC%98%A4%ED%9B%84%2012.38.59.png)
  
### commonJS vs ES6 module
  - package.json에서 type 설정
  - module.exports vs export & import
  - 외부 모듈을 사용할때 왜 ES6 module을 안쓰고 commonJS를 쓰나?
    - 호환성 문제
    - 환경변수(\_\_dirname 등), 등 모듈이 사용하고 있는 기능들이 commonJS를 사용하고 있어서 호환성 문제가 생김 

### React app 생성
  - $ <span style="color:red;">npx create-react-app my-app</span>
  - node로 서버 실행 후 react와 연동 가능
  - 질문 사항
    - 어떻게 서버가 실행되고 리액트 app과 연동되서 view를 구성하는지?

### 번외
  - 모듈을 설치하기 전, 꼭 package.json 파일 만들어야함
    - $ <span style="color:red;">npm init</span>
    - 만든 다음 모듈 설치하기
  - 모듈을 다른곳에서 쓰고싶을때??
    - package.json만 옮겨서 install 해주면 됨
