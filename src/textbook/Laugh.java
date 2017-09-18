package textbook;

class SendMessage extends Thread{
	String message;

	public SendMessage(String message) {
		super();
		this.message = message;
	}
	public void say() {
		System.out.print(message+"   ");
	}
	public void sayNtimes(int n) throws InterruptedException {
		for(int i=0; i<n;i++) {
			say();
			Thread.sleep(1000); //1�ʰ�  �� �� �� !!
		}
	}
	public void run() {
		try {
			sayNtimes(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Laugh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendMessage s1 = new SendMessage("¥");
		SendMessage s2 = new SendMessage("��");
		SendMessage s3 = new SendMessage("��");
		
		s1.start();
		s2.start();		
		s3.start();
	}

}
