package com.springboot.chapter.controller;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;


@SpringBootTest
public class ProductControllerTest {
	
	int x=0;
	
	

	@Test
	public void test() {
		assertEquals(9, 100);
	}

}
