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
  <h1 align="center">ȸ������</h1>
  <br>
    <table width="40%" height="80" border="1" align="center" cellpadding="5" cellspacing="0" >
      <tr align="center">
        <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px ">
          ȸ���⺻����
        </td>
      </tr>
      <tr>
       <td style="width:30%">
          ���̵�
        </td>
        <td> <jsp:getProperty name="users"  property="user_id"  />
        </td>
      </tr>
      <tr>
        <td>��й�ȣ</td>
        <td> <%= users.getUser_pw() %>
        </td>
      </tr>
      <tr>
        <td>�����ּ�</td>
        <td> <jsp:getProperty name="users"  property="email"  />
        </td>
      </tr>
      <tr>
        <td>�̸�</td>
        <td> <jsp:getProperty name="users"  property="name"  /></td>
      </tr>
      <tr align="center">
        <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px">
          ���� �Ż� ����
        </td>

      </tr>
      <tr>
        <td> �ֹε�Ϲ�ȣ</td>
        <td><jsp:getProperty name="users"  property="regi_num_front"  />
        -  <jsp:getProperty name="users"  property="regi_num_back"  /></td>
      </tr>
      <tr>
        <td>������� </td>
        <td> <jsp:getProperty name="users"  property="year"  />
        <jsp:getProperty name="users"  property="month"  />
        <jsp:getProperty name="users"  property="day"  />       </td>
      </tr>
      <tr>
        <td>���ɺо� </td>
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
        <td>�ڱ�Ұ� </td>
        <td>
        <jsp:getProperty name="users"  property="introduce"  />
		</td>
      </tr>

    </table>
    <p align="center">
      <input type="submit" value="ȸ�� ����" name="submit"> <input type="reset" value="�ٽ� �Է�">



</body>
</html>