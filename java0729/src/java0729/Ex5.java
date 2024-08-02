package java0729;

public class Ex5 {

	public static void main(String[] args) {
		Thread mThread = Thread.currentThread();
		System.out.println(mThread.getName());
		
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		Thread threadB = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i<2; i++) {
					System.out.println(getName());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		};
		threadB.setName("ThreadB");
		threadB.start();
		
		Thread threadC = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i<2; i++) {
					System.out.println("threadC");
				}
				
			}
		});
		threadC.setName("threadC");
		threadC.start();
	}

}
