오늘은 웹 프론트 개발에 있어서 다양한 framework들을 살펴보았습니다.

> ## Today I Learned
  - Front-end Framework 필요성
  - MVC <> FLUX
  - Vue
  - React

### Front-end Framework 필요성
  - promise를 활용한 Ajax 통신
    - 결과로 promise 객체를 반환함. => then()을 활용하여 데이터 조작 가능
   ![](https://images.velog.io/images/junjun-creator/post/61173e85-406f-4435-b6ee-fc4c2c713d5e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%EC%A0%84%2010.18.56.png)
  - json 데이터 뽑아내기
  ![](https://images.velog.io/images/junjun-creator/post/35104753-6307-4017-8641-f419395f7c2f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%EC%A0%84%2010.21.47.png)
  
  - Ajax를 통한 페이지 전환
  ![](https://images.velog.io/images/junjun-creator/post/862db31f-0a5e-47aa-a8d6-8986aeddc842/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%EC%A0%84%2010.53.48.png)
  
  - 중복이 너무 많다... 해결할 방법은?
    - AngularJS(MISKO)
    - ajax를 통해 가져온 데이터를 DOM 조작할 때 많은 코드라인이 중복이 됨. 이를 해결하기위해 등장
    - MVW(Whatever) 라고 불리움
    - 노드를 조작하는 코드를 제거할 수 있다.
  - 프론트 영역에서 MVC 패턴으로 구현하자!
  
### MVC <> FLUX
  - mvc : 양방향
    - 개발자는 모델까지만 신경쓰고 작업하면 됨.
    - 사용자가 view에 변화를 주면 그 view의 변화가 model의 변화를 가져오고, controller는 model의 변화를 인지할 수 있다.
    - angular,vue
  - flux : 단방향
    - action -> dispatcher -> store -> view
    - view의 변화가 stort을 직접 변경시키지 않음
    - view의 변화는 새로운 action을 낳음(throw)
    - store의 저장소가 다 소진되면 다음 store가 진행되는 방식으로 충돌이 생기지 않음.
    - react
    
### Vue
  - mvc 패턴 구현
  - DOM 조작을 직접 할 필요 없음.
  ![](https://images.velog.io/images/junjun-creator/post/d374be7b-4443-458a-a029-e0ff22b5f5e6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%203.23.31.png)
  
### React
  - Flux
  - Virtual DOM : render
  ![](https://images.velog.io/images/junjun-creator/post/08d674ce-d492-484b-b947-c875a8becf88/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%204.07.11.png)
  
   - render로 삽입할때, html 태그 사용하기
     - babelJS 사용
 ![](https://images.velog.io/images/junjun-creator/post/1faf38e7-1d8b-4dbc-8914-2d3a77b60c92/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%204.17.06.png)
