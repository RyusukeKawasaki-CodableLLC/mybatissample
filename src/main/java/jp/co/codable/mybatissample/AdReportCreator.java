package jp.co.codable.mybatissample;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.prefs.CsvPreference;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;
import com.github.mygreen.supercsv.io.CsvAnnotationBeanWriter;

public class AdReportCreator {
	private static final Logger logger = LoggerFactory.getLogger(AdReportCreator.class);

	/*
	 * レポート出力
	 */
	public void createReport(List<UserCSV> list) {
		try(	CsvAnnotationBeanWriter<UserCSV> csvWriter = new CsvAnnotationBeanWriter<>(UserCSV.class,
				Files.newBufferedWriter(new File("sample.csv").toPath(), Charset.forName("Windows-31j"),StandardOpenOption.APPEND),
				CsvPreference.STANDARD_PREFERENCE)){
			// ヘッダー行と全レコードデータの書き込み
			csvWriter.writeAll(list);
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//改行をつけたい場合はこのコードを追加する
		/*
		try(BufferedWriter bw  = Files.newBufferedWriter(new File("sample.csv").toPath(), Charset.forName("Windows-31j"),StandardOpenOption.APPEND)){
			bw.newLine();
			bw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

	public void readReport() {
        try (CsvAnnotationBeanReader<UserCSV> csvReader = new CsvAnnotationBeanReader<>(
                UserCSV.class,
                Files.newBufferedReader(new File("sample.csv").toPath(), Charset.forName("Windows-31j")),
                CsvPreference.STANDARD_PREFERENCE)){
            List<UserCSV> list = csvReader.readAll();
            csvReader.close();
        }catch (IOException e) {
			e.printStackTrace();
		}
	}
}
