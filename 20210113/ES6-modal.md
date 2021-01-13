오늘은 modal 페이지를 만들어보았습니다.

> ## Today I Learned
  - Modal
  
### Modal
  - alert, confirm과 같은 창을 window가 아닌 새롭게 디자인한 modal 페이지로 만들고자 한다.
  - 한번 만들어두면 재사용하기 쉽게 만들 예정
  
### 클래스 객체 생성을 통한 modal box 생성
  - modal box 생성을 위한 클래스 정의
  
 ![](https://images.velog.io/images/junjun-creator/post/6b9bba4f-e8af-4114-8844-aa1aef24977b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.30.10.png)
 
  - 정의된 클래스로 객체 생성 후 modal box 생성
  
 ![](https://images.velog.io/images/junjun-creator/post/b2257605-3734-4029-8435-efa9fe2f22e6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.31.15.png)
 
### 클래스의 전역함수를 통한 modal box 생성
  - constructor와 클래스 내부의 공통분모들을 제거하고, 필요한 기능만을 제공
  - 클래스 정의
  
 ![](https://images.velog.io/images/junjun-creator/post/27a8b3a4-bf6b-4480-9c95-65443387f85f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.33.57.png)
 
   - 클래스의 static 메소드 호출을 통한 modal box 생성
   
  ![](https://images.velog.io/images/junjun-creator/post/90bb3b2c-4223-4801-9d0f-3b5c382f6e5e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.35.16.png)
  
### modal box 확인/취소 버튼 기능
  - modal box가 열리자마자 값을 리턴하게 하면 안됨
  - 그렇다고 결과를 받기까지 메인 스레드를 멈출 수도 없음
  - 버튼을 누른 뒤에 결과를 활용하기 위해 callback함수를 전달하고, 완료 후에 전송된 callback을 실행하는 방법을 사용한다.
    - promise를 활용하자!
    
 ![](https://images.velog.io/images/junjun-creator/post/f917b14a-8474-455a-bbc6-87d09bcffee7/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.56.58.png)![](https://images.velog.io/images/junjun-creator/post/27182580-c2c7-4472-bd82-fe2c69675d99/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2010.57.20.png)
	
### Modal box 등장 effect 부여
  - 뒷배경이 서서히 어두워지게 하기
    - 자바스크립트는 실행시 동일 속성들을 모두 모아서 뒤에 적용된 아이만을 실행하는 특성이 있다.
    - 예를들어 같은 함수를 호출하는 경우 내용이 같은건 덮어 씌우기 해서 한번에 실행해버림.
      - setTimeout에 시간을 설정하지 않으면 비동기적으로 연결을 끊어서 서로 다르게 작동하게 만들 수 있음
     ![](https://images.velog.io/images/junjun-creator/post/e57f3895-951c-49b4-91ca-8d279bb7246a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2011.10.19.png)
      - 이 경우에 먼저 위의 set 함수를 실행하고, opacity가 transition을 가지고 변경된다.
  - 뒷배경이 어두워진 뒤에 modal box 나타나게 하기
    - 배경의 transition이 종료된 후에 나타나게 만들기
      - addEvent : transitionend
      
     ![](https://images.velog.io/images/junjun-creator/post/7b9a2a03-c657-4c30-8f9e-ee05a0a3926a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2011.14.32.png)
     

