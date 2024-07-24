package iterator2;

import java.util.Iterator;


public class StudentList implements Iterable<Student>{

	private Student[] student;
	private int last = 0;
	@Override
	public Iterator<Student> iterator() {
		return new StudentIterator(this);
	}
	public StudentList(int maxsize) { // 생성자
		this.student = new Student[maxsize];
	}
	public Student getStudent(int index) { // 해당 인덱스의 책을 리턴
		return student[index];
	}
	public void appendStudent(Student student) { // 책을 추가
		this.student[last] = student;
		last++;
	}
	public int getLenght() { // 책들의 총 건수
		return last;
	}
}
