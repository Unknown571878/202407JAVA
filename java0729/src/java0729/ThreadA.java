package java0729;

public class ThreadA extends Thread {

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
	public ThreadA() {
		this.setName("ThreadA");
	}
}
