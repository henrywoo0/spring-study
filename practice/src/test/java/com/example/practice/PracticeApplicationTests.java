package com.example.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {

		System.out.println("Hello");

		// Object Mapper
		// Text JSON -> Object
		// Object -> Text JSON

		// controller request json(text) -> object
		// response object -> json(text)

		var objectMapper = new ObjectMapper();

		// object -> text
		var user = new User("steve", 10, "010-1111-2222");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);
		// Object 가 text 로 바뀔 때 Object mapper 는 get method 를 활용한다.
		// 기본적인 get method 말고 사용자가 다른 get 메서드를 만들었을 때 오류가 난다.


		// text -> object
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
		// object mapper 는 default 생성자를 필요로 한다.

	}

}
