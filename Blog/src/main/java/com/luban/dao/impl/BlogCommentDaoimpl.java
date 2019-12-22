package com.luban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.luban.dao.BlogCommentDao;
import com.luban.po.BlogComment;

import com.luban.util.Basedao;
/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */
public class BlogCommentDaoimpl  extends Basedao implements BlogCommentDao{
	/**
	 * 查询 文章分类信息
	 * @return ListBlogCommen
	 */
	public List<BlogComment> query(){
		List<BlogComment> list  = new ArrayList<BlogComment>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement("select * from blog_comment");
			//3.给点位符赋值
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				//创建对象
				BlogComment blogcomment =new BlogComment();
				blogcomment.setBU_ID(rs.getInt(1));
				blogcomment.setBa_id(rs.getInt(2));
				blogcomment.setBUCommentNAME(rs.getString(3));
				blogcomment.setBUCONTENT(rs.getString(4));
				blogcomment.setContent(rs.getString("Content"));
				blogcomment.setBUCREATETIME(rs.getDate(6));
				blogcomment.setBUreply_IME(rs.getDate(7));
				
				list.add(blogcomment);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		
		return list;
	}
		
	
	/**
	 * 添加文章分类
	 * @param 
	 * @return int
	 */
	public int save(BlogComment blogcomment){
		String sql="insert into blog_comment(bu_id,bu_comment_name,Content,bu_create_time)values(blog_comment_seq.nextval,?,?,sysdate)";
		Object agrs[]={blogcomment.getBUCommentNAME(),blogcomment.getContent()};
		return Basedao.executeupdate(sql, agrs);
	}
	
	
	/**t
	 * 删除  
	 * 
	 */
	public int delete(int id){
		String sql="delete from  blog_comment where BU_ID=?";
		Object agrs[]={id};
		return Basedao.executeupdate(sql, agrs);
	}
	
	
	/**
	 * 
	 * 修改
	 */
	public int update(BlogComment blogcomment){
		String sql="update blog_comment set Content=?, bu_create_time=sysdate  where BU_ID=?";
		Object agrs[]={blogcomment.getBUCONTENT(),blogcomment.getBU_ID()};
		return Basedao.executeupdate(sql, agrs);
	}
	/**
	 * 根据id查询分类信息
	 */
	public BlogComment findById(int id){
		BlogComment blogcomment=null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement("select * from blog_comment where BU_ID=?");
			//3.给点位符赋值
			psmt.setInt(1, id);
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				//创建对象
				blogcomment =new BlogComment();
				blogcomment.setBU_ID(rs.getInt(1));
				blogcomment.setBa_id(rs.getInt(2));
				blogcomment.setBUCommentNAME(rs.getString(3));
				blogcomment.setBUCONTENT(rs.getString(4));
			
				blogcomment.setBUCREATETIME(rs.getDate(6));
				blogcomment.setBUreply_IME(rs.getDate(7));
				
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		
		return blogcomment;
	}
	


}
