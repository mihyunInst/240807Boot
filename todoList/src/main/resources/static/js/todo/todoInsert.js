console.log("todoInsert.js loaded");

const todoInsertForm = document.getElementById("todoInsertForm");

const todoTitle = document.querySelector("#todoInsertForm input[name='todoTitle']");
const todoContent = document.querySelector("#todoInsertForm textarea[name='todoContent']");

if(todoInsertForm != null){
    // todo 삽입 시도를 할 때
    todoInsertForm.addEventListener("submit", e => {

        // 제목이 입력되지 않은 경우
        // 문자열.trim() : 문자열 좌우 공백 제거
        if(todoTitle.value.trim().length == 0){
            alert("제목을 입력해주세요.");

            todoTitle.value = ""; // 잘못 입력된 값(공백) 제거
            todoTitle.focus(); // 제목 input태그에 초점을 맞춤

            e.preventDefault(); // (기본이벤트 제거 : 제출 못하게하기)
            return; 
        }


        // 내용이 입력되지 않은 경우
        if(todoContent.value.trim().length == 0){
            alert("내용을 입력해주세요.");

            todoContent.value = ""; // 잘못 입력된 값(공백) 제거
            todoContent.focus(); // 내용 textarea 태그에 초점을 맞춤

            e.preventDefault(); // 제출 못하게하기
            return; 
        }


    });
}

