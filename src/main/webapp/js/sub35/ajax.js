$("#button1").click(function(){
	$.ajax("/sub35/link1", {method:"post"});
})

$("#button2").click(function(){
	$.ajax("/sub35/link2", {method:"post"});
})

$("#button3").click(function(){
	$.ajax("/sub35/link3",  {
		method:"post", 
		data:"name=손"
		});
})

$("#button4").click(function(){
	$.ajax("/sub35/link4",{
		method:"post",
		data:"address=seoul&price=97.17"
		})
})

$("#button5").click(function(){
	$.ajax("/sub35/link5", {
		method:"post",
		data:"name=손&score=8.88&email=son@gmail.com"
	})
})

$("#button6").click(function(){
	$.ajax("/sub35/link6", {
		method:"post",
		data:"address=seoul&product=bread&price=3.15"
	})
})



$("#button7").click(function() {
	const obj = {name:"son"};
	$.ajax("/sub35/link7", {
		method: "post",
		//data: '{"name": "son"}'
		data: JSON.stringify(obj)
		,contentType: "application/json"
	})
})

$("#button8").click(function(){
	const obj = {
		address:"seoul",
		name:"박지성"
	};
	$.ajax("/sub35/link8",{
		method: "post",
		//data: '{"address" : "seoul", "name":"박지성"}'
		data: JSON.stringify(obj)
		,contentType: "application/json"
	})
})

$("#button9").click(function(){
	const obj = {
		age : 27,
		name : "홀란둥이",
		married : true
	}
	
	$.ajax("/sub35/link9", {
		method:"post",
		// data:'{"age" : 27, "name" : "홀란둥이", "married" : true}',
		data : JSON.stringify(obj),
		contentType:"application/json"
	})
})


$("#button10").click(function(){
	const obj	 = {
		address : null,
		age : 30,
		name : "손흥민"
	}
	
	$.ajax("/sub35/link10", {
		method: "post",
		contentType:"application/json",
		// data:`{"address" : null, "age" : 30, "name" : "손흥민"}`
		data:JSON.stringify(obj)
	})
})


$("#button11").click(function(){
	const deliveryInfo = {
		book : {"title":"java", "price":300},
		address : "seoul"
	}
	$.ajax("/sub35/link11",{
		method: "post",
		contentType:"application/json",
		// data:`{"book" : {"title" : "java", "price" : 300}, "address" : "seoul"}`
		data:JSON.stringify(deliveryInfo)
	})
})


$("#button12").click(function(){
	const storeInfo = {
		store : "피자스쿨",
		food : ["pizza", "cake", "coffe"]
	}
	$.ajax("/sub35/link12", {
		method:"post",
		contentType:"application/json",
		// data:`{"food":["pizza","cake","coffe"], "store" : "피자스쿨"}`
		data:JSON.stringify(storeInfo)
	})
})


$("#button13").click(function(){
	const menu = ["pizza", "coke", "coffe"]
	
	$.ajax("/sub35/link13",{
		method:"post",
		contentType:"application/json",
		// data: `["pizza", "coke", "coffee"]`
		data:JSON.stringify(menu)
	})
})

$("#button14").click(function(){
	const playerInfo = [
		{"name" : "강백호", "pos":"파포"},
		{"name" : "서태웅", "pos":"스포"},
		{"name" : "송태섭", "pos":"포가"},
		{"name" : "정대만", "pos":"슈가"},
		{"name" : "채치수", "pos":"센터"}
	]
	$.ajax("/sub35/link14",{
		method:"post",
		contentType:"application/json",
		// data:`[{"name":"강백호", "pos":"파포"}, {"name":"서태웅", "pos" : "스포"}]`
		data: JSON.stringify(playerInfo)
	})
})