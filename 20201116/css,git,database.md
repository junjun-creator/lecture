# align-content
  - flex에는 line들이 존재함
  - flex lines를 무시하고 packing 함
  - align-items는 라인을 유지한채로 정렬을 함
  
# align-self
  - flex item에서 설정할 수 있는 정렬방법
  
# width와 flex-basis
  - basis값이 우선이다. 하지만 basis가 auto일 경우, width값을 따라간다 (방향이 row인 경우)
  - basis가 0일때, 컨텐츠의 너비만 남음
  - basis가 0이면, 틈새만 있다면 끼어듬(wrap 시) 규칙을 깨버림
  
# flex item들의 margin
  - 적용가능. auto 설정시 여백을 다 가져다 씀.
  
# content block 꾸미기
  - 아이템들의 모양을 잡고, 배치한다.
  - 로고만들기
    - <h1><a href="index.html"><img src="../img/logo.png" alt="뉴렉처"></a></h1>
    - alter에 해당 이미지의 의미를 적어줌
  - 태그의 이름이 바뀔 수도 있을때는 class 속성 적용
  - float
    - content의 왼쪽정렬 오른쪽정렬(띄워서)
  - content block의 크기는 content에 딱 맞게 맞춰야함(여백 줄이기)
    - inline-flex 사용(ul태그일경우 사용가능)
    - 박스 자체를 inline-block 설정
  - font 설정
    - font-family : 돋움, Arial, sans-serif(폰트-족보) 등 여러개의 폰트를 쉼표로 구분하여 작성가능(우선순위)
    - font-size : 글자크기
    - font-weight : 폰트 두께
  - a태그의 pseudo class
    - hover
      - color 설정으로 hover시에 색깔 바꿀수 있음
      - text-decoration:none 을 통해 언더라인도 제거 가능
    - active
    - link
    - visited
  - 구분자 넣기
---
# git branch
  - 언제 사용하나?
    - 한명 이상이 master를 다루는 경우
    - 시범적인 기능을 구현하고 싶을때
    - master를 건들이면 안되는 경우
  - $ git branch -c master var2
    - 새로운 var2 브랜치 생성(master브랜치를 복사해서 만듬)
  - $ git checkout -b dev2
    - 새로운 브랜치 생성하면서 이동
  - $ git checkout var2
    - var2 브랜치로 이동
  - $ git branch -d var2
    - var2 브랜치 삭제
  - $ git log --graph --oneline --all
    - 모든 브랜치의 로그 확인 가능
