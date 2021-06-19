package com.tundra;

import java.io.IOException;
import org.testng.annotations.Test;

public class DictionaryTest {

	@Test
	public void isEnglishWord_Positive() throws IOException {
		Dictionary.isEnglishWord("working");
	}
}
