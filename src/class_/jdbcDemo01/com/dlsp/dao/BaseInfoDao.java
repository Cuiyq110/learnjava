package com.dlsp.dao;

import java.util.List;

import com.dlsp.pojo.BaseInfo;

public interface BaseInfoDao {
	
	//获取所有的
	List<BaseInfo> getAllBaseInfo();
	
	//根据主键查询
	BaseInfo getBaseInfoByQQid(long qqid);
	
	//按照昵称
	List<BaseInfo> getBaseInfoByNickName(String nickName);
	

}
