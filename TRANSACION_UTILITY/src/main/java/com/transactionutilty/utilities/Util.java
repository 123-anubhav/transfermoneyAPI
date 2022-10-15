package com.transactionutilty.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;

import com.transactionutilty.entity.Account;
import com.transactionutilty.entity.Transfer;
import com.transactionutilty.entity.repository.IAccount;

@EnableTransactionManagement
public class Util implements Runnable {

	// @Autowired
	static com.transactionutilty.entity.repository.ITransfer itransfer;

	public static com.transactionutilty.entity.repository.ITransfer getItransfer() {
		return itransfer;
	}

	@Autowired
	public static void setItransfer(com.transactionutilty.entity.repository.ITransfer itransfer) {
		Util.itransfer = itransfer;
	}

	@Autowired
	EmailSenderService senderservice;

	// @Autowired
	// Util utilObj;

	@Autowired
	IAccount iaccount;

	// @Autowired
	static Transfer money;

	Account toAccaccount;

	// Getting Balance information from sender's bank

	String flag = new String("null");
	String result = null;

	// simple email calling
	@EventListener(ApplicationReadyEvent.class)
	public String sendMail() {

		if (flag.equals("success")) {

			senderservice.sendMail("anubhav.aa2@gmail.com", "transfer money via paytm ",
					"money transaction successful of rupee " + money.getAmountfromAcc());

			return "transaction success";
		} else
			return "failed transaction so can not send mail";
	}

	

	@Override
	public String toString() {
		return "Util [itransfer=" + itransfer + ", senderservice=" + senderservice + ", iaccount=" + iaccount
				+ ", money=" + money + ", toAccaccount=" + toAccaccount + ", flag=" + flag + ", result=" + result + "]";
	}

	public Transfer fundTransfer(/* @Value("${money}") */ Transfer money, Account toAccaccount) {

		this.money = money;
		this.toAccaccount = toAccaccount;

		// use setter getter for outer obj data access

		System.out.println("\n=========  util method call execute ===========\n" + money.toString() + "\n this.money : "
				+ this.money.toString());

		Util utilThreadObj = new Util();
		Thread t1 = new Thread(utilThreadObj);
		t1.start();
		System.out.println("\n ========  after thread call ========\n");
		try {
			if (flag == null)
				System.out.println("flag is null that's throw exception null pointer exception " + flag);
			else {
				boolean bflag = flag.equals("success");
				System.out.println("bflag is " + bflag);
				if (bflag)
					sendMail();
				// sendMailwithAttahcment();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return result == null ? "null" : result;
		return this.money;
	}

	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.NESTED)
	@Override
	public synchronized void run() {

		System.out.println("\n=========  run method call execute ===========\n");

		try {
			
			System.out.println("money is : " + money.toString());
		} catch (Exception e) {
			System.out.println("line number 125 catch exception execute in Util class");
			e.printStackTrace();
		}

		double totalAmountFromAcc = 0.0;
		double transferAmount = 0.0;
		double totalAmountToAcc = 0.0;
		double beforeTransactionAmount = 0.0;
		try {
			totalAmountToAcc = money.getToAccAmount();

		
			totalAmountFromAcc = money.getFromAccTotalAmount();
			;
			transferAmount = money.getAmountfromAcc(); 

		} catch (Exception e) {
			System.out.println("line number 139 catch exception execute in Util class ");
			e.printStackTrace();
		}

		beforeTransactionAmount = totalAmountFromAcc + totalAmountToAcc; 
		if (totalAmountFromAcc >= transferAmount) {

			totalAmountFromAcc -= transferAmount; 
			totalAmountToAcc += transferAmount; 
		} else {
			System.out.println("insuffiecient balance can not transfer money");
		}
		double afterTransactionAmount = totalAmountFromAcc + totalAmountToAcc;

		if (beforeTransactionAmount == afterTransactionAmount) {
			System.out.println("run method if condition execute flag is success\n money data is : " + money.toString());

			money.setFromAccTotalAmount(totalAmountFromAcc);
			money.setToAccAmount(totalAmountToAcc);
			flag = new String("success");
			itransfer.save(money);


		}
	}
}
