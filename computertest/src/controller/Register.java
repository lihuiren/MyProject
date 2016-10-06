package controller;

import java.io.IOException;
import java.util.UUID;

import javaBean.LogDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException {
    	String errmsg = "";  
        String user = request.getParameter("user");  
        //将用户名设置为uuid格式
        UUID uuid=UUID.nameUUIDFromBytes(user.getBytes());
        String str = uuid.toString();
        String uuidUser=str.replace("-", "");
        String password = request.getParameter("pwd");  
        String pwdAgain = request.getParameter("pwdagain");  
  
        try {  
            if (password.equals(pwdAgain)) {  
                LogDao ld = new LogDao();  
                if (!ld.registSelect(uuidUser, password)) {  
                    ld.registInsert(uuidUser, password);
                    errmsg = "注册成功！";  
                    request.setAttribute("errmsg", errmsg);  
                    request.getRequestDispatcher("/index.jsp").forward(request,  
                            response);  
                } else {  
                    errmsg = "用户名已存在！";  
                    request.setAttribute("errmsg", errmsg);  
                    request.getRequestDispatcher("/index.jsp").forward(request,  
                            response);  
                }  
            } else {  
                errmsg = "两次输入的密码不一致";  
                request.setAttribute("errmsg", errmsg);  
                request.getRequestDispatcher("/index.jsp").forward(request,  
                        response);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
       
    }  
    
}  