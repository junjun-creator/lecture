# setTimeout()
  - setTimeout(function, time, argu);
  - setInterval : 일정 주기로 수행
    - clearInterval : setInterval 함수 안에서 종료 조건 설정
# 노드의 생성과 삭제, 검색
  - 노드의 추가 삭제 등은 부모객체가 할 수 있지만, 생성은 document만 가능하다
  - name 속성을 통한 검색은 문서 전체에서 document를 통해서만 가능하다.
  - section 안에서의 지역변수로서 class를 쓰는게 좋다.
# open(url)
  - url 주소로 새로운 창을 띄움.
  - 하지만 그냥 새로운 탭으로 창이 뜬다.
  - 작은창으로 현재 창 위에 띄울때는?
    - window.open(url, name, specs, replace);
    - name : 새창으로 띄울지, 부모창에 띄울지 등등 선택
    - specs : 크기 등을 선택
    - replace : ??
  - 여는놈과 열리는놈의 관계를 잘 파악해야함.
    - opener(여는 놈) : 열리는놈이 여는놈을 참조할때
    - open 객체생성 : 여는놈이 열리는놈을 참조할때
# iframe
  - 하나의 페이지 안에 또다른 페이지를 삽입.(src)
---
# MVC
  - Model : 출력 데이터
  - View : 출력문서
  - Controller : 입력과 제어를 담당
# JSP로 페이지 만들기
  - 필수요소
    - entity
    - service(jdbc)
    - JSP
      - 코드블록을 통해 service 객체 생성후 데이터베이스에서 데이터를 읽어와서 사용
