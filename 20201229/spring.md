오늘은 spring framework 두번째 시간입니다!

> ## Today I Learned
  - spring-boot-devtools 의존성 추가
  - View Page Home directory 설정
  - JSP 파일 인식을 위한 라이브러리 추가
  - Controller에서 Forwarding
  - 사용자에게 직접 JSP가 요청되지 않으려면?
  - View의 directory 변경으로 인한 매핑 문제 해결

### spring-boot-devtools 의존성 추가
  - spring boot에서 수정사항이 생겼을 경우, 매번 새로 실행해줘야하는 불편함이 있었다.
  - 이를 자동으로 해주기 위한 라이브러리를 추가해줄 필요가 있다.
  
![](https://images.velog.io/images/junjun-creator/post/dd67198e-0947-4689-b086-b4d17ffdf088/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%203.22.06.png)

### View Page Home directory 설정
  - jsp 파일과 같은 View page 관리를 위해 Home 디렉토리를 설정해준다.
  - src/main/webapp/ 가 home 디렉토리가 된다.
  
![](https://images.velog.io/images/junjun-creator/post/c312f0b7-6a8a-4478-ad6a-bbc7f781ad96/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%203.39.29.png)

### JSP 파일 인식을 위한 라이브러리 추가
  - 라이브러리 추가 없이 spring boot에서 JSP를 요청할 경우, spring boot는 알수 없는 파일이라 생각하고, 클라이언트에게 해당 파일을 다운받게 한다.
  - JSP를 인식하게 하기 위해 라이브러리를 추가한다.
  
![](https://images.velog.io/images/junjun-creator/post/59022c5d-5a0c-49f8-86e1-97e7bceb5af4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%203.46.30.png)

### Controller에서 Forwarding
  - spring boot에서는 포워딩이 아주 쉬워졌다.
  - 서블릿에서는 forwarding을 위한 dispatcherServlet을 호출해야 했다면, spring boot에서는 controller 애노테이션을 통해 간략화 한다.
  - 이때 forwarding하는 view page의 디렉토리는 url매핑 디렉토리와 같아야한다.
![](https://images.velog.io/images/junjun-creator/post/c2496bd1-2ddd-41cc-9fe3-4799b6dc4216/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%203.55.10.png)

### 사용자에게 직접 JSP가 요청되지 않으려면?
  - JSP의 홈 디렉토리를 단순히 설정하고 사용 할 시, 클라이언트가 controller를 거치지 않고, 바로 jsp에 접근 할 수 있다는 문제점이 있다.
  - 이는 아주 큰 문제이며 반드시 해결해야할 문제이다.
  - Home/WEB-INF/view/ 디렉토리를 사용하여 클라이언트가 직접적으로 jsp에 접근하는 것을 막는다.
  
![](https://images.velog.io/images/junjun-creator/post/dcaf58d2-c36b-4f87-9b19-45d1e8c15abb/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%204.07.03.png)

### View의 directory 변경으로 인한 매핑 문제 해결
  - 위에서 WEB-INF/view/ 디렉토리를 활용하여 사용자 접근 문제를 해결하였다.
  - 하지만 view의 directory가 변경되므로써 forwarding을 위한 경로도 수정을 해줘야한다.
  
![](https://images.velog.io/images/junjun-creator/post/b7f90ccc-5fd3-4644-a7f7-7874e09974df/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%204.10.41.png)

  - 하지만 이렇게 되면 매번 매핑시마다 /WEB-INF/view/ , .jsp는 반복이 되는 불필요한 작업이 생긴다.
  - 이를 해결하기 위해 application.properties를 활용해본다.
  - 이는, Spring MVC를 할때, dispatcherServlet에서 view resolver의 prefix와 surfix를 설정하던 것과 같다.
  
![](https://images.velog.io/images/junjun-creator/post/7952a98e-63ff-4a4e-a38f-2d53c27c8a53/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-29%20%EC%98%A4%ED%9B%84%204.17.36.png)
