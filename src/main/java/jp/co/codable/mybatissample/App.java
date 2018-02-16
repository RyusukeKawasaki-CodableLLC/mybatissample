package jp.co.codable.mybatissample;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

		try(	InputStream inputStream = Resources.getResourceAsStream(resource)) {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			try(	SqlSession session = sqlSessionFactory.openSession()){
				UserMapper mapper = session.getMapper(UserMapper.class);
                mapper.selectAll().forEach(s -> {
                    System.out.println(s.getId());
                    System.out.println(s.getName());
                });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		AdReportCreator adRepoCreator = new AdReportCreator();
		// 書き込み用のデータの作成
		List<UserCSV> list = new ArrayList<>();
		UserCSV record1 = new UserCSV();
		record1.setId(1);
		record1.setName("山田太郎");
		list.add(record1);

		UserCSV record2 = new UserCSV();
		record2.setId(2);
		record2.setName("aiueo");
		list.add(record2);
		//書き込み
		//adRepoCreator.createReport(list);
		//読み込み
		//adRepoCreator.readReport();
	}
}
