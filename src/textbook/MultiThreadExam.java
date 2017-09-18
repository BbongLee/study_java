package textbook;

class Summing{
	private int sum;
	public synchronized void sumTo(int num) {
		sum=0;
		for(int i=1; i<=num;i++) {
			sum+=i;
			System.out.print("스레드 : "+Thread.currentThread().getName());
			System.out.print("의 1~"+i+"까지 합은 "+sum+"\n");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
	public int getSum() {return sum;}	
}
public class MultiThreadExam extends Thread{
	private Summing sum;
	private int num;
	
	public MultiThreadExam(String s,Summing sum, int num) {
		super(s);
		this.sum = sum;
		this.num = num;
		System.out.println("스레드 : "+getName()+"가 시작됨");
	}
	
	public void run() {
		sum.sumTo(num);
		System.out.println("스레드 : "+getName()+"가 종료됨");
	}

	public static void main(String[] args) {
		Summing sum = new Summing();
		MultiThreadExam a = new MultiThreadExam("A",sum,5);
		MultiThreadExam b = new MultiThreadExam("B",sum,5);
		a.setPriority(8);
		b.setPriority(10);
		a.start();
		b.start();
	}
}
