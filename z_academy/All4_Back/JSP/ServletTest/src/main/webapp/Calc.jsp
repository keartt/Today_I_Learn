<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	 <h2 style="text-align: center;">계산기</h2>

    <form method="post" action="./Calc" style="text-align:center;">
      <input type="text" name="num1">
    <select name="oper">
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="*">*</option>
      <option value="/">/</option>
    </select>
    <input type="text" name="num2" >
    <button type="submit">계산 / 이동</button>
    <button type="reset"> 초기화</button>
    </form>

</body>
</html>