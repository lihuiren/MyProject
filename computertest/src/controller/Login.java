package controller;

import java.io.IOException;
import java.util.UUID;

import javaBean.LogDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException {  
        String errmsg = "";  
        //获取用户输入的东西  
        String username = request.getParameter("user"); 
        //将用户名转换为uuid格式
        UUID uuid=UUID.nameUUIDFromBytes(username.getBytes());
        String str = uuid.toString();
        String uuidUsername=str.replace("-", "");
        String password = request.getParameter("pwd"); 
        //获取网址 进行判断是否为钓鱼网站
        StringBuffer url=request.getRequestURL();
        //获取发出请求的网页的网址
        String url1=request.getParameter("logInterface");
        try {  
            //构造操作数据库的语句  
            LogDao ld = new LogDao();           
            //根据不同的查询结果的，返回不同的结果到View层  
            if(ld.logInterface(url.toString())&&ld.logInterface(url1)){
            if (ld.logdao(uuidUsername, password)) {  
                    HttpSession session = request.getSession();  
                    session.setAttribute("username", username);  
                    request.getRequestDispatcher("/welcome.jsp").forward(  
                            request, response);   
            } else {  
                errmsg = "用户名或密码错误！";  
                request.setAttribute("errmsg", errmsg);  
                request.getRequestDispatcher("/index.jsp").forward(request,  
                        response);  
              }  
           } else{
        	   errmsg = "该网站为钓鱼网站！";  
               request.setAttribute("errmsg", errmsg);  
               request.getRequestDispatcher("/index.jsp").forward(request,  
                       response);  
           }
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
}  
