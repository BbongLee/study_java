package bank3;

class Account_3{
	int balance;

	public Account_3(int balance) {
		super();
		balance = 0;
	} //������ ������
	public Account_3() {
		// TODO Auto-generated constructor stub
	}
	public synchronized void deposit(int amount) { //�Ա�
		balance += amount;
	} //�Ա� �����Ҷ� ����ȭ ����!
	public void withdraw(int amount) { //���
		balance -= amount;
	}
	public int getBalance() {
		return balance;
	}

}
public class Transaction_3 implements Runnable{
	private Account_3 acc; //���´� ��ȣ�޾ƾ� ��!
	
	public Transaction_3(Account_3 acc) {
		super();
		this.acc = acc;
	}

	public static void main(String[] args) {
		Account_3 acc = new Account_3();
		System.out.println("�Ա� �� �ܾ� : "+acc.getBalance()+"��");
		Transaction_3 tr = new Transaction_3(acc);  //�ν��Ͻ���ü, ������ �ƴ�
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
		acc.deposit(i);
	}

}

