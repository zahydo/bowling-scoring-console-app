/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobsity.app.access;

import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class FileReaderTest extends TestCase {
    
    public FileReaderTest(String testName) {
        super(testName);
    }

    /**
     * Test of getData method, of class FileReader.
     */
    public void testGetData() {
        System.out.println("getData");
        FileReader instance = new FileReader("rolls_test.txt");
        HashMap<String, ArrayList<String>> expResult = buildResult();
        HashMap<String, ArrayList<String>> result = instance.getData();
        assertEquals(expResult, result);
    }

    private HashMap<String, ArrayList<String>> buildResult() {
        HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        ArrayList<String> rolls = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            rolls.add("10");
        }
        data.put("Carl", rolls);
        return data;
    }
    
}
