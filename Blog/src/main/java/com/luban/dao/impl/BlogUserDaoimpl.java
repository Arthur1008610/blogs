package com.luban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.luban.dao.BlogUserDao;
import com.luban.po.BlogArticleCategory;
import com.luban.po.BlogUser;
import com.luban.po.PageInfo;
import com.luban.util.Basedao;

public class BlogUserDaoimpl extends Basedao implements BlogUserDao {
	/**
	 * 查询 文章分类信息
	 * 
	 * @return List<BlogUser>
	 */
	public List<BlogUser> query() {
		List<BlogUser> list = new ArrayList<BlogUser>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 1.建立连接
			conn = Basedao.getConnection();
			// 2.处理预编译SQL语句
			psmt = conn.prepareStatement("select * from blog_user");
			// 3.给点位符赋值
			// 4.执行预编译SQL语句并返回结果集
			rs = psmt.executeQuery();
			// 5.循环遍历
			while (rs.next()) {
				// 创建对象
				BlogUser bac = new BlogUser();
				bac.setBu_user_id(rs.getInt(1));
				bac.setBU_EMAIL(rs.getString(2));
				bac.setBU_USER_NAME(rs.getString(3));
				bac.setBU_SEX(rs.getString(4));
				bac.setBU_MOBILE(rs.getString("bu_mobile"));
				// 把BlogArticleCategory存入list集合中
				list.add(bac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return list;
	}

	/**
	 * 添加文章分类
	 * 
	 * @param articleCategory
	 * @return int
	 */
	public int save(BlogUser bloguser) {
		String sql = "insert into blog_user ( bu_user_id,bu_email,bu_user_name,bu_password,bu_sex,bu_mobile)values (blog_user_seq.nextval,?,?,?,?,?)";
		Object agrs[] = { bloguser.getBU_EMAIL(), bloguser.getBU_USER_NAME(),
				bloguser.getBU_PASSWORD(), bloguser.getBU_SEX(),
				bloguser.getBU_MOBILE() };
		return Basedao.executeupdate(sql, agrs);
	}

	/**
	 * 根据id查询分类信息
	 */
	public BlogUser findById(int id) {
		BlogUser bac = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 1.建立连接
			conn = Basedao.getConnection();
			// 2.处理预编译SQL语句
			psmt = conn
					.prepareStatement("select * from blog_user where bu_user_id=?");
			// 3.给点位符赋值
			psmt.setInt(1, id);
			// 4.执行预编译SQL语句并返回结果集
			rs = psmt.executeQuery();
			// 5.循环遍历
			while (rs.next()) {
				// 创建对象
				bac = new BlogUser();
				bac.setBu_user_id(rs.getInt(1));
				bac.setBU_EMAIL(rs.getString(2));
				bac.setBU_USER_NAME(rs.getString(3));
				bac.setBU_SEX(rs.getString(4));
				bac.setBU_MOBILE(rs.getString("bu_mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return bac;
	}

	/**
	 * 
	 * 修改
	 */
	public int update(BlogUser bloguser) {
		String sql = "update blog_user set bu_email=?,bu_user_name=?,bu_password=?,bu_sex=?,bu_mobile=? where bu_user_id=?";
		Object agrs[] = { bloguser.getBU_EMAIL(), bloguser.getBU_USER_NAME(),
				bloguser.getBU_PASSWORD(), bloguser.getBU_SEX(),
				bloguser.getBU_MOBILE(), bloguser.getBu_user_id() };
		return Basedao.executeupdate(sql, agrs);
	}

	/**
	 * 删除 1.删除分类信息的时候必需 通过 id去查询文章信息
	 */
	public int delete(int id) {
		String sql = "delete from blog_user where bu_user_id=? ";
		Object agrs[] = { id };
		return Basedao.executeupdate(sql, agrs);
	}
/**
 * 登录
 */
	public BlogUser queryBlogByNameAndPwd(String username, String pwd) {
		BlogUser bac = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 1.建立连接
			conn = Basedao.getConnection();
			// 2.处理预编译SQL语句
			psmt = conn.prepareStatement("select * from blog_user where BU_USER_NAME=?and BU_PASSWORD=?");
			// 3.给点位符赋值
			psmt.setString(1, username);
			psmt.setString(2, pwd);
			// 4.执行预编译SQL语句并返回结果集
			rs = psmt.executeQuery();
			// 5.循环遍历
			while (rs.next()) {
				// 创建对象
				bac = new BlogUser();
				bac.setBu_user_id(rs.getInt(1));
				bac.setBU_EMAIL(rs.getString(2));
				bac.setBU_USER_NAME(rs.getString(3));
				bac.setBU_SEX(rs.getString(4));
				bac.setBU_MOBILE(rs.getString("bu_mobile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return bac;
	}
	
	/**
	 * 分页查询
	 */
	public List<BlogUser> pagelist(PageInfo  info,BlogUser bloguser){
		List<BlogUser> list = new ArrayList<BlogUser>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql="select blog.* from (select b.*,rownum num  from blog_user b  where 1=1 ";
		if(bloguser!=null ){
			if(null!=bloguser.getBU_USER_NAME()&& !"" .equals(bloguser.getBU_USER_NAME()) ){
				sql=" and b.BU_USER_NAME  LIKE ? ";
			}
			if(null!=bloguser.getBU_PASSWORD()&& !"" .equals(bloguser.getBU_PASSWORD()) ){
				sql=" and b.BU_PASSWORD=? ";
			}
			if(null!=bloguser.getBu_user_id()&& !"" .equals(bloguser.getBu_user_id()) ){
				sql="and b.BU_USER_ID=?";
			}
		}
		sql+=" )blog  where blog.num>? and blog.num <=?";
		
		try {
			// 1.建立连接
			conn = Basedao.getConnection();
			// 2.处理预编译SQL语句
			psmt = conn.prepareStatement(sql);
			// 3.给点位符赋值
			int i=1;
			if(bloguser!=null ){
				if(null!=bloguser.getBU_USER_NAME()&& !"" .equals(bloguser.getBU_USER_NAME()) ){
					psmt.setObject(i++, bloguser.getBU_USER_NAME());
				}
				if(null!=bloguser.getBU_PASSWORD()&& !"" .equals(bloguser.getBU_PASSWORD()) ){
					psmt.setObject(i++, bloguser.getBU_PASSWORD());
				}
				if(null!=bloguser.getBu_user_id()&& !"" .equals(bloguser.getBu_user_id()) ){
					psmt.setObject(i++, bloguser.getBu_user_id());
				}
			}
			//begin
			int begin = (info.getCurrPageNo()-1)*info.getPageSize();
			psmt.setObject(i++, begin);
			psmt.setObject(i++, begin+info.getPageSize());
			// 4.执行预编译SQL语句并返回结果集
			rs = psmt.executeQuery();
			// 5.循环遍历
			while (rs.next()) {
				// 创建对象
				BlogUser bac = new BlogUser();
				bac.setBu_user_id(rs.getInt(1));
				bac.setBU_EMAIL(rs.getString(2));
				bac.setBU_USER_NAME(rs.getString(3));
				bac.setBU_SEX(rs.getString(4));
				bac.setBU_MOBILE(rs.getString("bu_mobile"));
				// 把BlogArticleCategory存入list集合中
				list.add(bac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return list;
	}
	
	/**
	 * 获得总条数
	 */
	public int getTotalcount(BlogUser bloguser){
		int count=0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql="select count(*)  from blog_user b  where 1=1 ";
		if(bloguser!=null ){
			if(null!=bloguser.getBU_USER_NAME()&& !"" .equals(bloguser.getBU_USER_NAME()) ){
				sql=" and b.BU_USER_NAME  LIKE ? ";
			}
			if(null!=bloguser.getBU_PASSWORD()&& !"" .equals(bloguser.getBU_PASSWORD()) ){
				sql=" and b.BU_PASSWORD=? ";
			}
			if(null!=bloguser.getBu_user_id()&& !"" .equals(bloguser.getBu_user_id()) ){
				sql="and b.BU_USER_ID=?";
			}
		}
		
		
		try {
			// 1.建立连接
			conn = Basedao.getConnection();
			// 2.处理预编译SQL语句
			psmt = conn.prepareStatement(sql);
			// 3.给点位符赋值
			int i=1;
			if(bloguser!=null ){
				if(null!=bloguser.getBU_USER_NAME()&& !"" .equals(bloguser.getBU_USER_NAME()) ){
					psmt.setObject(i++, bloguser.getBU_USER_NAME());
				}
				if(null!=bloguser.getBU_PASSWORD()&& !"" .equals(bloguser.getBU_PASSWORD()) ){
					psmt.setObject(i++, bloguser.getBU_PASSWORD());
				}
				if(null!=bloguser.getBu_user_id()&& !"" .equals(bloguser.getBu_user_id()) ){
					psmt.setObject(i++, bloguser.getBu_user_id());
				}
			}
			
			// 4.执行预编译SQL语句并返回结果集
			rs = psmt.executeQuery();
			// 5.循环遍历
			rs.next();
			count=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			Basedao.closeA(conn, psmt, rs);
		}
		return count;
	}
	
	
}	
	