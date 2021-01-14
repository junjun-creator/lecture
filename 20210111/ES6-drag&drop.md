오늘은 ES6 Drag&Drop 시간입니다

> ## Today I Learned
  - Drag and Drop
  - Upload를 위한 Drag Drop 박스
  
### Drag and Drop

![](https://images.velog.io/images/junjun-creator/post/6ae09106-00e3-42c9-9fd2-a89d19e738ea/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.53.31.png)

  - 드래그 드랍을 위한 박스 2개 만들고, 마우스가 큰 박스 안에서 움직일때 작은박스가 커서와 함께 움직이도록 이벤트 달아주기
  
 ![](https://images.velog.io/images/junjun-creator/post/86e5a022-86c1-4dc2-b43e-f7fe7b21f564/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.54.00.png)
 
  - 클릭시에만 작은 상자가 커서를 따라다니도록 설정
  
 ![](https://images.velog.io/images/junjun-creator/post/de16bf53-da04-42ff-a3b5-83fa58a008ae/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2010.55.06.png)
 
  - 상자에서 클릭한 위치 유지한채 드래그 하게 설정하기
    - offset활용(이벤트 객체)
    
 ![](https://images.velog.io/images/junjun-creator/post/625c0fa0-dd00-435b-a6f7-2d958964434b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-11%20%EC%98%A4%EC%A0%84%2011.27.46.png)
 
  - 스크롤바 내릴 시, 스크롤바 만큼 위치가 달라지는 문제 해결 방법
    - 큰 컨테이너 안에서 상대위치 사용하기
    - 천테이너의 offset 위치를 얻어서 box위치를 추가 보정하는 방법
    - 첫번째 방식으로 해결해보자.
    
   ![](https://images.velog.io/images/junjun-creator/post/d369aad2-b86e-41b6-9b5b-12c3da9f0762/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2010.34.27.png)
   
  - 컨테이너가 2개 이상일 때 박스 선택에 따른 드래그 설정
  
 ![](https://images.velog.io/images/junjun-creator/post/f91b1c0e-a7d0-4311-aa8b-85b7c3b8a792/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2010.35.31.png)
 
### 재사용가능한 캡슐화

![](https://images.velog.io/images/junjun-creator/post/a2106459-e225-47c2-83b1-e64de309b049/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.11.01.png)![](https://images.velog.io/images/junjun-creator/post/eeff12a5-bc9c-4b99-b90a-178adbe67a78/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.11.10.png)

  - 주의사항
    - 외부에서 내부 this값을 사용하려 할때는 this를 전달해줘야함.
    - 현재 예시에서는 mouseHandler()가 호출될때 this가 무엇인지를 모름. 그래서 그걸 알려줘야함
      - bind(this)
      
   ![](https://images.velog.io/images/junjun-creator/post/2b9e3582-5227-49fe-b369-414ce2c1c53b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-12%20%EC%98%A4%EC%A0%84%2011.31.18.png)
  
### Upload를 위한 Drag Drop 박스
  - HTML 드래그 앤 드롭 API
  - 사용자로부터 입력을 받기 위한 행위이다.
  
 ![](https://images.velog.io/images/junjun-creator/post/9aebc409-9bc7-402e-8126-15bf7bebd458/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2011.31.25.png)![](https://images.velog.io/images/junjun-creator/post/4bfff3cb-038a-44c4-b2a6-ff5fa5260f51/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%EC%A0%84%2011.34.05.png)
 
  - 드래그 해오는 파일의 정보
    - e.dataTransfer
    - 이 정보를 통해 드래그 파일이 적합한지 유무 검사 가능
    
   ![](https://images.velog.io/images/junjun-creator/post/e8388c3a-00df-44ab-9b0d-e95a4d633b82/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%ED%9B%84%2012.04.30.png)
   
  - 파일 전송을 위한 ajax
    - form태그에서 사용하던 multipart로 파일 전송하기
      - 직접적으로 form태그를 사용하는것이아니기 때문에 api사용
        - FormData API
     ![](https://images.velog.io/images/junjun-creator/post/1f44ef43-5277-4231-8435-cc54f05adb41/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%ED%9B%84%2012.35.39.png)
     
    - 서버단에서 전송한 formData 처리하기
      - MultipartFile객체를 통해 FormData로 전송한 파일들을 읽어오기
     ![](https://images.velog.io/images/junjun-creator/post/97331e98-0c71-461e-9bd6-9bed684687af/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-13%20%EC%98%A4%ED%9B%84%2012.36.55.png)
     
    - 전송 진척도 출력하는 코드 작성하기
      - request.upload.addEventListener("progress")
     ![](https://images.velog.io/images/junjun-creator/post/52af4fbd-936a-4479-ab2c-d33ae49a9d9a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%EC%A0%84%2010.12.10.png)
    - 전송파일 최대 크기 설정방법
      - 개별 최대 크기, 전체 최대 크기 설정
      - resources/application.properties
     ![](https://images.velog.io/images/junjun-creator/post/cf7b43e6-4e2d-4b0c-a40d-a7d1283e48a6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%EC%A0%84%2010.18.08.png)
     
    - 전송정보 출력하기
      - status
     ![](https://images.velog.io/images/junjun-creator/post/519cc352-e357-4f2b-8621-7a24ae225fbf/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%EC%A0%84%2010.15.10.png)
     
    - 서버로 전송된 파일 저장
      - 파일 전송 경로 설정
      - 전송 경로의 realPath 설정
      - 해당 경로의 존재 유무 파악
        - 존재하지 않을 시 생성
      - 업로드 될 파일위치 설정
      - 업로드 될 파일 위치 설정 후 해당 경로로 File객체 생성
      - 클라이언트로부터 전송된 파일을 uploadedFile로 저장
     ![](https://images.velog.io/images/junjun-creator/post/4750a8a5-d6aa-4ac3-823b-2897ef7a1130/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%EC%A0%84%2011.07.57.png)
