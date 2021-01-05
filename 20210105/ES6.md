오늘은 ES6 5번째 시간입니다.

> ## Today I Learned
  - new.target
  - Iterator
  
### new.target
  - 함수가 위임된 경우 this를 쓸수 없다 이유는?
    - this는 객체를 통해서 함수가 호출될때 전달된다. 
    - 객체를 통해서 호출된 것이 아닌 위임을 통해 호출된 경우, this는 전달되지 않는다.
    - static method의 경우 객체를 통해 전달되는 함수가 아니므로 this 사용 불가
    - 자바스크립트의 문제점 : 인스턴스 함수를 위임해서 스태틱 함수로 사용 가능함
    - btn1의 onclick 속성에 btn1Click메소드를 위임받고, 실행될때 static하게 실행된다.
  - 그렇다면 함수를 위임할때 this를 함께 전달하려면 어떻게 해야할까?
    - function.prototype.call() or apply()
      - call() : 객체(주어진 this) + 전달된 인수 리스트
      - apply() : 주어진 this 값과 배열 (또는 유사 배열 객체) 로 제공되는 arguments 로 함수를 호출합니다.
    
![](https://images.velog.io/images/junjun-creator/post/dab1938f-abdd-41f8-b5bd-42340b7b681c/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%EC%A0%84%2011.03.27.png)

  - 하지만 이 방식에도 맹점이 존재한다
    - Alert를 통해 생성된 객체가 아니어도 call,apply를 통해 this로 전달이 가능하다... 
    - Alert의 프로토타입으로 선언된 메소드 이므로, Alert를 통해 생성된 객체로만 호출 가능하도록 한정지을 수 있는 방법이 필요하다.

![](https://images.velog.io/images/junjun-creator/post/3c24eac9-ff05-4313-ba5a-46ea8778bbfc/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%EC%A0%84%2011.22.07.png)

  - Metaproperty : java의 RTTI와 유사
    - 함수로 생성자를 만들었을 경우, new를 통해 호출되어야 한다.
    - 하지만 함수의 형태이기 때문에 new를 쓰지 않고도 호출이 가능한데.
    - 그럼 이 두가지 경우는 어떻게 구별할 수 있을것인가?
      - new.target을 통해 new를 통해 호출된것인지 판단가능
      
![](https://images.velog.io/images/junjun-creator/post/8ada1c4c-8eb0-41a8-bc44-9dfc23941c61/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%EC%A0%84%2011.23.52.png)

![](https://images.velog.io/images/junjun-creator/post/7402fbf3-df58-4d37-8939-e64a9deed734/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%EC%A0%84%2011.24.56.png)

### Iterator
  - 컬렉션 + index를 통해 next() 또는 hasNext()와 같은 메소드를 통해 편하게 사용할 수 있도록 만듬.
  - 멀티스레드에서 동일한 콜렉션을 공유하되 순회자(열거자)만 개별화 하는 방법을 사용.
  - iterator 메소드 반복(iterator를 만들어 반환하는 generator)
  
![](https://images.velog.io/images/junjun-creator/post/db409905-8d94-47c5-8085-17267134ee11/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%2012.04.05.png)

  - 자바 스크립트에서는 한줄의 코드도 없이 iterator를 구현하게 해준다.
    - Generator : iterator를 구현해주는 기능(도구)
      - function \*
      - next : {value:?,done:?}
      
![](https://images.velog.io/images/junjun-creator/post/6ba3f7de-3b0f-4ccf-8263-f707b1828f41/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%2012.21.57.png)

  - iterator를 활용한 정수를 순회하는 컬렉션 만들기
    - 주의사항
      - iterator와 iterable객체는 서로 다른개념의 객체이다.
      - iterator는 next() 메서드를 가지고, iterable객체는 Symbol.iterator 메서드를 가지고 있다.
      - iterator는 Symbol.iterator메소드가 없기때문에 for/of문으로 순회 불가능하다.
  
![](https://images.velog.io/images/junjun-creator/post/01aa924c-72f7-4a92-a4f6-9e238da799ec/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-05%20%EC%98%A4%ED%9B%84%2012.40.17.png)
