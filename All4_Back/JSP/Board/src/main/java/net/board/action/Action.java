package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { //동적바인딩.
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
