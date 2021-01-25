오늘은 Tiles Preparer, AuthenticationSuccessHandler에 대해서 학습하였습니다.

> ## Today I Learned
  - Tiles Preparer
  - AuthenticationSuccessHandler

### Tiles Preparer
  - 레이아웃의 공통된 부분을 준비하는데 사용
  - main영역은 컨트롤러를 통해 데이터를 가져오지만, header, aside등과같은 영역은 컨트롤러가 없다.
  - 이런 영역에서 필요한 데이터가 있다면?
    - Preparer를 활용
  ![](https://images.velog.io/images/junjun-creator/post/ed9b0ccc-4db8-411f-96fc-e3aeeba4756f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%203.46.43.png)![](https://images.velog.io/images/junjun-creator/post/fbc7adee-5182-4458-93cc-063d2c3a85a3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%203.47.02.png)![](https://images.velog.io/images/junjun-creator/post/fe2bfc45-9342-435a-ba3b-f28ad00e4f08/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%203.47.25.png)
  
### 사용자 정보를 사용하는 방법은?
  - 세션활용
  - 하지만, 기존과 달리 로그인 처리를 우리가 직접 하는 것이 아니라 spring security에서 제공하는 기능을 사용한다
  - spring security에 session정보를 넣는 방법이 필요
    - WebSecurityConfigurer에서 successHandler 활용
      - AuthenticationSuccessHandler
      ![](https://images.velog.io/images/junjun-creator/post/4bd49201-f99b-44c1-9887-2644b59efe4c/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%204.45.22.png)![](https://images.velog.io/images/junjun-creator/post/94c8c7d0-dfac-42c6-9e89-99cc0eb9280b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-25%20%EC%98%A4%ED%9B%84%204.47.46.png)
    
  - 주의사항
    - successHandler를 통해 로그인시 세션정보 등록을 완료하고, 원래 이동해야할 페이지로 forwarding을 꼭 해줘야 한다.
    
