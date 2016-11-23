<%@ page import="java.sql.*,java.io.*,java.util.*,com.tcs.model.*" %>
<%@ page import="com.tcs.util.DBUtil" %>
 <%
 //String filename = (String)request.getAttribute("imgType");
 String filename="idproof"+".jpg";
 com.tcs.model.Image imager=(com.tcs.model.Image)request.getAttribute("image");
 Blob img=imager.getImage();
		 int len = imager.getLength(); 
		 byte [] rb = new byte[len]; 
		 InputStream readImg = img.getBinaryStream(); 
		 readImg.read(rb, 0, len); 
		 
		 response.reset();
		 response.setContentType("image/jpg");
		response.setHeader("Content-disposition","attachment; filename=" +filename); 
		 response.getOutputStream().write(rb,0,len); 
		 response.getOutputStream().flush(); 
		 DBUtil.closeConnection();
	 %>