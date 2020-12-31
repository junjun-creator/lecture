오늘은 ES6를 학습하였습니다.

> ## Today I Learned
  - ES6
  
### 변수
  - let
    - 기존에 자바스크립트(ES5)는 지역변수의 개념이 없었다.
    - ES6에서는 let이라는 예약어를 통해 지역변수의 개념을 만들었다.
      - 변수명의 중복 여부도 확인할 수 있다.
  - const
    - 자바의 final과 같은 기능
    - 상수를 문자화 할 수 있다.
    - 한 번 선언되면 값을 바꿀 수 없다.

### Template String
  - 여러줄의 문자열을 쉽게 표현할 수 있다.
  - mvc를 위해 태그를 문자열로 삽입하고자 할때, 여러줄의 경우 역슬래시와 같은 표현을 일일이 다 해줘야 했다.
  - 하지만, ES6에서는 문자열 시작과 끝에 어금부호 \`\`를 감싸주면 된다.

![](https://images.velog.io/images/junjun-creator/post/61e1bf4b-b13a-4e7a-a39c-f9dc99810b5c/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%EC%A0%84%2010.42.29.png)

  - 태그 안에 데이터가 들어갈 경우 EL과 같이 사용 가능하다
  
![](https://images.velog.io/images/junjun-creator/post/0d38d9be-63a7-40c7-9aa6-96f64fe9aa4a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%EC%A0%84%2010.55.50.png)
  
  - Unescaping String
    - 어금부호 안에서 문자열 그대로 출력하고 싶을 때 사용
    
![](https://images.velog.io/images/junjun-creator/post/2811c48a-e546-4751-825e-883dbdb40d70/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%EC%A0%84%2011.00.04.png)

### 개별값 데이터 JSON 객체 만들기
  - 기존에는 JSON 형식의 데이터를 만들기 위해 키,값 쌍을 꼭 써줘야 했다.
  - 하지만, 만약 키와 값의 이름이 동일하다면? 하나만 사용해서 만들 수 있다.

![](https://images.velog.io/images/junjun-creator/post/9b9d86f6-3bd4-464e-8296-142b8e9f0ebc/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%EC%A0%84%2011.14.50.png)

  - 객체 안에 키와 값으로 들어가는 함수 또한 간략하게 표현 가능하다.
  
![](https://images.velog.io/images/junjun-creator/post/ea3c1834-5b13-4979-9689-e661fb6496e6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%EC%A0%84%2011.45.19.png)

  - 객체 내부에서 변수(객체내부속성)에 접근하기 위해서는 this를 꼭 써줘야함.
