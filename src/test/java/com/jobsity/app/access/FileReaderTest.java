package com.jobsity.app.access;

import com.jobsity.app.util.Utils;
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
        HashMap<String, ArrayList<String>> expResult = Utils.getTestData();
        HashMap<String, ArrayList<String>> result = instance.getData();
        assertEquals(expResult, result);
    }
}
