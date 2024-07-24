package java0723;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	static class B {
		void method() {
//			field1 = 10;
//			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	public static void main(String[] args) {
		A.B b = new A.B(); // static이 있으면 A클래스가 생성되지 않아도 A클래스 내부의 B클래스를 생성할 수 있음
//		System.out.println(A.field2);
//		System.out.println(field1);
//		A a = new A();
//		System.out.println(a.field1);
//		A.B b = a.new B();
//		b.method();
	}
}
