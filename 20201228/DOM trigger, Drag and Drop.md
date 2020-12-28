오늘은 DOM 이벤트 Trigger와 Drag and Drop이벤트에 대해서 학습하였습니다.

> ## Today I Learned
  - DOM 이벤트 Trigger
  - Drag and Drop
  
### DOM 이벤트 트리거
  - 파일 업로드를 위한 파일 선택 ui를 꾸미고 싶다?
    - input file은 스타일이 먹지 않는다.
  - input file을 display none으로 숨기고, 대체하는 버튼을 디자인해서 만듬 >> 이게 방아쇠 역할을 한다 해서 트리거라고 함
  - 즉, 실제 이벤트가 해당 태그에서 일어나는 것은 아니지만, 마치 그곳을 통해 일어나는 것 처럼 보이게 할 수 있음
![](https://images.velog.io/images/junjun-creator/post/17c7b166-f483-45f5-a6ec-7f5c43c2de07/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%EC%A0%84%2010.41.28.png)
![](https://images.velog.io/images/junjun-creator/post/2a3b4d75-2b4b-4964-8d35-02b0089a7ccb/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%EC%A0%84%2010.42.21.png)
  - 이벤트를 생성해서, dispatch해줘서 생성한 이벤트를 강제로 실행하게 만든다.
  
### Drag and Drop Event
  - 시각적(mouseEvent)
    - 클릭후 드래그 하는 과정에서 보여지는 시각적인 이벤트를 다룸
    - 마우스가 들어갓다 나올 때 이벤트 발생 순서
      - over > enter > move > out > leave
      - over,out은 해당 엘리먼트의 경계선에 진입할 때
      - enter, out은 커서가 완전히 엘리먼트 안(밖)으로 갈 때
      
![](https://images.velog.io/images/junjun-creator/post/23229562-2934-418f-9ba0-9af320404656/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%EC%A0%84%2011.34.11.png)
![](https://images.velog.io/images/junjun-creator/post/35da5b19-44d8-4e73-8ff8-e652471587ad/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-28%20%EC%98%A4%EC%A0%84%2011.34.26.png)

  - 시각적 이벤트로서 drag and drop
    - onmousemove에서의 clientX(Y)와 screenX(Y)의 차이
      - client는 viewport기준, screen은 전체 화면 기준
	  - 그렇다면 상자를 클릭하고 드래그 할때, 상자의 위치가 클릭한 위치를 유지하려면? >> 다음시간에 학습!
  - 기능적(drag and drop Event)
    - 다음시간에 학습!
