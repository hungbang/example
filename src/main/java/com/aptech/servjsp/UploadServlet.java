package com.aptech.servjsp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "C:/uploads";
	private static final String UPLOAD_DIRECTORY_MAC = "/Users/KAI/Desktop";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMC = ServletFileUpload.isMultipartContent(request);
		
//		String name = request.getParameter("onlyName");
//		System.out.println("=====name : "+ name);
		
		//check is multipart/form-data
		if(isMC){
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()){
						String nameFile = new File(fileItem.getName()).getName();
						fileItem.write(new File(UPLOAD_DIRECTORY_MAC + File.separator + nameFile));
					}
					if(fileItem.isFormField()){
						String name = fileItem.getFieldName();
						String value = fileItem.getString();
						System.out.println("=====name :" + name + "value = "+ value);
					}
				}
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (FileUploadException e) {
				request.setAttribute("message", "File Upload Failed due to " + e);

				e.printStackTrace();
				
			} catch (Exception e) {
				request.setAttribute("message", "File Upload Failed due to " + e);
				
				e.printStackTrace();
			}
		}else{
			request.setAttribute("message","Sorry this Servlet only handles file upload request");

		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
