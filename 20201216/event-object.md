# 이벤트 타겟
  - 어디서 이벤특 발생했는지, 등 이벤트에 관한 정보르 담고있는 객체
  - target : 이벤트가 발생한 대상 태그
# 이벤트 버블링
  - delegation
  - 부모에 이벤트를 등록해두면 자식객체에서도 이벤트가 실행됨
  - 이벤트 유발 타겟 : target
  - 이벤트가 등록된 타겟 : currentTarget
  - 유의사항
    - 경계선 등, target이 변경되는 상황을 처리해줘야함
      - target을 검사하는 방법으로 해결
# event notification
  - window객체는 이벤트가 발생한 지점을 찾으러 나섬
  - 자식객체들에게 물어물어 '너네가 이벤트 발생햇니?' 라며 자식을 모두 탐색함
# event bubbling
  - 자식을 클릭해도 부모 등록된 이벤트가 실행됨
  - 방지책
    - event.stopPropagation()(자식입장에서)
# notification에서 부모의 이벤트가 먼저 실행되도록 하는 방법
  - ("click",function(e){},true)
  - 부모의 이벤트만 실행하고 멈추게 하려면
    - 부모에 stopPropagation() 달아주기.
# 기본 행위 제한하기
  - a태그의 href 링크와같은 태그의 기보 행위를 제한함.
  - e.preventDefault();
