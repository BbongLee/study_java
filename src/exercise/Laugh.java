package exercise;

class SendMessage implements Runnable{
	String message;

	public SendMessage(String message) {
		super();
		this.message = message;
	}
	public void say() {
		System.out.print(message+"   ");
	}
	public void sayNtimes(int n) {
		for(int i=0; i<n;i++) {
			say();
		}
	}
	public void run() {
		sayNtimes(6);
	}
}
public class Laugh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th1 = new Thread(new SendMessage("¾ß"));
		Thread th2 = new Thread(new SendMessage("È£"));
		th1.start();
		th2.start();		
	}

}
