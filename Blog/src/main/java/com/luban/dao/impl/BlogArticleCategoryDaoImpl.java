package com.luban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luban.dao.BlogArticleCategoryDao;
import com.luban.po.BlogArticleCategory;
import com.luban.util.Basedao;


/**
 * BlogArticleCategoryDaoImpl.java
 *describe:
 *2019 年 上午9:02:01
 *小张
 */
public class BlogArticleCategoryDaoImpl  extends Basedao implements BlogArticleCategoryDao{


	/**
	 * 查询 文章分类信息
	 * @return List<BlogArticleCategory>
	 */
	public List<BlogArticleCategory> query(){
		List<BlogArticleCategory> list  = new ArrayList<BlogArticleCategory>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement("select * from blog_article_category b order by b.bac_parent_id, b.bac_id ");
			//3.给点位符赋值
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				//创建对象
				BlogArticleCategory bac = new BlogArticleCategory();
				bac.setBacId(rs.getInt(1));
				bac.setBacName(rs.getString(2));
				bac.setBacParentId(rs.getInt("bac_parent_id"));
				
				//把BlogArticleCategory存入list集合中
				list.add(bac);
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
	 * @param articleCategory
	 * @return int
	 */
	public int save(BlogArticleCategory articleCategory){
		String sql="insert into blog_article_category (BAC_ID, BAC_NAME, BAC_PARENT_ID) values (blog_article_category_seq.nextval, ?, ?)";
		Object args[]={articleCategory.getBacName(),articleCategory.getBacParentId()};
	
		
		int num = 0;
		Connection conn = null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		try {
			//1.建立连接 
			conn= Basedao.getConnection();
			//手动提交事务
			conn.setAutoCommit(false);
			//2.处理预编译SQL语句 
			pstm=conn.prepareStatement(sql,new String[]{"BAC_ID"});
			//3给点位符赋值
			/*pstm.setObject(1, "刚修改测试");
			pstm.setObject(2, 4);*/
			for(int i =0;i<args.length;i++){
				pstm.setObject(i+1, args[i]);
			}
			//4.执行预编译SQL语句 
			num= pstm.executeUpdate();
			
			
			if(articleCategory.getBacParentId()==0){
				rs=pstm.getGeneratedKeys();
				rs.next();
				int bac_id = rs.getInt(1);
				pstm = conn.prepareStatement("update blog_article_category set bac_parent_id=? where BAC_ID=?");
				pstm.setObject(1, bac_id);
				pstm.setObject(2, bac_id);
				num = pstm.executeUpdate();
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//释放资源
			Basedao.closeA(conn, pstm, rs);
		}
		return num;
	}
	/**
	 * 查询父分类
	 * @return
	 */
	public List<BlogArticleCategory> queryParent(){
		List<BlogArticleCategory> list  = new ArrayList<BlogArticleCategory>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement("select * from blog_article_category  b where b.bac_id=b.bac_parent_id");
			//3.给点位符赋值
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				//创建对象
				BlogArticleCategory bac = new BlogArticleCategory();
				bac.setBacId(rs.getInt(1));
				bac.setBacName(rs.getString(2));
				bac.setBacParentId(rs.getInt("bac_parent_id"));
				
				//把BlogArticleCategory存入list集合中
				list.add(bac);
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
	 * 根据id查询分类信息
	 */
	public BlogArticleCategory findById(int id){
		return null;
	}
	/**
	 * 修改
	 */
	public int update(BlogArticleCategory articleCategory){
		String sql="update blog_article_category set BAC_NAME where BAC_ID=?";
		Object args[]={articleCategory.getBacName(),articleCategory.getBacId()};
		return Basedao.executeupdate(sql, args);
	}
	/**
	 * 删除  
	 * 1.删除分类信息的时候必需 通过 id去查询文章信息
	 */
	public int delete(int bacChildId, int bacParentId) {
		String sql="";
		if(bacChildId==bacParentId){
			sql="delete from blog_article_category b where b.bac_id=? or b.bac_parent_id=?";
		}else{
			sql="delete from blog_article_category b where b.bac_id=? and b.bac_parent_id=?";
		}
		
		Object args[]={bacChildId,bacParentId};
		return Basedao.executeupdate(sql, args);
	}
	

}
