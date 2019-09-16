package com.bdqn.appinfosb.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class MDUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encodedByMd5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String pwd = "123456";
        System.out.println(MDUtils.EncodedByMd5(pwd));
    }
}