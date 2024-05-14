package net.member.action;
import java.io.PrintWriter;
import  java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.member.db.MemberDAO;

public class JoinAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// DB 연결하고
		MemberDAO memberDAO = new MemberDAO();
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String intro = request.getParameter("introduce");
		
		// 주소
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		String add3 = request.getParameter("add3");
		String address = "우편번호 : " + add1 + "<br>주소 : " + add2 + "-" + add3; 

		// 생년월일
		String birth = "" + year + "-" + month + "-" + day;

		// 체크박스
		String[] temp = request.getParameterValues("interest");
		String hobby = Arrays.toString(temp);
		
		// 가입 성공 1
		// 실패 = 0 try 실패 즉 아이디가 중복인거
		int a  = memberDAO.Join( id,  pw,  email,  name,  birth, hobby,  intro, address);
		
		
		if (a == 0 ) {
			response.setCharacterEncoding("EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('아이디 이미 있는데요?');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			
			forward.setRedirect(true);
			forward.setPath("join.me");
			
		}else {
			forward.setRedirect(true);
			forward.setPath("MemberLogin.me");
		}
		
		return forward;
	}

}
