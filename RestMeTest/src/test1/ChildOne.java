package test1;

public class ChildOne extends Thread {

	public boolean v = true;

	@Override
	public void run() {

		while (v) {
			System.out.println("child m1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setV() {
		v = false;
	}

}
