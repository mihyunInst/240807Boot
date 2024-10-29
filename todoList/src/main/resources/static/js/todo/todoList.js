console.log("todoList.js loaded");

const completeFlagBtns = document.querySelectorAll("[name=complete-flag-btn]");

//배열로 저장되기 때문에 forEach로 하나씩 이벤트를 등록해야함

completeFlagBtns.forEach((btn) => {
	
	btn.addEventListener('click', e => {
		console.log(e.target.parentNode.id); // todo-header-btn에 작성된 todoNo를 얻어오기 위함
		
		const target = e.target;
		const todoNo = target.parentNode.id;
		const flag = target.innerText;
		
		// fetch 이용해서 ajax 통신하기
		
		if(flag == '완료') {
			
			
		} else {
			
		}
		
	})
	
});