react 학습내용입니다.

> ## Today I Learned
  - react 라이브러리
  - react state

### react 라이브러리 추가하기
  - CDN 추가.
```
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script crossorigin src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
```

  - Virtual DOM rendering
    - 주의사항 : render안에 들어오는 엘리먼트는 무조건 root 여야함. 2개의 root node가 들어올 수 없음
```
function tick(){
	
	ReactDOM.render(
		<section>
			<h1>세계 시간</h1>
			<section>
				<h1>America/Toronto</h1>
				<span>It is {new Date().toLocaleString("en-US",{timeZone:"America/Toronto"})}</span>
			</section>
			<section>
				<h1>Asia/Seoul</h1>
				<span>It is {new Date().toLocaleString("ko-KR",{timeZone:"Asia/Seoul"})}</span>
			</section>
		</section>
		
	,document.querySelector('#root'));
}

setInterval(tick,1000);

```

  - 궂이 이걸 쓰는게 무슨 이득이 있나? 
    - 자바스크립트 : 행위만 신경
    - react : ui+행위
    - react는 component 기반으로 이루어져있다.
      - ui별로 component 단위로 나누어서 구현할 수 있다.
```
function Clock(){
	return <section>
				<h1>America/Toronto</h1>
				<span>It is {new Date().toLocaleString("en-US",{timeZone:"America/Toronto"})}</span>
		</section>;
}

function tick(){
	
	ReactDOM.render(
		<section>
			<h1>세계 시간</h1>
			
			<Clock />
			<Clock />
		</section>
		
	,document.querySelector('#root'));
}

setInterval(tick,1000);
```
  - 하나의 ui 모양으로 여러개를 만들고자 한다면?
    - 들어가는 내용만 전달해서 바꿔주는 식으로 사용
    - 불러오는 태그에서는 태그스럽게 값을 전달(속성)
    - 그걸 읽어들이는 함수는 함수스럽게 값을 받음
      - 매개변수명은 props로 하는게 좋음.
```
function Clock(props){
	let time = new Date().toLocaleString(props.locale,{timeZone:props.timeZone});
	return <section>
				<h1>{props.timeZone}</h1>
				<span>It is {time}</span>
		</section>;
}

function tick(){
	
	ReactDOM.render(
		<section>
			<h1>세계 시간</h1>
			<hr />
			<Clock locale="en-US" timeZone="America/Toronto"/>
			<hr />
			<Clock locale="ko-KR" timeZone="Asia/Seoul"/>
		</section>
		
	,document.querySelector('#root'));
}

setInterval(tick,1000);
```
  - 조금 더 객체지향스럽게 class로 component 정의하기
    - 생성자 유무에 따른 차이
      - 생성자를 직접 생성 : props를 인자로 받아 직접 사용하므로 this 필요없음
      - 생성자를 사용 X : 해당 클래스로 생성된 객체의 속성을 참조해야하므로 해당 객체라는것을 명확히 짚어줘야함. 그래서 this 꼭 써줘야함
```
/*
class Clock extends React.Component{//객체지향적인 캡슐화 가능
	#time;
	constructor(props){
		super(props);//필수 무조건 react.Component에 보내줘야함
		this.#time = new Date().toLocaleString(props.locale,{timeZone:props.timeZone});
	}
	
	render(){
		return <section>
				<h1>{this.props.timeZone}</h1>
				<span>It is {this.#time}</span>
		</section>;
	}
}*/

class Clock extends React.Component{//객체지향적인 캡슐화 가능
	render(){
		let time = new Date().toLocaleString(this.props.locale,{timeZone:this.props.timeZone});
		return <section>
				<h1>{this.props.timeZone}</h1>
				<span>It is {time}</span>
		</section>;
	}
}
```
  - 직접 props를 사용하면 좋은 방법이 아니다.
  - 이를 해결하기 위해 state라는 store(버퍼화된 model)의 개념이 나온다.
    - flux의 순서 : dispatcher > store > view 단방향
  - 변화되는 모든 내용들은 state로 관리
    - state가 처음 생성될 때만 '='연산자로 값을 넣어줄 수 있음.
    - 그 다음부터는 set을 통해서 데이터를 쌓아가야함
      - 개인적인 생각으로는 마운트 될때만 state를 새로 생성 가능하고, 그 뒤에는 set으로 쌓아줘야하는 것 같음.
      - 마운트는 처음 생성할때만 됨.
  - setInterval을 통해 렌더링이 수행될 때, 처음에는 객체를 생성하지만, 그 뒤에 실행될때는 render() 메소드만 계속 실행된다.
  - 초기화 작업
    - 생성자
      - 메모리에 올라갈때 초기화 
    - 마운트
      - onload시에 초기화
  - State를 왜 쓰나??
    - 데이터를 1way로 효율적으로 관리하기 위해?
  
### state를 활용한 예제
```
class Clock extends React.Component{//객체지향적인 캡슐화 가능
	constructor(props){
		super(props);//필수 무조건 react.Component에 보내줘야함
		
		let time = new Date().toLocaleString(this.props.locale,{timeZone:this.props.timeZone});
		let timeZone = props.timeZone;

		this.state = {time,timeZone};
		
	}
	
	tick(){
		let time = new Date().toLocaleString(this.props.locale,{timeZone:this.props.timeZone});
		let timeZone = this.props.timeZone;

		this.setState({time,timeZone});
	}
	
	componentDidMount(){//mount 된 후
	/*
		setInterval(function tick(){
			let time = new Date().toLocaleString(this.props.locale,{timeZone:this.props.timeZone});
			let timeZone = this.props.timeZone;

			this.setState({time,timeZone});
		}.bind(this),1000);
	*/
		setInterval(()=>{this.tick();},1000);
	}
	
	componentWillUnmount(){//mount 해제 전
		console.log("will unmount");
	}
	
	render(){
		return <section>
				<h1>{this.state.timeZone}</h1>
				<span>It is {this.state.time}</span>
		</section>;
	}
}

function tick(){
	
	ReactDOM.render(
		<section>
			<h1>세계 시간</h1>
			<hr />
			<Clock locale="en-US" timeZone="America/Toronto"/>
			<hr />
			<Clock locale="ko-KR" timeZone="Asia/Seoul"/>
		</section>
		
	,document.querySelector('#root'));
}
tick();
```
  - 코드 분석
    - ReactDOM.render()를 통해 컴포넌트 렌더링
    - 렌더링시 props로 전달한 값을 통해 생성자에서 state 설정.
    - 설정된 state객체 정보를 이용하여 값을 삽입하고 컴포넌트 랜더링
    - componentDidMount : 컴포넌트가 마운트 된 뒤에 실행되는 메소드 --> 컴포넌트 마운트 후에 state의 변화가 필요할 경우 이 메소드에서 로직을 구현한다.
    - state의 변화는 setState 메소드를 통해 수행
    - setState 메소드는 해당 컴포넌트의 re-rendering을 발생시킴
  - 주의사항
    - 예제와 같이 setInterval에서 setState를 실행시키기 위해서는 해당 컴포넌트의 this를 통해서 실행해야함.
    - 하지만 일반 function으로는 bind 해주지 않으면 해당 컴포넌트 this에 접근이 안됨.
    - 이를 해결하기 위해서는 bind를 해주거나, ES6 Arrow function을 사용해야함.
      - arrow function은 함수가 실행될 때 this를 새로 정의하지 않음. 바깥 함수 또는 클래스의 this 값을 사용함.
  - component, state, attribute
