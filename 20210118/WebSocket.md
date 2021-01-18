오늘은 채팅을 구현하기 위한 web socket을 학습하였습니다.

> ## Today I Learned
  - Web Socket

### Web Socket
  - Web Socket URL mapping을 위한 config 클래스 생성
  ![](https://images.velog.io/images/junjun-creator/post/0b851fc0-0d88-419e-acc3-6aa532d9a438/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.33.41.png)
  
  - mapping된 소켓을 다루기 위한 Handler 클래스 생성
  ![](https://images.velog.io/images/junjun-creator/post/653be2fb-56d2-477d-a3ab-2a7d2e93862d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.34.46.png)
  
  - 간단한 ui 구현
  ![](https://images.velog.io/images/junjun-creator/post/947b6acb-6843-4f4d-8bd3-ac8ed717e634/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.36.52.png)![](https://images.velog.io/images/junjun-creator/post/5494fc35-7b06-4687-a4c6-f571f79020b2/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.37.14.png)
  
  - 소켓 연결 설정
  ![](https://images.velog.io/images/junjun-creator/post/613d4803-8f9f-42be-9358-24f59bec1e6f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.37.49.png)
  
  - 텍스트만 처리하기 위한 WebSocketHandler 클래스 정의
    - 인터페이스를 구현하여 사용하는 것이 아닌 텍스트만을 처리 하기 위한 어댑터를 상속받아 사용함
  ![](https://images.velog.io/images/junjun-creator/post/2c16ae74-47a5-439b-b53e-1f2fecfd4dcd/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.43.43.png)
  
  - 접속 인원이 여러명일때?
    - 각 세션을 모두 가지고 있는 상태로 메시지를 다루어야한다.
    - thread에 안전하고, thread lock기능을 내포하고 있는 arraylist 사용
      - CopyOnWriteArrayList()
  ![](https://images.velog.io/images/junjun-creator/post/152e7910-9ecb-4653-86ae-96b2f1fc40f3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%EC%A0%84%2011.53.03.png)
  
  - json형식으로 메시지 데이터 전송
    - 서버에서 json파일을 처리 또는 미러링
  ![](https://images.velog.io/images/junjun-creator/post/d9a1d37c-0cb0-4199-bb2c-7efe6c605e5f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-18%20%EC%98%A4%ED%9B%84%2012.22.55.png)
