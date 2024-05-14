<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="users" class="join.Users" scope="page"/>
<jsp:setProperty property="*" name="users" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="join.js"></script>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
  <p>
  <h1 align="center">회원정보</h1>
  <br>
    <table width="40%" height="80" border="1" align="center" cellpadding="5" cellspacing="0" >
      <tr align="center">
        <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px ">
          회원기본정보
        </td>
      </tr>
      <tr>
       <td style="width:30%">
          아이디
        </td>
        <td> <jsp:getProperty name="users"  property="user_id"  />
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td> <%= users.getUser_pw() %>
        </td>
      </tr>
      <tr>
        <td>메일주소</td>
        <td> <jsp:getProperty name="users"  property="email"  />
        </td>
      </tr>
      <tr>
        <td>이름</td>
        <td> <jsp:getProperty name="users"  property="name"  /></td>
      </tr>
      <tr align="center">
        <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px">
          개인 신상 정보
        </td>

      </tr>
      <tr>
        <td> 주민등록번호</td>
        <td><jsp:getProperty name="users"  property="regi_num_front"  />
        -  <jsp:getProperty name="users"  property="regi_num_back"  /></td>
      </tr>
      <tr>
        <td>생년월일 </td>
        <td> <jsp:getProperty name="users"  property="year"  />
        <jsp:getProperty name="users"  property="month"  />
        <jsp:getProperty name="users"  property="day"  />       </td>
      </tr>
      <tr>
        <td>관심분야 </td>
        <td>
        <% 
        String check[] = users.getInterest();
        for(String i:check){
            out.print(i);%><br><%
        }
        %>
		 </td>
      </tr>
      <tr>
        <td>자기소개 </td>
        <td>
        <jsp:getProperty name="users"  property="introduce"  />
		</td>
      </tr>

    </table>
    <p align="center">
      <input type="submit" value="회원 가입" name="submit"> <input type="reset" value="다시 입력">



</body>
</html>