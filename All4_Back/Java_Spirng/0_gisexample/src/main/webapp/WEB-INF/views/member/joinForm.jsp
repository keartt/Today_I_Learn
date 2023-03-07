<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>JoinForm</title>

<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

.btn {
	background-color: #ccccff;
	border: none;
	border-radius: 5px;
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
}
;
</style>
<script src="<c:url value='/resources/static/js/join.js' />"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 지도 api -->
</head>

<body>
	<BR>
	<form name=form action="join_ok" method="post"
		onsubmit="return checkAll()">
		<table width="570" height="300" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#ccccff"
					style="font-size: medium; font-weight: bold;">회원 기본 정보</td>
			</tr>
			<tr>
				<td width="120" align="center" style="font-weight: bold;"
					bgcolor="#DBDBDB">아이디 :</td>
				<td><input type="text" name="id" id="id" minlength="4"
					maxlength="12" size="10"> &nbsp; 4~12자의 영문 대소문자와 숫자로만 입력 <!-- button class="btn" type="button" onclick="fn_dbCheckId()" name="dbCheckId">중복확인</button>
					<input type="hidden" name="idDuplication" value="idUncheck"/> --></td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">비밀번호:</td>
				<td><input type="password" name="pw" id="pw" minlength="4"
					maxlength="12" size="10"> &nbsp; 4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">비밀번호
					확인:</td>
				<td><input type="password" name="pwRe" id="pwRe" minlength="4"
					maxlength="12" size="10" /></td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">메일주소:</td>
				<td><input type="text" name="mail" id="mail"> &nbsp; 예)
					&nbsp; id@domain.com</td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">이름
					:</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="#ccccff"
					style="font-size: medium; font-weight: bold;">개인 신상 정보</td>
			</tr>

			<tr>
				<td align="center" bgcolor="DBDBDB"><B>주민등록번호 :</B></td>
				<td><input type="password" name="pnumber" size="30">예)1234561234567</td>
			</tr>

			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">생일:</td>
				<td><input type="text" name="birthday" id="birthday" size="5"
					maxlength="4" />&nbsp;년 &nbsp; &nbsp; <select name="month"
					id="month">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> &nbsp;월 &nbsp; &nbsp; <select name="day" id="day">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select> &nbsp;일</td>
			</tr>

			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">주소:</td>
				<td><input type="text" id="postcode" name="zipcode" size="5"
					readonly> <input class="btn" type="button" value="우편번호검색"
					onclick="post()"><br> 
					<input type="text" id="address"	name="addr1" size="50" placeholder="주소" readonly><br>
					<input type="text" id="detailAddress" name="addr2" size="50"
					placeholder="상세주소"></td>
			</tr>

			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">관심분야:</td>
				<td><input type="checkbox" name="favorite" value="computer">컴퓨터
					<input type="checkbox" name="favorite" value="internet">인터넷 <input
					type="checkbox" name="favorite" value="see">여행 <input
					type="checkbox" name="favorite" value="movie">영화감상 <input
					type="checkbox" name="favorite" value="music">음악감상</td>
			</tr>
			<tr>
				<td align="center" style="font-weight: bold;" bgcolor="#DBDBDB">자기소개:</td>
				<td><textarea name="introduce" id="introduce" cols="50" rows="4"></textarea>
				</td>
			</tr>
		</table>
		<p align="center">
			<input class="btn" type="submit" value="회원가입"> <input
				class="btn" type="reset" value="다시입력">
		</p>
	</form>
</body>
</html>