<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>ȸ������</title>
<script type="text/javascript" src="join.js" charset="utf-8"></script>
</head>
 <body>
    <p><h1 align="center">ȸ�� ����</h1>
    <br>
    <FORM name="form"  action="view_users.jsp" method="post" onsubmit="return join();">
      <table width="50%" height="80" border="1" align="center" cellpadding="5" cellspacing="0">
        <tr align="center">
          <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px">
            ȸ���⺻����
          </td>
        </tr>
        <tr>
          <td>
            ���̵�
          </td>
          <td> <input type="text" name="user_id" id="user_id" size="12" maxlength="12"> 4~12���� ���� ��ҹ��ڿ� ���ڷθ� �Է�
          </td>
        </tr>
        <tr>
          <td>��й�ȣ</td>
          <td> <input type="password" name="user_pw" id="user_pw" size="12" maxlength="12"> 4~12���� ���� ��ҹ��ڿ� ���ڷθ� �Է�
          </td>
        </tr>
        <tr>
          <td>��й�ȣ Ȯ��</td>
          <td> <input type="password" name="pw_chk" id="pw_chk" size="12" maxlength="12"></td>
        </tr>
        <tr>
          <td>�����ּ�</td>
          <td> <input type="text" name="email" id="email"> ��)id@domain.com
          </td>
        </tr>
        <tr>
          <td>�̸�</td>
          <td> <input type="text" name="name" id="name" size="10" maxlength="10"></td>
        </tr>
        <tr align="center">
          <td colspan="2" align="center" bgcolor="grey" style="font-weight: bold; font-size: 18px">
            ���� �Ż� ����
          </td>

        </tr>
        <tr>
          <td> �ֹε�Ϲ�ȣ</td>
          <td> <input type="text" name="regi_num_front" id="regi_num_front" size="6" maxlength="6">
            - &nbsp; <input type="text" name="regi_num_back" id="regi_num_back" size="7" maxlength="7">
            ��)123456-1234567
          </td>
        </tr>
        <tr>
          <td>���� </td>
          <td> <input type="text" name="year" id="year" size="4" maxlength="4">�� 
            <select id="month" name="month">
              <option value="01" selected="selected">1</option>
              <option value="02">2</option>
              <option value="03">3</option>
              <option value="04">4</option>
              <option value="05">5</option>
              <option value="06">6</option>
              <option value="07">7</option>
              <option value="08">8</option>
              <option value="09">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select> �� 
            <select id="day" name="day">
              <option value="01" selected="selected">1</option>
              <option value="02">2</option>
              <option value="03">3</option>
              <option value="04">4</option>
              <option value="05">5</option>
              <option value="06">6</option>
              <option value="07">7</option>
              <option value="08">8</option>
              <option value="09">9</option>
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
            </select>��
          </td>
        </tr>
        <tr>
          <td>���ɺо� </td>
          <td id="interest">
            <input type="checkbox" name="interest" value="��ǻ��">��ǻ�� 
            <input type="checkbox" name="interest" value="���ͳ�">���ͳ�
            <input type="checkbox" name="interest" value="����">���� 
            <input type="checkbox" name="interest" value="��ȭ����">��ȭ����
            <input type="checkbox" name="interest" value="���ǰ���">���ǰ���
          </td>
        </tr>
        <tr>
          <td>�ڱ�Ұ� </td>
          <td><textarea name="introduce" id="introduce" cols="70" rows="5"></textarea></td>
        </tr>

      </table>
      <p align="center">
        <input type="submit" value="ȸ�� ����" name="submit"> <input type="reset" value="�ٽ� �Է�">
    </FORM>



  </body>
</html>
