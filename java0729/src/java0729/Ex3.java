package java0729;

public class Ex3 {

	public static void main(String[] args) {
		
		int x = 100;
		Integer y;
		Integer z = 400;
		y = 100;
		
		x = Integer.parseInt("400");
		y = Integer.valueOf("400");
		if (y.equals(z)) {
			System.out.println("=");
		} else {
			System.out.println("ss");
		}
		
		
		String str = "이것은 자바 대치 예제입니다.";
		String newstr = str.replace("자바", "JAVA");
		System.out.println(newstr);
		if(str==newstr) {
			System.out.println("1");
		}else 
			System.out.println("2");
		
		
	}
	

}
