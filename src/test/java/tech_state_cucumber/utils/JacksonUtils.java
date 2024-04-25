/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

/***************************************************/

package tech_state_cucumber.utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

	public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(is, T);
	}
}
