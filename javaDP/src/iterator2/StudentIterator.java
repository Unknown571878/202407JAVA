package iterator2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentIterator implements Iterator<Student>{
	
	private StudentList studentLists;
	private int index;
	
	

	public StudentIterator(StudentList studentLists) {
		super();
		this.studentLists = studentLists;
		this.index = 0;
	}
	@Override
	public boolean hasNext() { // 다음 책이 있나요
		if (index < studentLists.getLenght()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Student next() { // 다음 책을 가져올 때
		if (!hasNext()) {
			throw new NoSuchElementException(); // 예외 발생
		}
		Student student = studentLists.getStudent(index);
		index++;
		return student;
	}

}
