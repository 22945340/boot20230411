$("#button1").click(function(){
	$.ajax("/sub34/link1");
});

$("#button2").click(function(){
	$.ajax("/sub34/link2");
})

$("#button3").click(function(){
	$.ajax("/sub34/link3?name=son");
})

$("#button4").click(function(){
	$.ajax("/sub34/link4?address=seoul");
})

$("#button5").click(function(){
	$.ajax("/sub34/link5?name=son&age=33");
})

$("#button6").click(function(){
	$.ajax("/sub34/link6?food=ramen&price=1000.4");
})

$("#button7").click(function(){
	$.ajax("/sub34/link7?address=seoul&name=son&age=33");
})

$("#button8").click(function(){
	$.ajax("/sub34/link8?price=3.14&product=toy&category=hobby");
})
