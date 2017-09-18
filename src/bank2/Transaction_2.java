package bank2;

class Account{
	int balance;

	public Account(int balance) {
		super();
		balance = 0;
	} //계조ㅏ 생성자
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public void deposit(int amount) throws InterruptedException { //입금
		balance += amount;
		Thread.sleep(1);
	}
	public void withdraw(int amount) { //출금
		balance -= amount;
	}
	public int getBalance() {
		return balance;
	}

}
public class Transaction_2 implements Runnable{
	private Account acc; //계좌는 보호받아야 해!
	
	public Transaction_2(Account acc) {
		super();
		this.acc = acc;
	}

	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println("입금 전 잔액 : "+acc.getBalance()+"원");
		Transaction_2 tr = new Transaction_2(acc);  //인스턴스객체, 스레드 아님
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
		try {
			acc.deposit(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//acc로 deposit! 
	}

}
