오늘은 React 5번째 시간입니다.

> ## Today I Learned
  - 검색 기능
  - 페이저 기능

### 검색기능
  - 검색 field와 query 값 설정
    - this.field, query
      - DOM 객체 사용하지 않고, React.createReg() 사용하여 현재 값 가져오기
```
constructor(props){
		super(props);
		this.state={
			list:[
				{"id":92032472,"title":"eff","writerId":"newlec","content":"af"}
			],
			count:0
		};
		
		this.queryInput = React.createRef();
		this.fieldInput = React.createRef();
		
		this.page=1;
		this.field = "title";
		this.query = "";
		
	}
```
  - 설정된 field와 query값을 통해 데이터 바인딩
```
dataBind(){
		fetch(`/api/notice/list?p=${this.page}&f=${this.field}&q=${this.query}`)
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			
			this.setState(data);
		});
	}
```

  - 검색 form
```
<form className="table-form">
									<fieldset>
										<legend className="hidden">공지사항 검색 필드</legend>
										<label className="hidden">검색분류</label>
										<select ref={this.fieldInput} name="f">
											<option  value="title">제목</option>
											<option  value="writerId">작성자</option>
										</select> 
										<label className="hidden">검색어</label>
										<input type="text" name="q" ref={this.queryInput}/>
										<input className="btn btn-search" type="submit" value="검색" onClick={(e)=>{this.search(e);}}/>
									</fieldset>
								</form>
```
  
  - onClick 이벤트
  
```
search(e){
		e.preventDefault();
		this.query = this.queryInput.current.value;
		this.field = this.fieldInput.current.value;
		
		this.dataBind();
	}
```

### 페이저 기능
  - 패이저를 위한 controller 설정
    - list
    - count
  ![](https://images.velog.io/images/junjun-creator/post/1653e033-4571-4557-a773-b6d8a1a597e9/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-22%20%EC%98%A4%ED%9B%84%202.29.45.png)
  
  - 페이저 start number 설정
```
constructor(props){
		super(props);
		this.state={
			list:[
				{"id":92032472,"title":"eff","writerId":"newlec","content":"af"}
			],
			count:0
		};
		
		this.queryInput = React.createRef();
		this.fieldInput = React.createRef();
		
		this.page=1;
		this.field = "title";
		this.query = "";
		let offset = (this.page -1)%5;
		this.startNum = this.page-offset;
	}
```
  - 페이저 ui
```
<ul className="-list- center" onClick={(e)=>{this.pageClickHandler(e);}}>
	{
		[0,1,2,3,4].map((i)=><li key={i+this.startNum}><a className="-text-  " href="?p={i}&f=&q=">{i+this.startNum}</a></li>)
	}
							
</ul>
```

  - 이전 버튼
```
<div>
	{
		this.startNum==1?
		<span className="btn btn-prev" onClick={(e)=>{alert('이전 페이지가 없습니다.')}}>이전</span>
		:<a className="btn btn-prev" href="?p=&f=&q=">이전</a>
	}
</div>
```
