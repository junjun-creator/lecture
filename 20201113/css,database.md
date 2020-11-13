# flex 방향설정
  - container에 방향을 설정한다. flex-direction  
  - 메인축, 수직축으로 방향 구분
  
# flex 래핑 설정
  - flex item이 넘칠경우, 페이지에 가려지는 것이 아니라, 아래로 내려가게 만들면 된다.
  - flex-wrap : nowrap | wrap | wrap-reverse
  - nowrap의 중요성
    - *아이템 슬라이딩* 기능 구현을 할때는 wrap기능 사용하면 안됨.
  - wrap-reverse를 통해서 역순으로 정렬 가능
  - 마지막 아이템이 남은공간을 모두 차지하는 경우가 생김
    - grow를 0으로 설정함
  - flex: 1;
    - grow:1, shrink:1, basis:0% 가 됨
    
# 순서정하기
  - 아이템에 order 속성을 줌으로써 순서를 지정할 수 있음
  - order의 기본값은 0 이다.
  - -1값을 갖게되면 우선순위가 가장 높아진다.
  
# flex
  - 기본값 0 1 auto
  - 아이템 설정
  
# Flex-Lines(flex-flow)
  - direction과 wrap 두가지의 속성을 한번에 표현할 수 있다.
  - 기본값 row nowrap
  - 컨테이너 설정

# Flex Aligning
  - 컨테이너 설정
  - Main Axix(justify-content) / Cross Axis(align-items)
  - direction이 row 일때, height값은 100%인데 이럴땐 align-items는 의미가 없다. 그럼 왜 있나?? >> height값이 변할수도 있다는 얘기다.
  - justify-content
    - flex-start
    - flex-end
    - space-between
      - 아이템들 사이에 여백을 나누어서 넣음(아이템이 5개일때 여백을 4개로 나누어서 사이사이에 넣어줌)
    - space-around
      - 아이템마다 양쪽으로 여백을 나누어서 넣음(아이템이 5개 일때 여백을 10개로 나누어 아이템 마다의 양쪽에 넣어줌)
    - space-evenly
      - 컨테이너의 양쪽 끝과 아이템 사이의 여백이 모두 균일하게 나누어서 들어감
  - 컨테이너 높이와 아이템 높이의 관계
    - 컨테이너에만 높이값을 설정하면, 아이템의 높이가 자동으로 컨테이너의 높이가 된다. >> align-items:stretch가 default 이다.

---
# GIT
  - touch 파일명
    - 빈 파일 만들기
  - tracking 예외목록 만들기
    - .gitignore 파일
    - tracking 예외목록을 저장하면 버전관리 목록에 넣지 않음
  - 다시 돌아올 수 없는 복구 : reset
    - 다음시간에~~~~ (commit 해놓고 log에서 버전을 확인하고 넘어가야함)
    
---
# JDBC(Java DataBase Connectivity)
  - 자바 프로그램에서 DB에 연결하기 위한 것.
  - 자바가 제공하는 API
  - DB의 종류에 따라 driver만 변경해주면 모든 DB 사용 가능(드라이버는 각 DB가 제공함)
  - driver는 DB에서 제공하므로 받아와서 사용해야함.(다운로드)
  
# JDBC 사용방법
  - 1. 드라이버로드
  - 2. 연결 생성
  - 3. 문장 실행
  - 4. 결과집합 사용
  - 5. rs.next();
  - 6. rs.getString("title");
  - 사용예시
    - String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String id = "NEWLEC";
		String pwd = "11111";
		String sql = "SELECT * FROM MEMBER";
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버가 2개 이상인경우 드라이버 설정을 안하면 에러가 남. 하나일경우라도 드라이버 개체생성을 해두자~
			Connection con = DriverManager.getConnection(url,id,pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			String[] nicname = new String[2];
			if(rs.next()) {
				nicname[0] = rs.getString("NICNAME");
			}
			if(rs.next()) {
				nicname[1] = rs.getString("NICNAME");
			}
			
			rs.close();
			st.close();
			con.close();
			
			System.out.printf("nicname : %s\n",nicname[0]);
			System.out.printf("nicname : %s",nicname[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}  
    
