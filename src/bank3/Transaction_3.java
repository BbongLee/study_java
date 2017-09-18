package bank3;

class Account_3{
	int balance;

	public Account_3(int balance) {
		super();
		balance = 0;
	} //계조ㅏ 생성자
	public Account_3() {
		// TODO Auto-generated constructor stub
	}
	public synchronized void deposit(int amount) { //입금
		balance += amount;
	} //입금 접근할때 동기화 해줘!
	public void withdraw(int amount) { //출금
		balance -= amount;
	}
	public int getBalance() {
		return balance;
	}

}
public class Transaction_3 implements Runnable{
	private Account_3 acc; //계좌는 보호받아야 해!
	
	public Transaction_3(Account_3 acc) {
		super();
		this.acc = acc;
	}

	public static void main(String[] args) {
		Account_3 acc = new Account_3();
		System.out.println("입금 전 잔액 : "+acc.getBalance()+"원");
		Transaction_3 tr = new Transaction_3(acc);  //인스턴스객체, 스레드 아님
		Thread th1 = new Thread(tr);
		th1.start(); //i의 값 입금 => 스레드 동작 - 동작하던지말던지 메인에서 관심이 없음!!!!결과가 만원이 나와버리다니ㅠㅠ
		tr.run();//i의 값 입금 => main스레드 동작!
		System.out.println("입금 후 잔액 : "+acc.getBalance()+"원");
	}

	@Override
	public void run() {
		deposit(10000);//만원입금
	}

	private void deposit(int i) {
		// TODO Auto-generated method stub
		acc.deposit(i);
	}

}

