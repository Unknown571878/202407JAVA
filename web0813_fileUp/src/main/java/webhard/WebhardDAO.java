package webhard;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class WebhardDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	public WebhardDAO() {
		session = sqlsession_f.openSession(true);
	}
	public Webhard getWebhardbyid(int id) {
		return session.selectOne("WebhardMapper.selectwebhardById", id);
	}
	public void addWebhard(Webhard webhard) {
		session.insert("WebhardMapper.insertWebhard", webhard);
	}
	public void updatewebhard(Webhard webhard) {
		session.update("WebhardMapper.updatewebhard", webhard);
	}
	public void deletewebhard(int id) {
		session.delete("WebhardMapper.deletewebhard", id);
	}
	
}
