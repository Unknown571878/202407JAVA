package sec06.exam03.package2;

import sec06.exam03.package1.A;
import sec06.exam03.package1.B;

public class C {
	A a; 
	B b;
	void method() {
		a.x = 200;// default 접근제어자는 패키지가 달라서 접근 불가하다.
	}
}
