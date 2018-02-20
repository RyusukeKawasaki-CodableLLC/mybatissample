package jp.co.codable.MybatisSample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import jp.co.codable.mybatissample.Greator;

public class GreatorTest {
	private Greator greator = new Greator();

	@Test
	public void getMessageHi() {
		String message = this.greator.getMessage(10);
		assertThat(message, is("Hi"));
	}

	@Test
	public void getMessageHello() {
		String message = this.greator.getMessage(13);
		assertThat(message, is("Hello"));
	}

}
