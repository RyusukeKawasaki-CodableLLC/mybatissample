package jp.co.codable.mybatissample;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CsvBean(header=true)
public class UserCSV {
    @CsvColumn(number=1,label=" ID")
    private int id;
    @CsvColumn(number=2, label="名前")
    private String name;
}
