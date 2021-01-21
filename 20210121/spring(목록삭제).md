### detail 페이지에서 목록 삭제
  - view 페이지 delete 버튼과 컨트롤러 매핑
    - 주의사항
      - 삭제버튼 클릭시 바로 삭제요청이 되는것이 아니라 확인창이 뜨게끔 만들어줘야함(script로 구현)
  ![](https://images.velog.io/images/junjun-creator/post/23fde018-448d-47ef-9c98-449c3b65cac0/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%205.52.34.png)![](https://images.velog.io/images/junjun-creator/post/b61f2e65-4197-4131-a3fe-520c18f666e9/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%205.52.50.png)![](https://images.velog.io/images/junjun-creator/post/7545433d-86ee-4de6-8f8e-4d5b6ec683ef/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%205.52.57.png)
  
  - 서비스, DAO 구현 및 MyBatisMapper 작성
  ![](https://images.velog.io/images/junjun-creator/post/7df6b227-98cf-430c-872d-47a34d6cd630/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%205.54.13.png)
  
### 목록 페이지에서 일괄 삭제
  - 일괄삭제, 일괄공개 버튼 구별하기
    - submit 버튼에 name값을 주고, value를 서버로 전달시켜서 사용
  ![](https://images.velog.io/images/junjun-creator/post/12782424-5f01-4e92-b96c-34d4f015d24b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%206.02.57.png)
  
  - 체크박스에 value값을 줘서 삭제하고자 하는 아이템의 id값을 전달
  ![](https://images.velog.io/images/junjun-creator/post/aaeffb94-baec-4176-b3f5-4dbde72474ca/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%206.04.21.png)
  
  - controller, service, dao 구현
  ![](https://images.velog.io/images/junjun-creator/post/7471d0ff-a058-4850-a9f9-b4b35fa5cc32/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%206.39.07.png)![](https://images.velog.io/images/junjun-creator/post/3822f139-33fb-485b-bee9-3b22df7565ca/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%206.39.55.png)
  
  - dao 구현을 위한 MyBatisMapper구현
    - 쿼리의 where 절에 사용할 값으로 배열을 받고있음
      - mybatis가 제공하는 foreach 문을 활용
      - where id in (1,2,3,4,5)와 같은 형태로 만듬
  ![](https://images.velog.io/images/junjun-creator/post/79771d07-085d-4a37-b799-31e2381e6138/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%ED%9B%84%206.40.08.png)
