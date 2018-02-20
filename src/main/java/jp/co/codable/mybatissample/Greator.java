package jp.co.codable.mybatissample;

public class Greator {
	public String getMessage(int hour) {
		if (hour < 12) {
			return "Hi";
		}else {
			return "Hello";
		}
	}

	public String hogehoge() {
		return "abc";
	}
}
