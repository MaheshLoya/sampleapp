package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestOne {

	public static void main(String args[]) {

		TreeSet<String> inputData = new TreeSet<String>(Collections.reverseOrder());
		int numLines = 0;
	
		try {
			
			
			Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));

			while (in.hasNextLine()) {
				String line = in.nextLine();

				if (!line.isEmpty()) {
					String[] strngArray = line.split(",");
					
					inputData.add(strngArray[2]+","+strngArray[1]+","+strngArray[0]);
					
		
				}

			}
			
			inputData.stream().forEach(System.out::println);
			
			Set<String> myset=makeit(inputData);
			
			/* PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			 myset.stream().forEach(output::println);*/
	          
			myset.stream().forEach(System.out::println);
			
			in.close();
			//output.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	public static Set makeit(Set<String> setinput) {
		
		Set<String> set = new HashSet();
		HashMap<String, Integer> hm1 = new HashMap<>();
		for(String line:setinput) {
			String[] strngArray=Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
		
		
		if (hm1.containsKey(strngArray[1].trim())) {

			if (hm1.get(strngArray[1].trim()).intValue() > Integer
					.valueOf(strngArray[0].trim().substring(1)).intValue()) {
				hm1.put(strngArray[1].trim(),
						Integer.valueOf(strngArray[0].trim().substring(1)).intValue());
				set.add(strngArray[2].trim());

			}

		} else {
			hm1.put(strngArray[1].trim(), Integer.valueOf(strngArray[0].trim().substring(1)).intValue());
		}
		}
		
		return set;
	}
	


}
