package p299;

public class ClassName {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	static void method3() {
		ClassName className = new ClassName();
		className.field1 = 10;
		className.method1();
		field2 = 10;
		method2();
	}
}
