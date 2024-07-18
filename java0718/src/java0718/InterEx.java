package java0718;

public class InterEx {

	public static void main(String[] args) {
		ImplC ic = new ImplC();
		
		InterA ia = ic;
		ia.methodA();
		
		InterB ib = ic;
		ib.methodB();
		
		InterC icc = ic;
		icc.methodC();
		
		

	}

}
