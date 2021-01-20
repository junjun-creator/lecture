오늘은 React 2번째 시간입니다.

> ## Today I Learned
  - dfdf
  
### 덧셈 계산기 만들기 예제
  - 만들고자 하는 ui component 단위로 나누기
    - input value = 0으로 초기화
```
function app(){
	ReactDOM.render(
	      <section>
	         <h1>계산기</h1>
	         <div>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="button" value="계산"/>
	            <input type="text" dir="rtl" value={0}/>
	         </div>
	      </section>
		, document.querySelector("#app") 
	);
}
app();
```
  - VDOM 부분을 Calc라는 컴포넌트로 분리해서 작성(using function)
```
function Calc(){
	return <section>
	         <h1>계산기</h1>
	         <div>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="button" value="계산"/>
	            <input type="text" dir="rtl" value={0} />
	         </div>
	      </section>;
}

function app(){
	ReactDOM.render(
	      <Calc />
		, document.querySelector("#app") 
	);
}
app();
```
  - VDOM 부분을 Calc라는 컴포넌트로 분리해서 작성(using class)
```
class Calc extends React.Component{
	render(){
		return <section>
	         <h1>계산기</h1>
	         <div>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="text" dir="rtl" value={0}/>
	            <input type="button" value="계산"/>
	            <input type="text" dir="rtl" value={0} />
	         </div>
	      </section>; 
	}
}
```
  - state를 이용해서 model값 저장하기
    - 주의사항
      - 닫는 태그 꼭 확인하기
      - 값을 넣을때는 문자열을 빼야함
      - JSX가 지정하는 속성명 사용 (ex. class > className)
      - 1 way 모델링을 준수하기
        - 기존에 mvc 모델에서는 input의 value를 view에서 변경하면 model의 값도 변경이 됬다. 
        - flux(react)는 이런 2 way를 지원하지 않는다. 값이 변경이 되면, 차음으로 다시 돌아와서 model을 변경시켜야 함.
        - 그래서 onChange와 같은 이벤트를 등록해줘야 함
```
class Calc extends React.Component{
	constructor(props){
		super(props);
		this.state = {x:0, y:0,result:0};
	}
	
	componentDidMount(){
		
	}
	
	componentWillUnmount(){
		
	}
	
	btnClick(){
		//console.log(this.state.x);
		let {x,y} = this.state;
		this.setState({result:x*1+y*1});
	}
	
	render(){
		return <section>
	         <h1>계산기</h1>
	         <div>
	            <input type="text" dir="rtl" value={this.state.x} onChange={(e)=>{this.setState({x:e.target.value})}}/>
	            <input type="text" dir="rtl" value={this.state.y} onChange={(e)=>{this.setState({y:e.target.value})}}/>
	            <input type="button" value="계산" onClick={this.btnClick.bind(this)}/>
	            <input type="text" dir="rtl" value={this.state.result} readOnly/>
	         </div>
	      </section>; 
	}
}
```

### React를 활용한 list 페이지 만들기
  - 기존에 jsp에서 만들던 view에서 react component로 옮길때 jstl, el 태그는 다 지워줘야함
    - jstl , el 모두가 백단에서 jasper가 인식하고 처리하는건데 컴포넌트로 빼서 프론트에서 작업하면 jsx가 jstl, el을 처리할수 없음
    - 서버는 문서를 처리하는 작업을 하지 않음. 그저 js, css 파일만 제공
    - 서버는 데이터를 제공하는 api 만 제공
