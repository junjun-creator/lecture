오늘은 ES6 3번째 수업시간입니다

> ## Today I Learned
  - set
  - map
  - rest parameter
  - spread operator
  - default value
  - arrow function
  
### Set
  - 자료형에 관계 없이 원시값과 객체참조 모두 중복되지 않는 유일한 값을 저장할 수 있습니다.
  - let set = new Set();
    - 매개변수로 iterable한 객체가 전달 되면, 그 요소는 모두 새로운 Set에 추가 됨. 없으면 빈 Set 생성(map,array 등은 iterable)
  - 삽입, 삭제, 소유여부, 크기 예시
   
![](https://images.velog.io/images/junjun-creator/post/a58be11c-629b-4723-b95b-7d48f10c1833/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-03%20%EC%98%A4%EC%A0%84%208.42.07.png)

  - 순회
  
![](https://images.velog.io/images/junjun-creator/post/6065d62b-1dee-41bd-8be6-c176d18130fb/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-03%20%EC%98%A4%EC%A0%84%208.42.31.png)

### Map
  - 기본적인 동작은 Set과 유사하다.
  - 아무거나 다 넣을 수 있으며, 넣는 순서도 기억하는 콜렉션이다.
  - 사용예시
  
![](https://images.velog.io/images/junjun-creator/post/fa93cb56-7768-4225-b362-dbd9e41fa23d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-03%20%EC%98%A4%EC%A0%84%209.51.15.png)

### Rest Parameter
  - 함수를 호출할 때, 전달하는 값의 갯수와 매개변수의 갯수가 일치 하지 않아도 호출 가능하다(자바스크립트에서는 전달하는 값을 arguments 콜렉션에 따로 저장하기때문에 가능하다)
  - 매개변수는 그저 arguments에서 값을 가져오는 별칭에 불과하다.
  - 그렇다면 별칭이 없는 나머지 인자들은 무조건 arguments 콜렉션을 통해서 접근해야하나??
    - 나머지 인자들도 쉽게 접근하기 위해 rest parameter를 쓴다.
    - ...values >> values 배열로 나머지 인자들을 접근 가능하다.

![](https://images.velog.io/images/junjun-creator/post/23068e8c-b290-40f5-94fe-85b2cc950e27/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-03%20%EC%98%A4%EC%A0%84%209.58.19.png)

### Spread Operator
  - 함수의 매개변수로 배열과 같은 객체가 전달될 때, 우리는 이것을 뽀개서 사용 할 수 있었다.
  - 하지만 만약, 함수가 미리 정의 되어있고, 함수에서 매개변수 인자를 뽀갤수 없다면?
  - 호출을 할때 뽀개서 보내주면 된다.
  
![](https://images.velog.io/images/junjun-creator/post/41fa7a23-ddb1-4872-ac53-91bf168f5b37/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-03%20%EC%98%A4%EC%A0%84%2010.06.23.png)
  
### Default Value
  - javascript는 태생적으로 overload를 갖고 있다.(함수의 인자를 맘대로 조절할 수 있다)
    - 하지만 이런 특성때문에 인자값이 충족 되지 않을 경우 undefine이 되고, 결과로 리턴되는 값이 NaN이 되는 일이 발생한다.
    - 이런 문제를 해결하기위해 ES5까지는 다양한 방법들을 사용해왔다.
    
![](https://images.velog.io/images/junjun-creator/post/255e0365-e893-4995-9bd2-10cd71c5f5cf/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-31%20%EC%98%A4%ED%9B%84%204.52.12.png)

  - ES6 방식의 default value 설정 방법
    - 함수의 매개변수에서 default value 설정 가능
    - 상수 뿐만아니라, 변수,함수로도 default value를 설정할 수 있다.
 
![](https://images.velog.io/images/junjun-creator/post/c470e799-5fbe-48fd-bd60-05efcddc91fd/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-31%20%EC%98%A4%ED%9B%84%204.53.12.png)

![](https://images.velog.io/images/junjun-creator/post/db1da2c6-e9f3-4464-a5d9-c8327972f42e/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-31%20%EC%98%A4%ED%9B%84%204.56.34.png)

  - 그렇다면 전달된 인자가 arguments 배열에 저장되는데, 호출할때 인자는 1개이고, 기본값으로 설정한 인자가 2개일때, arguments에 저장되는 값은 몇개일까?
    - 1개이다. 호출시 전달한 인자의 갯수만 저장된다.
    
### Arrow Function
  - 차이점 : no this, no arguments, no super, no new.target
  - function이라 명명하면 지역화가 생김
  - arrow function은 지역화가 필요 없을때 사용
    - (x,y)=>x-y
    - function(x,y){return x-y;}와 같음
    
![](https://images.velog.io/images/junjun-creator/post/8b405828-b02c-4c91-a51b-589b42b9dcc8/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-31%20%EC%98%A4%ED%9B%84%205.35.36.png)
