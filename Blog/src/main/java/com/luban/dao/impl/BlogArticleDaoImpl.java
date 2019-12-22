package com.luban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.luban.dao.BlogArticleDao;
import com.luban.po.BlogArticle;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
import com.luban.util.Basedao;
/**
 * BlogArticleServlet.java
 *describe:
 *2019 年 下午3:28:49
 *小张
 */


public class BlogArticleDaoImpl extends Basedao implements BlogArticleDao{

	public int queryCountArticle(int bacId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int queryCount(Integer bacChildId, Integer bacParentId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "";
		if(bacChildId==bacParentId){
			sql="select count(*) from blog_article b where b.bac_id=? or b.bac_child_id=?";
		}else{
			sql="select count(*) from blog_article b where b.bac_id=? and b.bac_child_id=?";
		}
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement(sql);
			//3.给点位符赋值
			psmt.setObject(1, bacParentId);
			psmt.setObject(2, bacChildId);
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			rs.next();
			count=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return count;
	}
/**
 * 分页查询
 */
	public List<BlogArticle> pageList(PageInfo info, BlogArticle article) {
		List<BlogArticle> list = new ArrayList<BlogArticle>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select blog.*,blog.bac_name from (select b.*,bb.bac_name,rownum num  from blog_article b ,blog_article_category bb  where b.bac_child_id= bb.bac_id  ";
		
		if(article!=null){
			if(null!=article.getBaTitle()&& !"".equals(article.getBaTitle())){
				sql+="and b.ba_title like ? ";
			}
			
			if(null!=article.getBacId()&& !"".equals(article.getBacId())){
				sql+="and b.bac_id=?  ";
			}
			if(null!=article.getBacChildId()&& !"".equals(article.getBacChildId())){
				sql+="and b.bac_child_id=?  ";
			}
			
		}
		sql+=" ) blog where blog.num>? and  blog.num<=? ";
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement(sql);
			//3.给点位符赋值
			int i=1;
			if(article!=null){
				if(null!=article.getBaTitle()&& !"".equals(article.getBaTitle())){
					psmt.setObject(i++, "%"+article.getBaTitle()+"%");
				}
				
				if(null!=article.getBacId()&& !"".equals(article.getBacId())){
					psmt.setObject(i++, article.getBacId());
				}
				if(null!=article.getBacChildId()&& !"".equals(article.getBacChildId())){
					psmt.setObject(i++, article.getBacChildId());
				}
				
			}
			//begin
			int begin = (info.getCurrPageNo()-1)*info.getPageSize();
			psmt.setObject(i++, begin);
			psmt.setObject(i++, begin+info.getPageSize());
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				BlogArticle article2 = new BlogArticle();
				article2.setBacId(rs.getInt(1));
				article2.setBaTitle(rs.getString(2));
				article2.setBaDescription(rs.getString(3));
				article2.setBacId(rs.getInt("bac_id"));
				article2.setBacChildId(rs.getInt("bac_child_id"));
				article2.setCreatetime(rs.getDate(6));
				article2.setBacName(rs.getString("bac_name"));
				//把对象存入list集合中
				list.add(article2);
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
 * 查询出总条数
 */
	public int getToltalCount(BlogArticle article) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select count(*)  from blog_article b where 1=1 ";
		
		if(article!=null){
			if(null!=article.getBaTitle()&& !"".equals(article.getBaTitle())){
				sql+="and b.ba_title like ? ";
			}
			
			if(null!=article.getBacId()&& !"".equals(article.getBacId())){
				sql+="and b.bac_id=?  ";
			}
			if(null!=article.getBacChildId()&& !"".equals(article.getBacChildId())){
				sql+="and b.bac_child_id=?  ";
			}
			
		}
		
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement(sql);
			//3.给点位符赋值
			int i=1;
			if(article!=null){
				if(null!=article.getBaTitle()&& !"".equals(article.getBaTitle())){
					psmt.setObject(i++, "%"+article.getBaTitle()+"%");
				}
				
				if(null!=article.getBacId()&& !"".equals(article.getBacId())){
					psmt.setObject(i++, article.getBacId());
				}
				if(null!=article.getBacChildId()&& !"".equals(article.getBacChildId())){
					psmt.setObject(i++, article.getBacChildId());
				}
				
			}
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			rs.next();
			count=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		
		
		return count;
	}
/**
 * 查询全部
 */
	public List<BlogArticle> query() {
		List<BlogArticle> list  = new ArrayList<BlogArticle>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//1.建立连接
			conn= Basedao.getConnection();
			//2.处理预编译SQL语句
			psmt=conn.prepareStatement("select * from blog_article");
			//3.给点位符赋值
			//4.执行预编译SQL语句并返回结果集
			rs=psmt.executeQuery();
			//5.循环遍历
			while(rs.next()){
				//创建对象
				BlogArticle article2 = new BlogArticle();
				article2.setBaId(rs.getInt("BA_ID"));
				article2.setBaTitle(rs.getString(2));
				article2.setBaDescription(rs.getString(3));
				//把BlogArticleCategory存入list集合中
				list.add(article2);
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
	 * @param a
	 * @return int
	 */
public int save(BlogArticle article) {
	String sql="insert into blog_article(BA_ID,BA_TITLE,BA_DESCRIPTION)values(blog_article_seq.nextval,?,?)";
	Object agrs[]={article.getBaTitle(),article.getBaDescription()};
	return Basedao.executeupdate(sql, agrs);
}
/**
 * 删除
 */
	public int delete(int id) {
		String sql="delete from blog_article where BA_ID=?";
		Object agrs[]={id};
		return Basedao.executeupdate(sql, agrs);
	}
	/**
	 * 根据id查询
	 */
public BlogArticle findUserById(int id) {
	BlogArticle blogarticle=null;
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	try {
		//1.建立连接
		conn= Basedao.getConnection();
		//2.处理预编译SQL语句
		psmt=conn.prepareStatement("select * from blog_article  where BA_ID=?");
		//3.给点位符赋值
		psmt.setInt(1, id);
		//4.执行预编译SQL语句并返回结果集
		rs=psmt.executeQuery();
		//5.循环遍历
		while(rs.next()){
			//创建对象
			blogarticle = new BlogArticle();
			blogarticle.setBaId(rs.getInt("BA_ID"));
			blogarticle.setBaTitle(rs.getString(2));
			blogarticle.setBaDescription(rs.getString(3));
			//把BlogArticleCategory存入list集合中
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		//6.释放资源
		Basedao.closeA(conn, psmt, rs);
	}
	return blogarticle;
}

/**
 * 修改方法
 */
public int update(BlogArticle article) {
	String sql="update blog_article  set BA_TITLE=?, BA_DESCRIPTION =?where BA_ID=?";
	Object agrs[]={article.getBaTitle(),article.getBaDescription(),article.getBaId()};
	return Basedao.executeupdate(sql, agrs);
}

	
	

}
