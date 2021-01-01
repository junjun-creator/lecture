오늘은 ES6 두번째 시간입니다!

> ## Today I Learned
  - 변수로 속성명 지정하기
  - Object Destructuring

### 변수로 속성명 지정하기
  - 대괄호 + 속성명 = 키 사용 가능
  
### Object Destructuring
  - 데이터 구조는 중첩을 낮춰서 사용할 것
    - 구조적인 데이터를 사용할 때는
  - 객체 속성 뽀개기(destruct)
  
![](https://images.velog.io/images/junjun-creator/post/00101a07-6cff-4687-915d-e4e9e66c48bf/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2010.09.07.png)

  - 뽀갤 속성의 순서, 갯수는 상관 없다. 하지만, 속성명은 반드시 일치 시켜줘야한다.
  - 만약, 단일변수{kor,eng}를 사용하고 있는데, 객체의 값이 바뀐다면?
    - 뽀갠 변수의 값도 일일이 변경해줘야 하나?
    - 아니다. 위에 선언한 뽀개기를 이용하여 대입형 뽀개기를 사용하면 된다.
    
![](https://images.velog.io/images/junjun-creator/post/353bc963-0a6a-4eb5-ba1f-86f554c35a0a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2010.19.02.png)

  - 그렇다면 정의되지 않은 속성을 추가(확장) 할 수 있을까? 확장 가능하다면, 기본값은 어떻게 설정 할 것인가?
    - 뽀개기를 하면서 나온 변수를 이용해서 기본값 설정 가능하다!
  
![](https://images.velog.io/images/junjun-creator/post/ea5f251a-b716-4461-97b4-63bf9f57b053/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2010.26.52.png)

  - 주의사항
    - 뽀개기를 하지 않은 변수를 밑에서 적용하려고 할때 에러가 나지 않는다 그 이유는?
    - 분명히 위에서는 math를 뽀개기 하지 않았음에도 밑에서는 math를 마치 쪼개기 했던것처럼 변경된 값으로 적용하고 있다.
    - 이는 let변수로 쪼개어진 math가 아니고 var형태로(window객체변수)로 새로 만들어지는 것이지 뽀개기가 아니다!! 주의하자
    
![](https://images.velog.io/images/junjun-creator/post/06badf41-3d75-4fc9-a9cc-b841acb6495f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2010.54.45.png)

  - 뽀개기 속성에 별칭 달아주기

![](https://images.velog.io/images/junjun-creator/post/be999062-f511-497b-a50d-04df77713798/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2011.00.32.png)

  - 객체안에 객체(중첩)에서 중첩된 속성을 뽀개고 싶을때는?
  
![](https://images.velog.io/images/junjun-creator/post/db2a6acf-95f7-41a8-b0fe-c98d4dccbfeb/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2011.07.14.png)

  - 함수의 매개변수로 전달된 객체 뽀개기
  
![](https://images.velog.io/images/junjun-creator/post/bc7a6d96-43cd-4f13-abed-4d48435538ae/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2011.32.56.png)

  - Array 배열 뽀개기
    - array도 동일한 방식으로 뽀갤 수 있다.
    - 다만, 배열은 키값이 없으므로, 변화된 값을 적용할 때에는 그 위치를 정확히 해줘야 한다.\[,,kor3\]처럼
    
![](https://images.velog.io/images/junjun-creator/post/b2a45e87-9dcf-408d-a97b-8395e1c46d15/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%EC%A0%84%2011.57.55.png)

  - Array 배열 뽀개기를 이용한 꼼수 swapping + 확장 및 초기화

![](https://images.velog.io/images/junjun-creator/post/e74abb23-267c-4e62-aeae-6e3acd4e4080/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%2012.12.07.png)

  - 중첩된 Array 뽀개기

![](https://images.velog.io/images/junjun-creator/post/8171bee5-d1ce-4350-bbac-32836ff0cfaf/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%2012.14.29.png)

  - Mixed(Array, 객체) 중첩 뽀개기

![](https://images.velog.io/images/junjun-creator/post/e7b9766d-010c-4faf-8a50-057dbe7e5556/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202020-12-30%20%EC%98%A4%ED%9B%84%2012.40.38.png)
