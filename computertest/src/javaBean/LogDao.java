package javaBean;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class LogDao {
	
	/**
	 *判断登陆
	 */
	public boolean logdao(String user,String pwd){
		String sql="select * from usertable where username='"+user+"'and password='"+pwd+"'";
		List<Map<String, Object>> loginres = JDBCUtil.doQuery(sql);
		if(loginres!=null&&loginres.size()==1){
		return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 判断用户名是否重复
	 */
	public boolean registSelect(String user,String pwd){
		String sql="select * from usertable where username='"+user+"'";
		List<Map<String, Object>> registres = JDBCUtil.doQuery(sql);
		if(registres!=null&&registres.size()==1){
		return true;
		}else{
			return false;
		}
	}
	/**
	 *注册是否成功
	 */
	public boolean registInsert(String user,String pwd){
		String sql="insert into usertable(username,password) values('"+user+"','"+pwd+"')";
		return JDBCUtil.doUpdate(sql);
		
	}
	/**
	 * 是否为钓鱼网站
	 */
	public boolean logInterface(String url){
		String sql="select * from interface where url='"+url+"'";
		List<Map<String, Object>> urlres = JDBCUtil.doQuery(sql);
		if(urlres!=null&&urlres.size()==1){
		return false;
		}else{
			return true;
		}
	}
}
