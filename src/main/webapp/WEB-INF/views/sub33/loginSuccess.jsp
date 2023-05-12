<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h3>로그인 성공</h3> 
	<sec:authentication property="credentials"/> <br />
	<sec:authentication property="principal"/> <br />
	<sec:authentication property="Authorities"/> <br />
	<sec:authentication property="details"/> <br />
	<sec:authentication property="name" var="username"/> <br />
	<sec:authentication property="authenticated"/> <br />
	<div>
		${username }
	</div>
	<div>
		${username }
	</div>
	
	<div>
		<a href="/sub33/viewAuth"> 백엔드에서 로그인 정보 확인</a>
	</div>
	
	<sec:authorize access="hasAuthority('admin')">
		<div>
			admin이 볼 수 있는 컨텐츠
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('manager')">
		<div>
			manager가 볼 수 있는 컨텐츠
		</div>
	</sec:authorize>
	<sec:authorize access="hasAuthority('user')">
		<div>
			user가 볼 수 있는 컨텐츠
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()"> 
		<div>
			로그인하면 볼 수 있는
		</div>
	</sec:authorize>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>