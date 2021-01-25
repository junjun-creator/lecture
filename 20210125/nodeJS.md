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
  - http 모듈을 이용하여 웹에서 입출력을 할 수 있음
  ![](https://images.velog.io/images/junjun-creator/post/c6d12af1-8852-4b3b-b03e-3b2e39e086b7/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%202.33.20.png)
