# 목록형 콘텐츠 꾸미기
  - a태그에 글자를 이미지(로고)로 대체할때
    - background:url() 설정 후
    - text-indent로 글자 들여쓰기 하기
    - text-indent는 block의 컨텐츠에 적용할 수 있음(인라인 컨텐츠에는 불가)
      - overflow:hidden 설정해주기
    - 너비 높이를 주는데, 인라인 태그는 너비 높이를 줄 수 없음.
    - block태그로 바꾸는데, 한 층을 다 쓰는 block이 아닌 inline-block으로 설정해줘야 함
    - 주의사항
      - 글자를 옮겨놨을 뿐, 기존 li의 높이는 글자의 크기에 맞춰져 있다. 이를 잘 해결해야한다.
      - ul에 폰트 사이즈를 0으로 하면 된다!
  - block이 컨텐츠를 감싸는 크기로 설정할때
    - inline-block을 사용하자~!
    - 높이를 어떤태그가 갖고 있는지 확인하기
      - inline-block은 자체적으로 높이를 갖지 못함.(컨텐츠의 높이가 높이가 됨)
---
# git 브랜치
  - 최대한 master는 건들이지 않는다.
  - 원본은 그대로 두고, 수정하고싶은것이 있을때 브랜치 생성
# checkout, switch
  - checkout : 버전을 옮겨다님
    - checkout을 통해서 과거로 갓다가 다시 돌아올 수도 있음
    - git checkout master(브랜치 이름)을 하게되면 헤드로 돌아옴
  - switch : 브랜치를 옮겨다님
# 하나의 파일만 과거 버전으로 돌리는 법
  - $ git checkout d12b8eb a.txt
    - a.txt파일만 과거 버전으로 돌림. 변경 후에는 해당 파일만 modify 된 것으로 나옴.
    - 이 상태에서 commit 하면 새로운 버전이 됨.
# fast-forward merge
  - 원본 영역은 변화가 없음.
  - 다른 브랜치에서 변화를 적용함
  
---
#Dynamic Web Project
  - 톰캣 버전 설정 후 프로젝트 생성
    - 톰캣 실행
    - 홈 디렉토리 설정
    - url 요청
    - >> but 자바가 다 알아서 해줌...
  - 과거에는 서버 프로그램에 따라 클라이언트 프로그램을 바꿔야 했음
  - 현재는 서버에서 정보를 껍데기(문서)에 담아서 클라이언트에 제공, 클라이언트 프로그램 없이 브라우저로 읽어들임
  
# 웹서버,WAS
  - 사용자로부터 요청 받음(웹서버)
  - 문서를 만드는 코드 > 실행파일 만들어짐(.class) > url 요청에 mapping(WAS)
# Servlet
  - 서버 어플리케이션을 기능별로 나누어(let) 만듬
  - 기능 단위로 main이 따로 있음(service) >> 실제 main은 톰캣이 가지고 있음 거기에 기능을 꽂아 주는거임
  - 사용자로부터 요청을 받아들이는 httprequest, 사용자에게 응답을 보내는 httpresponse
# 흐름
  - 톰캣에 url 매핑 정보를 저장해야함
  - 실행환경은 tomcat임. tomcat에 기능(.class)들을 꽂아넣음. url에 맞춰서 switch 됨(mapping > HttpServlet 객체 생성 > .service(request,response) 호출).
  - 사용자로부터 요청 받음(웹 서버) > 웹 서버에서 WAS에 요청 > WAS는 가지고있는 url mapping 정보를 가지고 실행파일(.class)을 찾아서 실행해줌 > 결과를 웹 서버에 전달 > 사용자에게 제공
# WEB-INF
  - 설정파일과 실행파일을 넣어주는 폴더
  - 실행파일은 classes 폴더에 넣어줘야함(패키지명이 있다면, 패키지명 대로 디렉토리 만들어야함) >> 배포
# url-mapping
  - 톰캣이 실행될때 web.xml 파일 읽음
  - web.xml에 매핑정보 저장
  - 실행시 읽어서 컨테이너에 저장(사실 안씀 나중에 annotation으로 설정할것임)
  - servlet-name 이름 설정
  - servlet-class 실행할 실행파일 이름 설정
  - servlet-mapping > url-pattern 매핑 설정
