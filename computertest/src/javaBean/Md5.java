package javaBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
public String pwdmd5(String pwd){
	//16进制放入数组中
	char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
            'a', 'b', 'c', 'd', 'e', 'f' }; 
	try {
		//将密码密码转换为一个字节数组
		byte[] strPwd=pwd.getBytes();
		//使用md5加密方法
		MessageDigest md=MessageDigest.getInstance("MD5");
		//将转换的密码数组由加密方法进行加密
		md.update(strPwd);
		//获取加密摘要
		byte[] mdDigest=md.digest();
		//获取摘要长度
		int j=mdDigest.length;
		//再创建一个一字节数组 数组长度为摘要长度*2
		char str[] = new char[j * 2];  
        int k = 0;  
        for (int i = 0; i < j; i++) {
        	//获取加密摘要内容
            byte byte0 = mdDigest[i];
            //不带符号右移4位 位移处补0&取低4位的值==获取最高4位值
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            //获取最低4位值
            str[k++] = hexDigits[byte0 & 0xf];  
        }  
        return new String(str);  
		
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
}
