### Transaction : 논리적인 실행 단위
  - (반드시) 한번에 수행되어야 할 명령들의 집합
  - 반대 > 물리적인 실행 단위 : update 등
  - 논리적 실행단위 : 계좌이체
  - 물리적 실행단위 : update 2회
  - 하나의 논리적인 실행을 위해 물리적 실행이 2회 일어나야하는데 둘 중 하나라도 처리되지 않을 경우, 트랜잭션이 깨졌다 라고 할 수 있다.
  - spring에서는 DAO에서 jdbc 실행시마다 각각 connection이 연결, 해제 되는 작업이 실행된다.
  - 이러면 대용량 트래픽이 있는경우 원치 않는 데이터가 수정되거나, 원치 않는 데이터를 참조하게 되는 문제가 발생할 수 있다.(물리적인 실행 도중 에러가 발생 할 수 있음)
  - 이를 해결하기위해 하나의 논리적인 실행 단위에서 발생하는 모든 connection을 하나로 묶어서 모두 성공하여 commit 되었을때 connection이 해제되도록(트랜잭션 완료) 하여 트랜잭션을 관리하게 한다.
  
### @Transaction
  - service 단에서 논리적인 업무로직(transaction)을 처리하게 된다.
  ![](https://images.velog.io/images/junjun-creator/post/ccf0b87a-232a-4d94-a7d1-59392a402a46/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%ED%9B%84%203.03.33.png)
  - 위의 예제에서 atom() 업무에 insert가 2번 수행된다. 둘다 성공하지 않는다면 이 트랜잭션은 실패된다.
  
### Propagation
  - 트랜잭션 내부에서 또다른 트랜잭션 처리가 필요하다면 propagation을 활용해 처리할 수 있다.
  - 나를 호출한 아이가 transaction을 갖고있다면, 그 트랜잭션이 깨지지 않도록 도와줄게! - SUPPORTS
  - requires_new : 나를 호출한 아이가 transaction을 갖고있든 없든 새로운 트랜잭션을 만들어서 먼저 처리할거야!
  - 등등 
  
### Isolation
  - read uncommitted
    - dirty reads are allowed
    - 2개 이상의 스레드가 실행되는 환경에서 다른 스레드에서 수정한 데이터를 commit(or rollback)전에 참조가능한 경우(lock이 없음)
    - lock을 걸지 않고 수행 될 수 있게 하기때문에 성능은 좋아짐
    - 중간에 데이터가 변경되도 상관 없는경우에 사용
    ![](https://images.velog.io/images/junjun-creator/post/7a39f10e-da5a-4c07-8b94-26c54ccae3e9/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%ED%9B%84%203.59.22.png)![](https://images.velog.io/images/junjun-creator/post/21f5393d-c80f-4330-a58b-69575ad3b4c5/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-29%20%EC%98%A4%ED%9B%84%203.59.29.png)
  - read committed
    - non-repeatable reads phenomenon may occur
    - 사용중인 레코드가 중간에 다른 스레드에서 변경하여 commit한 경우 허용. 다시 그 원래 값을 얻을 수 없다는(non-repeatable) 특징
  - repeatable_read
    - 사용중인 레코드는 모두 lock 걸어버림(그동안 다른스레드에서 변경 불가)
    - 기본 설정
  - serialization
    - 사용중인 테이블 전체를 lock 걸어버림
 
