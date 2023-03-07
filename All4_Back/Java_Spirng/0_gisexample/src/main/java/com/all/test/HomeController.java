package com.all.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.all.test.board.dao.IBDao;
import com.all.test.member.dao.IMDao;
import com.all.test.member.dto.MemberDto;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession; // servlet에 설정한 이름과 같으므로 setDao 안 만들어도 쓸 수 있음!

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// DB 확인
	@RequestMapping("/dbtest")
	public String studentForm() {
		return "jdbcTest";
	}

	// 글 목록
	@RequestMapping("/list")
	public String list(Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("list", dao.listDao());

		return "/board/list";
	}

	// 글 작성 폼
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/board/write_view";
	}

	// 글 작성
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.writeDao(request.getParameter("bTitle"), request.getParameter("bContent"), request.getParameter("bName"));
		return "redirect:list";
	}

	// 글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.deleteDao(request.getParameter("bId"));
		return "redirect:list";
	}

	// 글 상세
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request, Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.upHitDao(request.getParameter("bId")); // 조회수 증가

		// 사용자와 작성자 비교
		String userCheck = "";
		HttpSession session = request.getSession();
		if (dao.contentDao(request.getParameter("bId")).getbName().equals((String) session.getAttribute("id"))) {
			userCheck = "true";
		}
		request.setAttribute("userCheck", userCheck);

		model.addAttribute("content_view", dao.contentDao(request.getParameter("bId")));
		return "/board/content_view";
	}

	// 글 수정
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modifyDao(request.getParameter("bTitle"), request.getParameter("bContent"), request.getParameter("bId"));

		return "redirect:list";
	}

	// 답변 입력 페이지
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("reply_view", dao.reply_view(request.getParameter("bId")));
		return "board/reply_view";
	}

	// 답변
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.replyDao(request.getParameter("bId"), request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"), request.getParameter("bGroup"), request.getParameter("bStep"), request.getParameter("bIndent"));

		return "redirect:list";
	}

	// 로그인 페이지
	@RequestMapping("/login")
	public String login() {
		return "/member/loginForm";
	}

	// 로그인
	@RequestMapping("/loginCK")
	public String loginCk(HttpServletRequest request) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		ArrayList<MemberDto> dto = dao.login(request.getParameter("id"));

		if (dto.isEmpty()) {
			System.out.println("로그인 실패");
			return "redirect:login";
			// 아이디가 없는 경우 error 창이 나오지 않고 login으로 이동 시키기 위함
		} else {
			if (dto.get(0).getMember_pw().equals(request.getParameter("pw"))) {
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("id", request.getParameter("id"));
				return "redirect:login_ok";
			} else {
				System.out.println("로그인 실패2");
				return "redirect:login";
			}
		}

	}

	// 로그인 성공 시
	@RequestMapping("/login_ok")
	public String login_ok() {
		return "/member/main";
	}

	// 회원가입 페이지
	@RequestMapping("/join")
	public String join() {
		return "/member/joinForm";
	}

	// 회원가입
	@RequestMapping("/join_ok")
	public String register_ok(HttpServletRequest request) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		dao.join(request.getParameter("id"), request.getParameter("pw"), request.getParameter("mail"),
				request.getParameter("name"), request.getParameter("pnumber"), request.getParameter("birthday"),
				request.getParameter("month"), request.getParameter("day"), request.getParameter("zipcode"),
				request.getParameter("addr1"), request.getParameter("addr2"), request.getParameter("favorite"),
				request.getParameter("introduce"));

		return "redirect:login";
	}

	// 글 목록
	@RequestMapping("/admin/list")
	public String admin_list(Model model) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		model.addAttribute("list", dao.listDao());

		return "/member/member_list";
	}

	// 회원 상세페이지 - 관리자
	@RequestMapping("/admin/detail")
	public String memberDetail(HttpServletRequest request, Model model) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		model.addAttribute("content_view", dao.MemberDao(request.getParameter("id")));
		return "/member/member_info";
	}

	// 회원 삭제 - 관리자
	@RequestMapping("/admin/delete")
	public String admin_delete(HttpServletRequest request, Model model) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		dao.deleteDao(request.getParameter("id"));
		return "redirect:/admin/list";
	}

	// 회원 상세페이지 - 사용자
	@RequestMapping("/modify_view")
	public String memberView(HttpServletRequest request, Model model) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		model.addAttribute("content_view", dao.MemberDao(request.getParameter("id")));
		return "/member/member_modify";
	}

	// 회원 수정
	@RequestMapping("/modify_act")
	public String memberModify(HttpServletRequest request) {
		IMDao dao = sqlSession.getMapper(IMDao.class);
		dao.modifyDao(request.getParameter("member_id"), request.getParameter("member_pw"), 
				request.getParameter("member_name"), request.getParameter("member_email"), 
				request.getParameter("member_pnumber"), request.getParameter("member_favorite"),
				request.getParameter("member_introduce"),request.getParameter("member_year"),
				request.getParameter("member_month"),request.getParameter("member_day"),
				request.getParameter("member_postcode"),request.getParameter("member_address"));

		return "redirect:login_ok";
	}
}