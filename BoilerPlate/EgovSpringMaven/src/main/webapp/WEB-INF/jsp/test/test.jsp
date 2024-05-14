<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="${path}/js/lib/jQuery/jquery.min.js"></script>
	<script src="${path}/js/lib/jQuery/jquery-ui.js"></script>
    <script src="${path}/js/lib/jQuery/jquery.mousewheel.min.js"></script>
    <script src="${path}/js/lib/jQuery/jquery.bootpag.min.js"></script>
</head>
<body>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    input {
      padding: 8px;
      margin-bottom: 10px;
      box-sizing: border-box;
    }

    button {
      background-color: #4caf50;
      color: white;
      padding: 10px 15px;
      border: none;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049;
    }

    ul {
      list-style-type: none;
      padding: 0;
      margin: 0;
    }

    li {
      margin-bottom: 8px;
    }
  </style>
</head>
<body>
  <div>
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
    <label for="phoneNumber">전화번호:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="전화번호를 입력하세요">
	
    <button onclick="submitForm()">전송</button>
  </div>

  <div>
    <h2>이름 번호 목록</h2>
    <ul id="contactList">
      <!-- 이름 번호 목록이 여기에 동적으로 추가됩니다. -->
    </ul>
  </div>
  <script src="${path}/js/test/test.js"></script>
  
</body>
</html>
