package class_.jdbcDemo01.com.dlsp.test;

import java.util.List;



import com.dlsp.dao.BaseDao;
import com.dlsp.dao.BaseInfoDao;
import com.dlsp.dao.impl.BaseInfoDaoImpl;
import com.dlsp.pojo.BaseInfo;
import org.junit.Test;

public class TestBaseInfo {
	
	private BaseInfoDao dao = new BaseInfoDaoImpl();
	

	@Test
	public void getAll() {
		List<BaseInfo> list = dao.getAllBaseInfo();
		for (BaseInfo baseInfo : list) {
			System.out.println(baseInfo);
		}
	}
	
	
	@Test
	public void getOne() {
		BaseInfo info = dao.getBaseInfoByQQid(111222);
		System.out.println(info);
	}
	
	
	@Test
	public void getLike() {
		List<BaseInfo> list = dao.getBaseInfoByNickName("鱼");
		for (BaseInfo baseInfo : list) {
			System.out.println(baseInfo);
		}
	}

	@Test
	public void test() {
		BaseDao baseDao = new BaseDao();
		baseDao.getConnection();
	}

}
