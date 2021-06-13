package com.jobsity.app;

import java.util.ArrayList;
import java.util.HashMap;

import com.jobsity.app.access.DataAccessInterface;
import com.jobsity.app.access.FileReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DataAccessInterface<HashMap<String, ArrayList<Integer>>> access = new FileReader();
        HashMap<String, ArrayList<Integer>> result = access.getData();
        System.out.println(result);
    }
}
