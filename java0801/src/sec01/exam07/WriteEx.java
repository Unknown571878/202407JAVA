package sec01.exam07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteEx {

	public static void main(String[] args) throws IOException {
		Writer os = new FileWriter("C:/Temp/test7.txt");
		
		String str = "ABC";
		os.write(str);
		
//		char a = 'A';
//		char b = 'B';
//		char c = 'C';
//		
//		os.write(a);
//		os.write(b);
//		os.write(c);
		

	}

}
