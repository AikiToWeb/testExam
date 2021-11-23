<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<ProductInfo> pdtList = (ArrayList<ProductInfo>) request.getAttribute("pdtList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	font-size: 13px;
}

ol, ul {list-style: none;}

a:link {
	color: #4f4f4f;
	text-decoration: none;
}

a:visited {
	color: #4f4f4f;
	text-decoration: none;
}

a:hover {
	color: #f00;
	text-decoration: underline;
}

#wrapper {
	width: 1250px;
	margin: 0 auto;
}

#top {
	width: 100%;
	height: 50px;
	text-align: center;
	font-size: 25px;
	color: #4f4f4f;
	font-weight: bold;
	padding-top: 30px;
}

.outerBox {
	border: 5px #4f4f4f solid;
	width: 270px;
	text-align: center;
	padding: 5px;
	margin: 10px;
	float: left;
}

.innerBox {
	border: 1px #000 solid;
	width: 260px;
	height: 190px;
	padding: 5px;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
}

.pdtName {
	font-size: 15px;
	padding-top: 7px;
	padding-bottom: 3px;
	font-weight: bold;
}

.pdtPrice {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="top">PRODUCTS LIST</div>
		<div>
			<%
				for (int i = 0; i < pdtList.size(); i++) {
					ProductInfo pi = pdtList.get(i);
			%>
			<div class="outerBox">
				<div class="innerBox">
					<img src="img/pdt0<%=i + 1%>.png" width="256" height="200" />
				</div>
				<div class="pdtName"><%=pi.getPi_name()%></div>
				￦ <span class="pdtPrice"><%=pi.getPi_cost()%></span>
			</div>
			<%
				if (i % 4 == 3) {
						out.println("</div>");
						out.println("<div>");
					}
					if (i == pdtList.size() - 1 && i % 4 != 3) {
						// 현재 출력하는 데이터가 pdtList의 마지막 데이터 이면서 4칸을 모두 채우지 못했을 경우
						out.println("</div>");
					}
			%>
			<%}%>
		</div>
		
</body>
</html>