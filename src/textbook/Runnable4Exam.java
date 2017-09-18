package textbook;

class Top4 implements Runnable{
	public void run() {
		for(int i=0;i<30;i++) {
			System.out.print((Thread.currentThread()).getName()+i+"\t");
		}
	}
	
}
public class Runnable4Exam {

	public static void main(String[] args) {
		System.out.println("프로그램 시작 !");
		Top4 t = new Top4();
		Thread t1 = new Thread(t, "a");
		Thread t2 = new Thread(t, "b");
		
		t1.setName("new_a");
		t2.setName("new_b");
		t1.setPriority(9);
		t2.setPriority(t2.MIN_PRIORITY);//1
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		System.out.println("프로그램 종료");
	}

}
