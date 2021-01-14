오늘은 spring boot 상세페이지 작성을 학습하였습니다.

> ## Today I Learned
  - detail page


### detail 페이지 controller
  - 상세 페이지에 사용할 모델 저장하기
    - get()
      - 상세 페이지에 표현할 아이템
    - getPrev()
      - 이전글 정보
    - getNext()
      - 다음글 정보
  ![](https://images.velog.io/images/junjun-creator/post/d8eeb14c-f41c-4ab3-817d-a27cf3616950/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%203.27.14.png)
  
  - 쿼리문 작성(mapper)
    - get, getPrev, getNext
      - getPrev : 이전글. 즉, 현재 날짜보다 이전에 적혀진 글 중에서 최 상단에 있는 글을 뽑으면 됨
      - getNext : 다음글. 즉, 현재 날짜보다 다음에 적혀진 글 중에서 최 하단에 있는 글을 뽑으면 됨
        - 최하단의 글을 뽑는 방법 : 정렬을 뒤집어서 최상단을 뽑으면 됨
        
  ![](https://images.velog.io/images/junjun-creator/post/83717fb3-1381-473a-accd-e87e225f5e93/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%203.29.21.png)
  

