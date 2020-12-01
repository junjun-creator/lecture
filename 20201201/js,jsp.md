# 속성변환
  - 고정된(값의 변화가 없는) 속성을 바톤터치 하듯이 슬라이딩 할때는 일일이 속성값을 넣어주는게 아니라 클래스 이름을 주고, 클래스 이름을 추가하고 제거하는 방식으로 사용
    - 클래스 이름 추가/제거
      - classList.remove("name");
      - classList.add("name");
  - 객체.className = ""으로 하지 않는 이유
    - 이런 방식으로 하면 기존에 다른 클래스이름이 지정되 있는 것을 덮어 씌우는 식으로 교체해버림
    - 다른 클래스 명이 있으면 치명적인 문제 발생.
# 슬라이딩을 위한 position 속성
  - static : 위치가 정해져 있음
  - absolute : 절대위치 (원하는 위치에 배치 가능) default는 문서가 기준. 
  - relative : 상대위치(원래 있어야 할 위치)
  - fixed : 고정시킴(문서 기준)
  - sticky : fixed에서 발생하는 문제(헤더의 경우 밑의 콘텐츠 일부를 가리게 되서 임시방편으로 밑의 컨텐츠에 padding을 줘야했음)를 해결할 수 있음.
    - 헤더에 적용할 경우 fixed처럼 활용하기 위해 top=0;으로 고정될 위치를 지정해줘야함
# position을 통해서 슬라이딩
  - 기준 : 부모태그(relative)
  - 이동할 아이템 : position
  - left, right 값을 조정해서 이동.
# transform을 이용한 슬라이딩
  - position을 변경하지 않고도 위치 이동 하는 기능이 생김(css3)
  - transform()등 현재 위치를 기준으로 이동
---
# JSTL
  - foreach와 같은 제어구조를 jsp에서 자바코드가 아닌 태그를 이용하여 구현하는 것
  - c:forEach var="n" items=${list}
    - 4대 저장소에서 list라는 데이터를 가져와서 하나씩 뽑아서 pageContext에 n이라는 이름으로 저장
    - 주의사항 
      - 의미없느 빈공백을 두지 말자
    - 속성
      - begin, end : 반복 시작위치, 끝나는 위치(0,4 면 5번 반복)
        - c:forEach var="i" begin="0" end="4"
          - pageContext에 i라는 이름으로 값을 저장하여 0부터 4까지 반복함. i르 통해서 index를 가져올 수 있음
      - varStatus="status" : 반복할때 index와 관련된 속성
        - ${status.count} : 반복 횟수(1부터)
        - ${status.index} : index(0부터)
        - ${status.current} : 현재 위치index
        - ${status.first} : 첫번째인지 여부(boolean)
        - ${status.last} : 마지막읹 여부(boolean)
        - ${status.start} : 시작번호
        - ${status.end} : 끝번호
        - ${status.step} : 증가값
      - step="" : 증가값 설정
