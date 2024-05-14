package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BWriteCommand implements Command {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String realFolder = "";
		String saveFolder = "boardupload";
		BDao dao = new BDao();
		
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
			
			try {
				dao.write(bName, bTitle, bContent, file);
				model.addAttribute("msg", "저장성공");
				model.addAttribute("url", "list");

			}catch (Exception e) {

				model.addAttribute("msg", "게시글 등록 에러");
				model.addAttribute("url", "history.back()");
			}
			
		}catch(Exception ex){
   			ex.printStackTrace();
   		}
		
	}

}
