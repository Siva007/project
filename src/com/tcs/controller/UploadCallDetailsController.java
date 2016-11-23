package com.tcs.controller;
import java.io.File;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.tcs.model.CallDetails;
import com.tcs.DAO.CallDAO;

//class begins
public class UploadCallDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UploadCallDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	//do post for uploading a file
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try{
						DiskFileItemFactory factory = new DiskFileItemFactory();
								
								ServletFileUpload sfu  = new ServletFileUpload(factory);
								
								if ( !ServletFileUpload.isMultipartContent(request)) 
								{
									System.out.println("sorry. No file uploaded");
								}
				         
								// parse request to get file items
								List<?> items=sfu.parseRequest(request);
								
								//get uploaded file
								FileItem file=(FileItem)items.get(0);
								String fName=file.getName();
								long size=file.getSize();
								String filecontent= file.getString();
								System.out.println(filecontent);
							    CallDAO bll=new CallDAO();
						          CallDetails cd = new CallDetails();			
						    	String filestore_rel = "WEB-INF/upload.csv";
								String filestore_abs= getServletContext().getRealPath(filestore_rel);
								System.out.println(filestore_abs);
								File f= new File(filestore_abs);
								
								if(!f.exists())
								{
									f.createNewFile();
								}  	
								System.out.println(f.canRead()+" "+f.canWrite()+" "+f.canExecute());   
								FileUtils.writeStringToFile(f, filecontent, "UTF-8");

								String filecsv = filestore_abs;
								 CallDAO bl=new  CallDAO();
								
								String flag =bl.filecal(filecsv);
								System.out.println("flag"+flag);
								
								if(flag.equals("uploadSuccess"))
								{
									  response.sendRedirect("UploadCl1.jsp");
								
								}
								else
								{
									
									 RequestDispatcher rd=null;
									 request.setAttribute("mrg", flag);
									 rd=this.getServletContext().getRequestDispatcher("/UploadCl2.jsp");
									 rd.forward(request, response);
									
									
								}
								
																
								  
								   
		}
		catch(Exception e)
		{
			RequestDispatcher rd=null;
			String msg1;
			msg1="Server encoutered some problem <br> </br> Please try again";
			request.setAttribute("message",msg1);
			rd=this.getServletContext().getRequestDispatcher("/message.jsp");
			rd.forward(request, response);	
		}
		
		
			}//end of do post
		
	}//end of class


