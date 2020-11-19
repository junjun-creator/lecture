# .class:first-child
  - 서로 and 관계이다. 첫번째 자식이면서 .class인 태그를 찾는다
# class 명을 언제 넣어주나?
  - 목록, 테이블 등과 같이 구조가 명확한 경우에는 태그를 통해 선택자 설정
# table
  - tr은 경계선이 없어서 경계선을 줄때 td에 각각 경계면을 입혀줘야함
  - border-collapse
    - seperate : 경계선을 각각 갖게 분리
    - collapse : 경계선을 겹쳐둠(합쳐서)
  - border-spacing
    - 보더간에 간격을 둠
  - td가 큰것을 따라감
  - display:table-cell
    - 컨텐츠가 늘어나면 테이블이 늘어나버림(모든걸 감싸안음)
    - table-layout: fixed; 로 해결
---
# eclipse git
  - reset(버전 되돌리기)
    - soft : 버전만 되돌리고 변경사항은 유지(index 상태)
    - mixed : 인덱스 전으로 되돌림. 변경사항을 유지
    - hard : 변경내용과 버전을 모두 지워버림(복구불가)
  - master를 수정하는게 아니고 다른 줄기로 개발을 진행하고 merge 하는방식으로 진행함
  - merge는 master로 브랜치를 이동시킨 뒤에 병합 대상을 선택해서 진행함
---
# servlet annotation
  - annotation을 활용하여 url매핑을 하기 위해서는 선결조건이 있음
    - metadata-complete="false"
    - 메타데이터를 xml에서 완료시키겟다 라는 것을 false로 해줘야 annotation이 적용됨
  - @WebServlet("/admin/member/list") 설정으로 url 매핑 설정
