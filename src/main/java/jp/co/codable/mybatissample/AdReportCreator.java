package jp.co.codable.mybatissample;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.prefs.CsvPreference;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanWriter;

public class AdReportCreator {
	private static final Logger logger = LoggerFactory.getLogger(AdReportCreator.class);

	public void createReport() {
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
		try(	CsvAnnotationBeanWriter<UserCSV> csvWriter = new CsvAnnotationBeanWriter<>(UserCSV.class,
				Files.newBufferedWriter(new File("sample.csv").toPath(), Charset.forName("Windows-31j")),
				CsvPreference.STANDARD_PREFERENCE)){
			// ヘッダー行と全レコードデータの書き込み
			csvWriter.writeAll(list);
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
