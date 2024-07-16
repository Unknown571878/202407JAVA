package java0716;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Cat {
	private String breed;
	private String color;
	private int age = 10;

//	Cat() {
//		System.out.println("Cat()");
//	}
//
//	public Cat(String breed) {
////		super();
////		this.breed = breed;
//		this(breed, "흰색", 10);
//	}
//
//	public Cat(String breed, String color) {
////		super();
////		this.breed = breed;
////		this.color = color;
//		this(breed, color, 10);
//	}
//
//	public Cat(String breed, String color, int age) {
//		super();
//		this.breed = breed;
//		this.color = color;
//		if (age > 9) {
//			this.age = age;
//		}
//	}
//
//	Cat(int age) { // 생성자
//	}

	
	
}
