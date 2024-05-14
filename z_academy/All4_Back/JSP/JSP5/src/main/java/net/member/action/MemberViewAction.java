package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberViewAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		
		MemberDAO memberDAO = new MemberDAO();
		ActionForward forward= new ActionForward();
		MemberBean member = new MemberBean();
		
		String id = request.getParameter("var");
		
		member = memberDAO.ViewUser(id);
		
		request.setAttribute("member", member);
		
		forward.setRedirect(false);
		forward.setPath("./member/Member_info.jsp");
		return forward;
	}

}
