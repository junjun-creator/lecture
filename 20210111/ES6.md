오늘은 ES6 9,10번째 시간입니다

> ## Today I Learned
  - Drag and Drop
  
### Drag and Drop

![](https://images.velog.io/images/junjun-creator/post/6ae09106-00e3-42c9-9fd2-a89d19e738ea/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.53.31.png)

  - 드래그 드랍을 위한 박스 2개 만들고, 마우스가 큰 박스 안에서 움직일때 작은박스가 커서와 함께 움직이도록 이벤트 달아주기
  
 ![](https://images.velog.io/images/junjun-creator/post/86e5a022-86c1-4dc2-b43e-f7fe7b21f564/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.54.00.png)
 
  - 클릭시에만 작은 상자가 커서를 따라다니도록 설정
  
 ![](https://images.velog.io/images/junjun-creator/post/de16bf53-da04-42ff-a3b5-83fa58a008ae/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.55.06.png)
 
  - 상자에서 클릭한 위치 유지한채 드래그 하게 설정하기
    - offset활용(이벤트 객체)
    
 ![](https://images.velog.io/images/junjun-creator/post/625c0fa0-dd00-435b-a6f7-2d958964434b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2011.27.46.png)
 
  - 스크롤바 내릴 시, 스크롤바 만큼 위치가 달라지는 문제 해결 방법
    - 큰 컨테이너 안에서 상대위치 사용하기
    - 천테이너의 offset 위치를 얻어서 box위치를 추가 보정하는 방법
    - 첫번째 방식으로 해결해보자.
    
   ![](https://images.velog.io/images/junjun-creator/post/d369aad2-b86e-41b6-9b5b-12c3da9f0762/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2010.34.27.png)
   
  - 컨테이너가 2개 이상일 때 박스 선택에 따른 드래그 설정
  
 ![](https://images.velog.io/images/junjun-creator/post/f91b1c0e-a7d0-4311-aa8b-85b7c3b8a792/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2010.35.31.png)
 
### 재사용가능한 캡슐화

![](https://images.velog.io/images/junjun-creator/post/a2106459-e225-47c2-83b1-e64de309b049/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.11.01.png)![](https://images.velog.io/images/junjun-creator/post/eeff12a5-bc9c-4b99-b90a-178adbe67a78/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.11.10.png)

  - 주의사항
    - 외부에서 내부 this값을 사용하려 할때는 this를 전달해줘야함.
    - 현재 예시에서는 mouseHandler()가 호출될때 this가 무엇인지를 모름. 그래서 그걸 알려줘야함
      - bind(this)
      
   ![](https://images.velog.io/images/junjun-creator/post/2b9e3582-5227-49fe-b369-414ce2c1c53b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.31.18.png)
  
