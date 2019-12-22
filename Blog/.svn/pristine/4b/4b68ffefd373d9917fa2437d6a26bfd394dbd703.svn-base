package com.luban.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * Basedao.java
 *describe:
 *2019 年 下午11:08:00
 *小张
 */


public class Basedao {
	
	private static String a="";
    private static String b="";
	private static String c="";
	private static String d="";
	/**
	 * 获取propertise
	 */
	static{
		innit();
	}
     public static void innit(){
    	Properties pr=new Properties();
    	String path="db.propertise";
    	InputStream input=Basedao.class.getClassLoader().getResourceAsStream(path);
    	try {
			pr.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	a=(String) pr.get("a");
    	b=(String) pr.get("b");
    	c=(String) pr.get("c");
    	d=(String) pr.get("d");
    	
     }
  /**
   * 建立连接   
   * 
   */
     public static Connection getConnection(){
 		Connection conn=null;
 		try {
 			Class.forName(a);
 			
 			conn = DriverManager.getConnection(b,c,d);
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		
 		return conn;
 	
 }

     /**
      * 释放资源
      */
 	public static void closeA(Connection conn,Statement stm,ResultSet rs ){
 		try {
 			if(null!=rs){
 			rs.close();
 			}
 			if(null!=stm){
 			stm.close();
 			}
 			if(null!=conn){
 			conn.close();
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 	/**
     * 封装增删改查
     */
 	public static int executeupdate(String sql,Object agrs[]){
 		int num=0;
 		Connection conn=null;
		PreparedStatement pstm = null;
		try {
			
			conn=Basedao.getConnection();
			pstm = conn.prepareStatement(sql);
			
			for(int i=0;i<agrs.length;i++){
				pstm.setObject(i+1, agrs[i]);
			}
			num=pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
		Basedao.closeA(conn, pstm, null);
		}
	
 		return num;
 		
 		
 	}
 	/**
 	 * 测试
 	 * 
 	 */
 	public static void main(String[] args) {
		System.out.println(Basedao.getConnection());
	}
 	
    
}
