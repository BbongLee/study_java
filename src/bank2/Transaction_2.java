package bank2;

class Account{
	int balance;

	public Account(int balance) {
		super();
		balance = 0;
	} //������ ������
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public void deposit(int amount) throws InterruptedException { //�Ա�
		balance += amount;
		Thread.sleep(1);
	}
	public void withdraw(int amount) { //���
		balance -= amount;
	}
	public int getBalance() {
		return balance;
	}

}
public class Transaction_2 implements Runnable{
	private Account acc; //���´� ��ȣ�޾ƾ� ��!
	
	public Transaction_2(Account acc) {
		super();
		this.acc = acc;
	}

	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println("�Ա� �� �ܾ� : "+acc.getBalance()+"��");
		Transaction_2 tr = new Transaction_2(acc);  //�ν��Ͻ���ü, ������ �ƴ�
		Thread th1 = new Thread(tr);
		th1.start(); //i�� �� �Ա� => ������ ���� - �����ϴ��������� ���ο��� ������ ����!!!!����� ������ ���͹����ٴϤФ�
		tr.run();//i�� �� �Ա� => main������ ����!
		System.out.println("�Ա� �� �ܾ� : "+acc.getBalance()+"��");
	}

	@Override
	public void run() {
		deposit(10000);//�����Ա�
	}

	private void deposit(int i) {
		// TODO Auto-generated method stub
		try {
			acc.deposit(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//acc�� deposit! 
	}

}
