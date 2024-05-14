package net.member.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.member.db.MemberDAO;

public class LoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO mb = new MemberDAO();
		ActionForward forward= new ActionForward();
		HttpSession session = request.getSession();
		

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Boolean memberLogin = mb.Login(id, pw);
		System.out.println(memberLogin);
		
		if(memberLogin == false){
			
			response.setCharacterEncoding("EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('가입먼저 하셈.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();


			forward.setPath("MemberLogin.me");
	   		return forward;
	   	}

		session.setAttribute("login", memberLogin);
		session.setAttribute("id", id);

		if(memberLogin && id.equals("admin")){
		   	forward.setRedirect(true);
	   		forward.setPath("MemberList.me");
	   		return forward;
	   		
	   	} else {
	   		forward.setRedirect(true);
	   		forward.setPath("BoardList.bo");
	   		return forward;
	   	}
	}

}
