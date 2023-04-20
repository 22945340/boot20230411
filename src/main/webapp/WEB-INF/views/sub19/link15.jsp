<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<h1> 책목록</h1>
	<hr />
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<td>제목</td>
					<td>출판일</td>
					<td>가격</td>
					<td>무게</td>
					<td>업데이트일</td>
				</tr>
			</thead>
			<c:forEach items="${bookList }" var = "book">
				<tbody>
					<tr>
						<td>${book.title }</td>
						<td>${book.published }</td>
						<td>${book.price }</td>
						<td>${book.weight }</td>
						<td>${book.updated }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>