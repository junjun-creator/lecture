# border-radius
  - 박스의 꼭지점을 round형으로 반지름을 설정함.
# rotate
  - 회전 애니메이션
# transition
  - .container:hover .box : 애니메이션 대상을 감싸고 있는 상자에 hover를 적용한다.
    - 2개 이상의 대상에 애니메이션을 적용할 수 있다.
  - transition: name duration timing-function delay;
    - delay
      - transition에 걸리는 시간을 지연시킴.
    - timing-function(easing-function)
      - 기본값 : ease
      - 계단식 transition
        - steps(단계횟수,변화시작점) : start>바로 변화시작, end> start 반대
  - 애니메이션을 완료하는데 걸리는 시간을 설정해줄수 있음(전환 과정이 매끄러운 애니메이션)
  - all 대신에 변화시키고 싶은 특정 속성을 지정할 수 있음.
  - transform-origin: right top;
    - transform의 기준점을 설정해줌
# translate
  - position 설정 없이 현재 위치를 기준으로 이동시킬 수 있음
# (번외) absolute position
  - 조상 태그에 relative가 없다면, offset이 자동으로 현재 위치해야할 곳으로 설정이 됨.
  - offset이 자동으로 설정되기 때문에 마치 기준점이 body가 아닌것처럼 느껴짐. 하지만 기준점은 body임
---
# JDBC point
  - 드라이버
  - 연결
  - 실행객체 생성
  - 결과 집합 사용
# 웹 서버와 WAS
  - 사용자로부터(client) url 요청을 웹 서버가 받음
  - 정적인 문서(html,css 등)는 웹서버에서 사용자에게 제공 가능.
  - 하지만, 실행파일(.class 등)들은 제공하는 것이 아니라 이것을 실행해서 결과를 제공해줘야함.
  - 이런 실행파일들을 실행할 수 있는 환경이 WAS 이다.
  - 모든 실행파일(.class)들은 Server Application 이다. >> 각각의 .class들은 servlet(Server Application let[조각])이다.
  - 각 servlet에서 모든 html 태그를 사용하기엔 좋은 방법이 아니다 >> 다른 방법을 배울것이다.
# 웹에서의 argument
  - /주소?x=10&y=20
  - request.getParameter("x");를 통해 argument로 전달된 값을 가져옴.
# Servlet 흐름(life cycle)
  - 사용자가 브라우저를 통해 요청을 보냄 > 웹 서버가 요청을 받음 > 웹서버의 설정에 따라서 확장자에 따라서 실행파일인지 정적 파일인지 구분하여 수행  
  > 실행파일일 경우 WAS에서 매핑정보를 통해 서블릿을로드함 > 로드 됬는지 확인(메모리에 있는지) > 있다면 실행, 없다면 메모리에 올리고 실행
  - 실행파일 객체 생성 후 가장 먼저 실행되는게 초기화를 위한 init()  
  > 스레드로 service() 실행 > 실행이 끝낫다고 생성한 객체를 바로 없애지는 않음.(Timeout을 두고 다시 사용이 안될경우 메모리에서 destroy)
  - override 가능한 메소드 3가지
    - init(); 초기화에 필요한것들
    - service(); 실행에 필요한 것들
    - destroy(); 마무리 정리할때 필요한 것들
# 입력과 출력
  - Get 요청을 받아서 servlet을 실행하면서 인자를 전달 (/hello?c=3 >> QueryString 이라고 한다.)
  - 서버로부터 입력지를 받아서 적은다음에 제출하는 Post 요청(추가적인 요청을 할때)
