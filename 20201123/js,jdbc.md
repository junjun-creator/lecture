# javascript
  - 자바스크립트>document object>window object
# window
  - .location
  - .history
  - .document
# 기본 자료형 var
  - 객체(참조변수)
  - 동적 자료형 : 실행환경에 의한 오류 확인
  - wrapper class로 값이 박싱되고, 그것을 참조하는 방식
  - 사실상 자료형은 아님.
    - boolean, number, string들이 자료형(wrapper class)
    - undefined : 아직 초기화된 적이 없다~~ 상태값
# array
  - 배열, 컬렉션
  - 모든 타입을 한번에 넣을수 있음(array도 담을수 있음)
  - push, pop을 통해 스택처럼 사용 가능(LIFO)
  - push, shift를 통해 버퍼처럼 사용 가능(FIFO)
  - unshift : 앞으로 값을 넣을 수 있음
  - splice(3) : 3번째의 값부터 뒤로 모두 제거 >> splice(2,1) : 2번째 값 부터 1개만 제거
  - splice(1,0,23) : 1번째 값부터 0개를 제거하고 1번째 위치에 23을 추가
---
# 서블릿 프로그램
  - 출력할 수 있는가?
  - 입력할 수 있는가?
  - 입력
    - get 요청 >> url 길이의 제한이 있어서 많은 양을 보낼 수 없음
      - url : 쿼리스트링
      - form : 쿼리스트링
    - post 요청 >> 길이 제한 없이 많은 양을 보낼 때 및 보안내용을 보낼때 사용
      - form : 헤더 body(form data)를 통한 전달
  - get 요청시 null이 아닌지와, 빈문자열이 온것이 아닌지 체크를 해서 사용해야함.. 에러가 유발됨
  - 입력 encoding >> setCharacterEncoding으로 세팅 하거나 집중화를 위해 filter 사용(다음시간에)
