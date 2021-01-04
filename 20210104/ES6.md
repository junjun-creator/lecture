오늘은 ES6 4번째 시간입니다.

> ## Today I Learned
  - OOP(캡슐화)
  
### OOP(캡슐화)
  - 과거에 객체 생성 방식
    - function으로 class를 정의했음
      - 마치 클래스가 정의되어있는 것 처럼
      - 절차에 의해 정의되는.. 미리 정의 되는 것이 아니다..(자바스크립트 특징)

![](https://images.velog.io/images/junjun-creator/post/13650034-421a-4ed6-9ed2-a57f07a2a356/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%EC%A0%84%2010.16.30.png)

  - 조금 더 개선 된 방식(중복 생성 제거)
    - prototype으로 미리 만들어 두고, 객체를 생성할때마다 미리 만들어둔 것을 참조하게 만듬.(몇개의 객체를 생성하더라도 참조는 1개임)
  
![](https://images.velog.io/images/junjun-creator/post/def59bdd-b4ed-45a1-b409-0b2e157badb1/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%EC%A0%84%2010.36.53.png)

  - 현재(ES6)

![](https://images.velog.io/images/junjun-creator/post/29662d60-3303-42e5-b2d5-db1930be9e7b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%EC%A0%84%2010.55.48.png)

  - getter,setter, 전역변수(static)

![](https://images.velog.io/images/junjun-creator/post/97528fe8-b06e-40ee-a70b-59716c1a4ba3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%2012.44.42.png)

  - 상속, 오버라이딩
  
![](https://images.velog.io/images/junjun-creator/post/fdc108ad-b153-4c16-bd6d-5f373e555517/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%2012.51.56.png)

  - ES6 OOP 특징
    - 클래스 내부의 모든 코드는 strict모드로 작성됨
    - 클래스 내부의 모든 메소드는 열거할 수 없음
    - 클래스는 반드시 new를 통해서만 객체 생성 가능
    
![](https://images.velog.io/images/junjun-creator/post/c3936f74-4227-46ae-a4a4-2bdd25b2fa23/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-04%20%EC%98%A4%ED%9B%84%201.12.39.png)
