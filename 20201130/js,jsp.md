# iframe
  - 부모객체에서 iframe에 접근 : <객체iframe>.contentWindow.document~~ // iframe은 자체 윈도우가 아니기때문에 컨텐트윈도우를 사용해야함.
  - 부모객체에 접근 : parent.document
# window
  - location : .reload()(새로고침), .replace(url)(페이지 이동, 히스토리에 남지 않음), .href=url(주소 , 이걸로 이동시 히스토리 남음)
  - history : back(), forward(), go(), length, state
# Node
  - 인터페이스
  - document : (노드)생성
  - element : 태그 정의
  - node : 조작
# 노드 순회
  - querySelector() : css 문법을 따라감
    - 여러개의 노드가 있을때 첫번째 노드를 선택함.
    - 즉, querySelector("li") = querySelector("li:first-child")
  - previous, next sibling
  - parentNode, childNode
# 속성 부여
  - 노드 선택 후, .속성명 = ? 을 통해 속성 부여 가능
---
# MVC
  - 입력처리(control), 출력데이터(model), 문서출력(view) 를 병렬로 개발하기 위해서 분리.
  - Model : 출력 데이터
# 저장소
  - pageContext : 페이지별
  - request : 서블릿이 서블릿을 호출할때 서블릿간에만 데이터 공유
  - session : 사용자별
  - application : 전체
# forward
  - 서블릿에서 하던 작업을 이어서 작업할 수 있게 전달할때
# EL 표기법
  - 뷰단에서 자바코드가 많아지면 mvc를 나눈 의미가 없어짐
  - 자바를 몰라도 저장소에 있는 정보를 가져오기 쉽게 하는 표기법
    - ${key}
