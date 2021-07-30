package com.example.songr;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.result.ContentResultMatchers;
//import org.springframework.test.web.servlet.result.StatusResultMatchersDsl;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SongrApplicationTests {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnDefaultMessage() throws Exception {
            this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Hello World !!")));
        }

//	Album test= new Album();
//	Album egyptRomance= new Album("egyptRomance","Mohamed Hamaki","58 songs","3 hr 44 min","https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093");
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	public  void testEmptyConstructor(){
//		Assertions.assertNull(test.getArtist());
//	}
//	@Test
//	public  void testConstructor(){
//		Assertions.assertNotNull(egyptRomance.getArtist());
//		Assertions.assertEquals("egyptRomance",egyptRomance.getTitle());
//		Assertions.assertEquals("Mohamed Hamaki",egyptRomance.getArtist());
//		Assertions.assertEquals("58 songs",egyptRomance.getSongCount());
//		Assertions.assertEquals("3 hr 44 min",egyptRomance.getLength());
//		Assertions.assertEquals("https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093",egyptRomance.getImageUrl());
//	}

}
