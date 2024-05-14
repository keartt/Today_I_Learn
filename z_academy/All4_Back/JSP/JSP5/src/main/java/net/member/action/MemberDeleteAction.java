package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.member.db.MemberDAO;

public class MemberDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("var");
		
		// DB 연결하고
		MemberDAO memberDAO = new MemberDAO(); 
		
		memberDAO.deleteUser(id);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("MemberList.me");
		
		
		return forward;
	
	}
}
