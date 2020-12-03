# 노드 Replace - insertAdjacentElement
  - 부모의 태그를 통해 삽입을 하는 것이 아니라 타겟을 정해서 원하는 위치에 삽입할 수 있음
    - beforebegin : 타겟 엘리먼트 기준 앞에(previousElementSibling)
    - afterbegin : 타겟 엘리먼트의 첫 자식
    - beforeend : 타게 엘리먼트의 마지막 자식
    - afterend : 타겟 엘리먼트 기준 다음에(nextElementSibling)
  - insertAdjacentHTML, insertAdjacentText 도 존재
  - replace 이후 삽입과정에서 기준노드를 찾고 삽입하는 것보다 index를 알아내서 삽입하는것이 더 좋다.
# append
  - 복잡한 구성의 자식을 추가하고 싶을땐 어떻게 편리하게 처리할 수 있을까?
    - 1번 : innerHTML 활용하기(구식)
      - 삽입할 태그의 내용을 변수로 선언하여 문자열로 저장하고 innerHTML 로 삽입
      - 문제점
        - 문자열을 중첩하여 추가하는 방식은 처리속도에 치명적임(복잡도 증가)
        - innerHTML이 건물을 짓는 개념이라면, 기존에 있던 건물으 모두 허물고 기존건물+새건물을 새로 짓는 것과 같은 방식으로 동작함
        - 그래서 추가해야할 내용이 많을때 처리속도에 문제가 발생함
    - 2번 : template 등을 이용하는 방법
    - 3번(best) : insertAdjacentHTML 활용
      - target을 container로 설정하여 beforeend에 삽입하게 되면 append와 같은 효과이다.
      - 장점
        - 추가를 위해 추가 위치의 탐색이 필요 없어서 높은 처리성능을 가지고있음.
        - 처리 효율이 좋아서 대량의 태그 추가에도 문제가 없음.
# 선택된 아이템 삭제 방식
  - 바람직하지 않은 방법
    - 1. item목록 얻기
    - 2. item들을 반복적으로 순회하면서 checkbox를 얻어옴
    - 3. checkbox의 상태가 checked인 것들만 추려서 array에 담음
  - 바람직한 방법(pseudo class)
    - querySelectorAll("input[checkbox]:checked");를 활용하여 한번에 탐색 가능
---
# doGet,doPost
  - service와의 차이
    - 사용자의 요청 > init()호출 > init이 service()호출 > service가 method에 따라서 doGet(),doPost()호출
    - doGet(), doPost() 사용시 service()를 오버라이드 하면 요청이 전달되지 않는다.
      - 해결방법
        - 오버라이드 한 service()에서 super.service(req,resp); 호출
        - 오버라이드 하지 않기.
  - service()는 요청의 종류가 한가지 일때만 사용하고 구분이 필요한 경우엔 do메소드를 사용하자.
# input type="hidden"
  - 사용자가 직접 입력하는 값이 아닌 값을 request로 전달하고자 할때 사용
  - 사용법은 보통 input 태그와 동일
# SQL UPDATE
  - 기본적인 service 클래스에서의 동작은 insert와 유사하다.
  - query만 바꿔주면 된다.
    - UPDATE NOTICE SET title=?, content=? WHERE id=?;
# SQL DELETE
  - 기본적인 service 클래스에서의 동작은 insert와 유사하다.
  - query만 바꿔주면 된다.
    - DELETE FROM NOTICE WHERE id=?;
