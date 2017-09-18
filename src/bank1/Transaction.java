package bank1;
//�⺻
class Account{
	int balance;

	public Account(int balance) {
		super();
		balance = 0;
	} //������ ������
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public void deposit(int amount) { //�Ա�
		balance += amount;
	}
	public void withdraw(int amount) { //���
		balance -= amount;
	}
	public int getBalance() {
		return balance;
	}

}
public class Transaction implements Runnable{
	private Account acc; //���´� ��ȣ�޾ƾ� ��!
	
	public Transaction(Account acc) {
		super();
		this.acc = acc;
	}

	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println("�Ա� �� �ܾ� : "+acc.getBalance()+"��");
		Transaction tr = new Transaction(acc);  //�ν��Ͻ���ü, ������ �ƴ�
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

