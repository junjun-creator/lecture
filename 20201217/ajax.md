# 번외
  - 오라클에서 시퀀스를 활용하여 id값을 증가시키며 저장할때, 마지막 id값에서 +1된 위치에 첨부파일을 저장하였었다.
  - 근데 중간에 데이터가 삭제 되면, 실제 id값과, 첨부파일이 담겨있는 디렉토리의 id값이 달라진다.
  - 그걸 일치 시켜주기 위해 returning을 사용하여 insert했을 당시의 id값을 받아올 수 있다.(oracle만 가능)
  ```@Override
   public int insert(Notice notice) {
      int result = 0;
               
      
      String url = DBContext.URL;
      String sql = "INSERT INTO NOTICE(TITLE, CONTENT, WRITER_ID) VALUES(?,?,?) RETURNING ID INTO ?"; 
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
         OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
         st.setString(1, notice.getTitle());
         st.setString(2, notice.getContent());         
         st.setString(3, notice.getWriterId());         
         st.registerReturnParameter(4, Types.INTEGER);
         
         st.execute();
         ResultSet rs = st.getReturnResultSet();
         rs.next();
         result = rs.getInt(1);
         System.out.println("result : " + result);
         st.close();
         con.close();         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;
   }
   ```
   
### 페이지 요청하기
  - 동기형 요청
```
function showDialog(url){
    var request = new [window.]XMLHttpRequest();
    //var request = new ActiveXObjext("Microsoft.XMLHTTP");
    request.open("GET",url,false);
    request.send(null);
    
    alert(request.responseText);
}
```
  - XMLHttpRequest : window객체가 갖고있는 통신을 위한 메소드
    - XML에서 Http로 Request(요청)를 하여 정보를 가져올 수 있도록 하는 기능
  - cross origin : 외부 서버에 접근하는걸 차단함. 헤더에 cross origin을 허가하는 정보가 있다면 가능.(허가는 제공자가 해주는것)
    - local <-> local (O)
    - local <-> naver (X)
  - xhr.open("GET","/data.txt",false);
    - get방식으로 data.txt경로에 요청한다.
    - false : 동기, true : 비동기
- 비동기형 요청
  - 요청을 하고, 다른일을 하다가 요청이 완료되었을때 그 일을 수행하게끔 함.
  - 그 일을 수행하게끔 위임 된 함수를 콜백(callback)함수라고 함.
  - xhr.onreadystatechange : xhr의 readyState의 상태가 변화할때 실행함
    - xhr.readyState
      - 0 : unsent
      - 1 : opened
      - 2 : headers received
      - 3 : loading
      - 4 : done
