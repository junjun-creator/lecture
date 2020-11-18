# 라벨을 수직 가운데 정렬하는법
  - 라벨을 박스로 만들어서 세로정렬(flex)
  - 라벨에 높이를 주고 텍스트를 가운데 정렬하는법(line-height > 한줄일때만 가능)
# position : absolute
  - 자동조절되는 위치
  - 최초 기준점은 문서의 좌상단(0,0)
# position : relative
  - 상대적인 기준점을 잡아줌
# css 추상화
  - 집중화 하기 위해서 추상클래스 이름이 필요
  - 추상화된 css는 앞에 작성하고, 특화된 아이템들은 뒤에 오버라이딩 하는 방식으로 사용
---
# checkout
  - checkout -b branch >> 브랜치 생성
  - git checkout HEAD~2 >> 두단계 앞으로 버전 이동
  - git checkout <commit id>
  - $ git branch -m temp master
    - 브랜치 이름 변경
---
# servlet 웹 출력
  - printStream >> outputStream을 이용하여 문자열 단위로 출력하게 하는것
  - 다국어 지원을 위해 PrintWriter가 나옴
    - PrintWriter out = response.getWriter();  
		System.out.println("hohoho");  
		out.println("hahahahaha");  
# eclipse 배포경로
  - package explore은 working tree일 뿐이고 
  - 실행하면 배포경로로 배포 됨
# jdbc를 위한 db 라이브러리
  - WEB-INF/lib 에 추가해준다(classpath 등록)
  - 실행을 다른곳에서 하더라도 library를 배포가능하게 등록해둠
