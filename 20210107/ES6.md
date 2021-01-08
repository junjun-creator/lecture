ES6 7번째 시간입니다.

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
    - 에러(예외)를 반환할 경우, 그 다음 then은 reject가 실행되며, catch가 있다면 catch가 실행된다.
    
![](https://images.velog.io/images/junjun-creator/post/76cac706-891f-489b-9d13-c8c6b0fbbf8f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%2010.21.47.png)

  - then이 리턴이 없다면
    - undefined value를 가지고 then을 resolve
    
### promise all
  - 여러개의 비동기 처리를 한번에 수행하고 싶을때 사용
    - 모두 성공해야 then(resolve) 실행
    - 하나라도 reject 되면 then(reject)실행

![](https://images.velog.io/images/junjun-creator/post/24c75c7a-5710-4e9e-8a83-498f63ace957/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2010.58.50.png)
    
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

  - 그렇다면 모듈이 변경되거나, 모듈 내의 다른 함수를 import해오고 싶을 때는 어떻게 해야하나?
    - export default, export
      - import t1,{test2,test1} from './module1.js';
      - module1.js에서 export default 된 메소드를 t1이라는 이름으로 import.(이름 임의 변경 가능)
      - module1.js에서 test2,test1이름의 export 함수를 가져옴(이름 임의 변경 불가)
        - 이름 변경을 위해 as로 명명 해줘야함
        - import {test as m2test} from './module2.js';
        
![](https://images.velog.io/images/junjun-creator/post/3f4866b1-d4f0-4511-ad83-0cfcf1c216d6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.29.59.png)![](https://images.velog.io/images/junjun-creator/post/66c2559a-d697-4ff2-a6ae-e44f2642d8b3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.30.05.png)

  - 클래스 export & import
    - 클래스답게 new 생성자를 통해 생성하고 사용할 수 있음
    
![](https://images.velog.io/images/junjun-creator/post/c125e7ee-55dd-40d4-9fec-97f902837240/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.35.02.png)![](https://images.velog.io/images/junjun-creator/post/ab8f10c6-a05a-4907-aee5-b99d3aff3835/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.35.09.png)

  - 객체 자체를 노출
    - 전역객체화
    
![](https://images.velog.io/images/junjun-creator/post/c890556e-8896-4205-a7bb-f01010cbacf4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.57.29.png)![](https://images.velog.io/images/junjun-creator/post/3ac5e799-288d-4622-bab2-abea37aa5fd5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.57.38.png)![](https://images.velog.io/images/junjun-creator/post/ccd629a0-8158-4f43-92e7-c80546eb4706/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%EC%A0%84%2011.57.45.png)

  - 고립화가 아닌 공개scope에 두고 원할때 꺼내 쓸수 있게 끔 하려면
    - import는 로드시 무조건 가져오게 되는 것
    - 원할때 특정 모듈을 가져오려면?
      - import("./json.js") 함수
      - 서버상에 동적으로 데이터를 요청할 수 있음 (ajax없이)
        - import(./api/notice/list)
    - import() 메소드로 호출된 것은 모두 scope에 들어가게 됨.
      - 고립화가 존재하지 않음.
      - 그저 가져와서 실행하는 것 뿐
      
![](https://images.velog.io/images/junjun-creator/post/bd2b90e6-2aee-482f-b0ce-a17af0cad150/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%2012.07.18.png)

  - 그렇다면 원하는 함수만 원하는 시점에 가져와서 쓰고싶을 때는 어떻게하나?
    - await import();(with async())
    - 기본적으로 import 함수는 비동기형이다.(메인함수를 잠식시킨채로 다른 함수를 가져와서 실행할 수 없으므로)

### await와 then
  - 기본적으로 await와 then을 활용하기 위해서는 함수가 promise객체를 반환해야한다.
  - async/await를 사용할 경우
    - promise가 await에게 넘겨지면 await은 promise가 fulfill되기를 기다렸다가 해당 값(resolve될 값)을 리턴한다.
    - 만약 promise가 reject되면, reject된 값이 throw됨.
    
![](https://images.velog.io/images/junjun-creator/post/7afcf905-3265-4e69-bda4-2069aea2b5b8/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%201.55.24.png)![](https://images.velog.io/images/junjun-creator/post/f126636e-980f-4f05-ac3d-298ea3769abe/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%201.56.52.png)

  - await는 비동기함수가 실행을 마칠때까지 기다리는 동기화 작업을 한다.
  - promise가 await에 넘겨지게 되면, resolve또는 rejecte될 값을 반환(또는 throw)하게 된다
  - 이렇게 반환된 값을 then, catch 할 수도 있다.
  
![](https://images.velog.io/images/junjun-creator/post/cb854ba3-7255-41c5-aa24-8ff15e58a12f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-08%20%EC%98%A4%ED%9B%84%202.01.03.png)

  - 결론
    - await는 비동기함수가 실행을 마칠때까지 기다린다.
    - await를 통해 resolve될 값(객체 등)을 반환 받을 수 있다.
    - then은 promise를 통해서 비동기적으로 값을 반환 받고 그 반환된 값을 이용하고자 할 때 사용한다.
    - 비동기함수의 결과를 사용하기 위해 기존에는 함수를 인자로서 전달하여 위임하는 방식으로 비동기 결과를 통해 얻은 것을 비동기 함수 내에서 사용하곤 했다.
    - 위임을 하는것이 아닌 그 비동기 결과가 나온 뒤에 그 값을 이용하여 어떤 함수를 처리하고자 할때, Promise/then을 사용하는 것이다.
    - 결국, then과, await 모두 비동기 함수 실행결과를 return 받는것은 동일하나, await은 값의 형태로 전달 받고, then은 resolve(또는 reject) 함수의 인자로 전달 받는 차이가 있다.
