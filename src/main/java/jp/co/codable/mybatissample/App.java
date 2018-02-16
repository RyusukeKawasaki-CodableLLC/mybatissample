package jp.co.codable.mybatissample;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facebook.ads.sdk.APIException;

/**
 * Hello world!
 *
 */
public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String args[]) throws APIException {
        logger.info("Hello Logback!!");

        // resources直下のmybatis-config.xmlを読み込みます(1)
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

          // SQLセッションを取得します(3)
		  session = sqlSessionFactory.openSession();
		  String s = (String) session.selectOne("jp.co.codable.mybatissample.UserMapper.selectBlog", 101);
		  System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  session.close();
		}

		AdReportCreator adRepoCreator = new AdReportCreator();
		adRepoCreator.createReport();
	}
}
