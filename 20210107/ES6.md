오늘은 ES6 7번째 시간입니다.

> ## Today I Learned
  - async, await
  - promise - then, catch
  - ES Module
  
### async, await
  - 비동기로 수행되는 함수를 호출하면서 동기적으로 일을 수행하고 싶을때(얼마 안걸릴거같으니 비동기 끝나면 다음거 수행하자) await 키워드를 통해 기다리게 할 수 있다.
  - 이 await를 사용하기 위해서는, 해당 비동기 함수를 호출하는 함수가 비동기형이라는것을 명시해줘야한다(async)
  
![](https://images.velog.io/images/junjun-creator/post/3f6dc6d7-ff2f-4382-814d-a71c3b08be20/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%209.53.11.png)

### promise-then
  - then(func1,func2)를 통해 각각 resolve와 reject 결과로 실행 되게끔 해주면 된다.
  - 성공과 실패시 각각 인자로 전달된 함수가 실행된다.
  
![](https://images.velog.io/images/junjun-creator/post/6c450426-9c9b-4a48-ba4c-7561c6c19b65/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%2010.12.59.png)

  - 꼬리에 꼬리를 무는 then
    - then을 활용하여 변환코드, 분쇄코드, 인코딩 코드 등을 수행하고, 그 결과를 출력하는 로직을 만들 수 있다.
    - then을 통해 수행된 결과를 다음 then에게 return으로 넘겨주게 되면, 그 결과를 then으로 호출되는 함수의 인자로 전달한다.
    - 만일 리턴값이 또다른 비동기함수를 호출할 경우, 또다시 promise를 통해 성공 또는 실패에 따라 해당 함수가 실행된다.
    
![](https://images.velog.io/images/junjun-creator/post/76cac706-891f-489b-9d13-c8c6b0fbbf8f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%2010.21.47.png)

  - then이 리턴이 없다면
    - undefined value를 가지고 then을 resolve
    
### ES Module
  - 부품 + isolation(고립성)
    - 다른 부품에 영향을 미쳐선 안됨.
    - 자바스크립트는 어디서든 사용 가능했었음...
  - 모듈을 동적으로 로드하는 방법이 없다.
    - load 기능이 생기고, 각 모듈별 충돌을 제어할 수 있는 방법이 생김
    - 그게 바로 ES 모듈
  - 과거버전 모듈 불러오기
    - 함수이름이 충돌되면 뒤에 불려온 모듈의 함수로 적용됨
    
![](https://images.velog.io/images/junjun-creator/post/fcb6e654-adaf-4a60-bb97-a78278ae27f2/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%2012.08.54.png)

  - import
    - 함수가 한두개도 아니고, 그 함수가 리턴하는것이 다양함.
      - 단순히 import만을 가지고 함부로 가져다 쓸수 없음(고립화)
    - 허가를 위해서 가져오고자 하는 모듈이 export 설정을 해줘야 함.
    - import하는 모듈이 html에서 호출될때 type을 모듈이라고 설정해줘야함.
    - 또한 import하고자 하는 모듈의 경로를 절대 또는 상대경로로 꼭 지정해줘야함
    
![](https://images.velog.io/images/junjun-creator/post/be0e571a-503f-4ca8-b1f3-5c9db7751a37/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%ED%9B%84%2012.20.17.png)

  - 그렇다면 모듈이 변경되거나, 모듈 내의 다른 함수를 import해오고 싶을 때는 어떻게 해야하나? 다음시간에 배워보도록 합시다
