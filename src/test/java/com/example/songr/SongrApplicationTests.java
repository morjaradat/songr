package com.example.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {
	Album test= new Album();
	Album egyptRomance= new Album("egyptRomance","Mohamed Hamaki","58 songs","3 hr 44 min","https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093");

	@Test
	void contextLoads() {
	}

	@Test
	public  void testEmptyConstructor(){
		Assertions.assertNull(test.getArtist());
	}
	@Test
	public  void testConstructor(){
		Assertions.assertNotNull(egyptRomance.getArtist());
		Assertions.assertEquals("egyptRomance",egyptRomance.getTitle());
		Assertions.assertEquals("Mohamed Hamaki",egyptRomance.getArtist());
		Assertions.assertEquals("58 songs",egyptRomance.getSongCount());
		Assertions.assertEquals("3 hr 44 min",egyptRomance.getLength());
		Assertions.assertEquals("https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093",egyptRomance.getImageUrl());
	}

}
