package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@Service("BWriteCommand")
public class BWriteCommand implements Command {
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String realFolder = "";
		String saveFolder = "boardupload";
		BDao bDao = sqlSession.getMapper(BDao.class);
		
		int fileSize = 5*1024*1024;
		realFolder = request.getRealPath(saveFolder);
		boolean result = false;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder,fileSize,"utf-8",new DefaultFileRenamePolicy());
			
			
			String bName =  multi.getParameter("bName");
			String bTitle =  multi.getParameter("bTitle");
			String bContent =  multi.getParameter("bContent");
			 
			String file = multi.getFilesystemName((String)multi.getFileNames().nextElement());
			System.out.println(1);
			try {
				bDao.write(bName, bTitle, bContent, file);
				model.addAttribute("msg", "저장성공");
				model.addAttribute("url", "list");
				System.out.println(2);
			}catch (Exception e) {
					
				model.addAttribute("msg", "게시글 등록 에러");
				model.addAttribute("url", "history.back()");
				e.printStackTrace();
				System.out.println(e);
			}
		}catch(Exception ex){
   			ex.printStackTrace();
   			System.out.println(4);
		}
		
	}

}
