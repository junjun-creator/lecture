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
   
   # 
