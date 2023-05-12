$("#btn1").click(function() {

	const obj = {
		name: "정대만",
		age: 40
	}

	$.ajax("/sub36/link1", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(obj)
	})
})

$("#btn2").click(function() {
	const data = {
		name: "손흥민",
		email: "son@gmail.com",
		score: 8.9,
		married: false
	}

	$.ajax("/sub36/link2", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})


$("#btn3").click(function() {
	const data = {
		name: "태웅",
		hobby: [
			"독서",
			"농구",
			"음악감상"
		]
	};

	$.ajax("/sub36/link3", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})


$("#btn4").click(function() {
	const info = {
		name: "손흥민",
		phone: [
			"010-1234-1234",
			"010-9876-5432",
			"010-3333-4444",
			"010-5555-6666"
		]
	};

	$.ajax("/sub36/link4", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(info)
	})
})

$("#btn5").click(function() {
	const data = {
		name: "자바",
		publisher: "한빛",
		writer: {
			name: "정대만",
			age: 44
		}
	}

	$.ajax("/sub36/link5", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})

$("#btn6").click(function() {
	const data = {
		city: "seoul",
		price: 7000,
		etc: {
			name: "손흥민",
			email: "son@gmail.com",
			score: 8.7,
			married: true
		}
	};

	$.ajax("/sub36/link6", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})


$("#btn7").click(function() {

	const data = [
		{
			name: "이강인",
			age: 22
		},
		{
			name: "서태웅",
			age: 33
		},
		{
			name: "손흥민",
			age: 44
		}
	]
	$.ajax("/sub36/link7", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})

$("#btn8").click(function() {

	const name = $("#inputName").val();
	const age = $("#inputAge").val();

	const data = {
		name: name,
		age: age
	}

	$.ajax("/sub36/link1", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})

$("#btn9").click(function() {
	const data = {
		name: $("#inputName9").val(),
		email: $("#inputEmail").val(),
		score: $("#inputScore").val(),
//		married: document.querySelector("#inputMarried").checked
		married:$("#inputMarried").is(":checked")
	};

	$.ajax("/sub36/link2", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data)
	})
})

