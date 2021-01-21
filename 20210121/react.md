오늘은 React 3번째 시간입니다.

> ## Today I Learned
  - React를 활용한 list 페이지 만들기

### React를 활용한 list 페이지 만들기
  - 기존에 jsp에서 만들던 view에서 react component로 옮길때 jstl, el 태그는 다 지워줘야함
    - jstl , el 모두가 백단에서 jasper가 인식하고 처리하는건데 컴포넌트로 빼서 프론트에서 작업하면 jsx가 jstl, el을 처리할수 없음
    - 서버는 문서를 처리하는 작업을 하지 않음. 그저 js, css 파일만 제공
    - 서버는 데이터를 제공하는 api 만 제공
  - 주의사항
    - class > className
    - onclick='string' > onClick={()=>{실행하고자 하는 로직}}
    - input > value 값을 넣을때는 onChange or read-only 필수.  
  - Ajax로 서버 데이터 가져오기(list)
  ![](https://images.velog.io/images/junjun-creator/post/95977dad-879c-48b5-b333-132b314bf3ef/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-21%20%EC%98%A4%EC%A0%84%2010.51.22.png)
  
  - state 설정하기
    - 실행순서를 잘 고려해야함
      - constructor > render > DidMount
```
	constructor(props){
		super(props);
		this.state={
			list:[
				{"id":92032472,"title":"eff","writerId":"newlec","content":"af"}
			],
			count:0,
			page:1
		};
	}
	
	componentDidMount(){
		fetch(`/api/notice/list?p=${this.state.page}`)
		.then((response)=>{
			return response.json();
		})
		.then((list)=>{
			this.setState({list});
		});
	}
```

  - map()을 활용하여 state값 rendering 하기
    - jsx 코드 안에 스크립트 코드를 넣기 위해 {} 블록을 사용
    - map
      - 값을 순회하면서 지정한 값으로 변경하여 새로운 객체를 생성하여 반환
```
{
this.state.list.map(notice=><tr key={notice.id}>
				<td>{notice.id}</td>
				<td className="title indent text-align-left"><a href={notice.id}>{notice.title}</a>[{notice.cmtCount}]</td>
				<td>{notice.writerId}</td>
				<td>{notice.regdate}</td>
				<td>{notice.hit}</td>
			</tr>)
}
```
