package java0729;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex4 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strNow = sdf.format(date);
		System.out.println(strNow);
		
		LocalDateTime now1 = LocalDateTime.now();
		String strNum1 = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(now1);
		System.out.println(strNum1);
		
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		String strNow1 = sdf.format(now2);
		System.out.println(strNow1);
		
	}

}
