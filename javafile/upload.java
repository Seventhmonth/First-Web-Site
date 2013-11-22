package market;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.omg.CORBA.portable.InputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet("/uploadFiles")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 10,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15 // 15 MB        
)

public class upload extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{ 
			 PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		 String pname = request.getParameter("pname");
		 String desc = request.getParameter("desc");
		 String cat = request.getParameter("cat");
		 String url = request.getParameter("file");
		 String pic = pname + ".jpg";
		 int price = Integer.valueOf(request.getParameter("price"));
		 int stock = Integer.parseInt(request.getParameter("stock"));
		 productController pc = new productController();
		 product po = new product();
		 po = pc.createproduct(name, price, stock, desc, cat, pname, pic);
		 pc.addproduct(po);
		 
		String filename = pname + ".jpg";
		Part filePart =  request.getPart("pic");	
		java.io.InputStream filecontent =filePart.getInputStream();
	    S3.DoUpload(filename, filecontent);
	    out.println("<html><body><center><h1>Add Successfully</h1>");
		 out.println("<a href='home.jsp'>Back to Home</a></center></body></html>");
	}catch(Exception e){ System.out.print(e);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
