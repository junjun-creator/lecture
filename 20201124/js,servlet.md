# Object
  - java의 콜렉션과 같음
  - var exam = new Object();  >> {} 로 json 형식으로 표현 가능
  exam.kor = 30; //kor이 key, 30이 값 >> expand object 이기 때문에 큰 문제가 있음 >> 대소문자, 철자 오류 등 실수로 인한 문제가 발생함
  - 값을 설정하는 방법 2가지
    - notice.id = 1;
      - 키를 알고 잇을 때
    - notice["writer id"] = "newlec";
      - 변수를 이용해서 값을 꺼내고자 할 때
      - ex) var keys = new Array("id","title","writer id");  
        for(var i=0;i<3;i++){  
            console.log(notice[keys[i]]);  
        }
# JSON
  - var notice = {id:1, title:"JS란 무엇인가?"}; 로 Object 객체 생성 가능. 빈공백과 같이 특수한 경우가 아니라면 큰따옴표 사용하지 않아도 됨
  - 활용
    - eval() : 값을 실행(execute value)
      - var code = "var x = 30;";  
        eval(code);  
        console.log(x);
      - var json = '{"kor":30, "eng":40, "math":60}';  
        var exam = JSON.parse(json);  
        // eval("var exam = "+json+";");  
        console.log(exam.math);
      - eval은 두가지 문제점이 있어서 잘 사용하지 않음
        - 보안상 문제
        - 다른 함수로 같은 기능을 구현할 수 있음
    - parse, stringify
      - parse : 문자열 형태의 json data를 파싱해줌(데이터화)
      - stringify : 객체 형태의 데이터를 서버단에 전송하고자 할때 문자열 형태로 전환해줌(문자열화)
# 연산자
  - 비교연산자
    - 자바에서는 문자열을 비교할때 == 로 비교하지 않았다. 이는 참조를 비교하는 연산자이기 때문에 문자열의 경우 값을 비교하는 equal() 메소드를 사용하였다.
    - 자바스크립트도 마찬가지인데 == 는 값을 비교하고, === 는 참조를 비교한다.
  - for-in
    - for(var i in arr) : i에 키(또는 인덱스)값을 하나씩 꺼내옴
  - for-of
    - for(var v of arr) : v에 값을 하나씩 꺼내옴(자바의 foreach와 같음)
# 함수
  - var add = new Function("x,y","return x+y;"); >> 함수가 객체임(객체생성)
  - "x,y" 라는 인자를 갖고, "return x+y;"라는 return 값을 갖는 함수 객체를 생성
  - var add = function (x,y){  >> 같은 개념(위의 방식은 익숙하지 않으므로 일반적으로 알고 있는 방법으로 만드는 방식. 하지만 객체이므로 변수로 저장할 수 있음.)
            return x+y;  
        }
  - function add(x,y){  
            return x+y;  
        }
  - 위의 3가지 방법 모두 함수를 선언하는 방법임 모두 가능함.
  - 포인트는 함수가 객체이다~!!
  - 여기서 호출할때 인자로 2개 이상 또는 이하로 입력해도 오류가 나지 않는다.
    - 이유는 여기서 x ,y라는 매개변수는 x = arguments[0];, y = arguments[1];이다.
    - 모든 전달되는 인자는 arguments라는 콜렉션에 저장되고 x,y라는 별칭으로 사용 될 뿐이기 때문에 에러가 나지 않는다.
# 변수
  - 자바스크립트의 모든 변수는 window 객체의 속성으로 들어간다.
  - var 변수는 호이스팅되어 스크립트의 맨 위로 올라가게 된다. 즉, var 변수는 undefined라는 값으로 선언된 것과 같다.
  - 하지만 전역변수는 호이스팅 되지 않기 때문에 호출보다 값을 넣어주는 위치가 뒤에 있다면 not defined 에러가 난다.
  - 이는 함수에서도 마찬가지의 개념을 보인다.(함수표현식과 함수 선언식의 차이)
# 실행흐름
  - javascript parser는 먼저 var와 function, class를 찾아서 우선 실행을 한다.
  - var add2 = function (x,y){  
            return x+y;  
        } >> 이 경우에는 var add2;와 function~~ 부분이 먼저 실행되는데, add2 = function~~ 의 대입 과정이 뒤에 수행된다.
---
# 입출력 문자셋 설정하기(한글깨짐 방지)
  - 입력(클라이언트에서 서버로 입력)
    - request.setCharacterEncoding("UTF-8");
  - 출력(서버에서 클라이언트로 출력) : 한글은 2바이트단위, but 기본 설정이 1바이트 단위로 읽어들임 그래서 ?? 로 나옴
    - 브라우저에서 요청을 보내는 헤더에 본인이 읽을수 있는 content type과 charset의 정보를 보냄.
    - 하지만 서버에서 오는 응답이 그 형식이 아니라면 깨질 수 밖에 없음. 그래서 response 헤더에 해당 정보를 포함시켜서 전송해야함.
    - response.setCharacterEncoding("UTF-8"); // 2바이트 단위로 읽게끔 설정. 하지만 여전히 꽣뚫 이런식으로 깨진문자가 나옴. 브라우저가 읽을 수 있는 컨텐츠 타입과 charset을 설정해야함
    - response.setContentType("text/html; charset=UTF-8"); // 브라우저가 읽을 수 있게끔 세팅을 해줌.
# 서블릿 필터
  - 서블릿이 한두개도 아니고 여러개의 모든 서블릿에 입출력 문자셋 설정을 일일이 하기에는 너무나 비효율적이다.
  - 그래서 사용하는 것이 필터이다.
  - 서블릿 전(또는 후)에 로직을 담고있는 그릇 = filter
  - 1번방식(web.xml 설정)
  - 2번방식
# 필터 수행 루트
  - System.out.println("before 필터실행");  
		chain.doFilter(request, response);  
		  - 요청에 따른 조건으로 실행할지 말지 결정도 가능하다.  
		System.out.println("after 필터실행");
  - 그렇다면 그냥 서버만 실행했을때에도 두개의 출력문이 나오는 이유는??
# 유의사항
  - //이것도 고착화된것과 다름 없다. jar파일을 통한 재사용성을 높이기 위해서는 이것을 변수화해서 변경하여 사용 가능하도록 해야한다.  
		request.setCharacterEncoding(encoding);  
		
		//여기에 response까지 설정을 해버리면, 파일 설정이 고착화되어버린다.(종류와 상관없이 고정되어버린다)  
		// 물론 조건문으로 해결이 가능하지만 정밀하게 작업을 해야하는 문제가 생긴다.  
    >>>> response는 나중에 jsp에서 각 페이지별로 따로 설정을 해줄것이다.    
  - request encoding 고착화 해결 방법
    - xml파일에서 filter 태그 안에 init-param 을 설정해주면 된다
    - param-name 과 param-value 가 키와 값의 쌍으로 전달된다.
    - 이는 Filter 클래스에서 init을 통해 doFilter가 수행되기 전에 초기설정을 할 수 있다.
      - filterConfig.getInitParameter("")를 통해 xml 파일에서 설정했던 init-param의 정보를 가져올 수 있다.
