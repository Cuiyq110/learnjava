package com.dlsp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dlsp.dao.BaseDao;
import com.dlsp.dao.BaseInfoDao;
import com.dlsp.pojo.BaseInfo;

@SuppressWarnings("all")
public class BaseInfoDaoImpl extends BaseDao implements BaseInfoDao {

	@Override
	public List<BaseInfo> getAllBaseInfo() {
		List<BaseInfo> list = new ArrayList<BaseInfo>();
		String sql = "select * from  BaseInfo";
		
		ResultSet rs = super.query(sql, null);
		if(rs != null) {
			try {
				while(rs.next()) {
					BaseInfo info = new BaseInfo(rs.getLong(1), rs.getString(2), rs.getInt(3),
							rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					list.add(info);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				super.closeAll(null, null, rs);
			}
		}
		return list;
	}

	@Override
	public BaseInfo getBaseInfoByQQid(long qqid) {
		BaseInfo baseInfo = null;
		String sql = "select * from  BaseInfo  where qqid = ?";
		Object[]obj = {qqid};
		ResultSet rs = super.query(sql, obj);
		if(rs != null) {
			try {
				if(rs.next()) {
					baseInfo = new BaseInfo(rs.getLong(1), rs.getString(2), rs.getInt(3),
							rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				super.closeAll(null, null, rs);
			}
		}
		return baseInfo;
	}

	@Override
	public List<BaseInfo> getBaseInfoByNickName(String nickName) {
		List<BaseInfo> list = new ArrayList<BaseInfo>();
		String sql = "select * from BaseInfo where nickName  like ?";
		Object[] obj = {"%" + nickName + '%'};
		ResultSet rs = super.query(sql, obj);
		if(rs != null) {
			try {
				while(rs.next()) {
					BaseInfo info = new BaseInfo(rs.getLong(1), rs.getString(2), rs.getInt(3),
							rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					list.add(info);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				super.closeAll(null, null, rs);
			}
		}
		return list;
		
	}

}
