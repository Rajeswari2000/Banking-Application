package com.Rajeswari2000.BankingSystem.Repository;
import java.time.LocalDate;
import java.util.*;
import com.Rajeswari2000.BankingSystem.dto.*;

public class BankAccountsRepository {

	private static BankAccountsRepository bankAccountsRepository;

	private BankAccountsRepository() {

	}

	public static BankAccountsRepository getInstance() {
		if (bankAccountsRepository == null) {
			bankAccountsRepository = new BankAccountsRepository();
			bankAccountsRepository.initialSetup();
			bankAccountsRepository.savingsAccountSetUp();
			bankAccountsRepository.NRIAccountSetUp();
		}
		return bankAccountsRepository;
	}

	/*--------------------> user details <------------------------*/

	private static List<Credentials> userDetails = new ArrayList<>();

	private void initialSetup() {
		userDetails.add(new Credentials(1, "secure"));
		userDetails.add(new Credentials(2, "control"));
	}

	public boolean verifyUser(int id, String password) {
		for (Credentials user : userDetails) {
			if (user.getUserId() == id && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	/*--------------------> add new user <------------------------*/

	private static List<User> newUser = new ArrayList<>();

	public boolean addUser(String firstName, String lastName, String emailId, String phoneNumber, int userId,
			String password) {
		boolean flag = true;
		for (Credentials user : userDetails) {
			if (user.getUserId() == (userId)) {
				flag = false;
			}
		}

		if (flag) {
			userDetails.add(new Credentials(userId, password));
			newUser.add(new User(firstName, lastName, emailId, phoneNumber, userId, password));
			return true;
		}
		return false;
	}

	/*--------------------> account setup <------------------------*/

	private void savingsAccountSetUp() {

		savingsAccountDetails.add(new SavingsAccountRepository("Kumaraguru", "appavu", "M", "9876543212",
				"pamban@gmail.com", 987654321234L, LocalDate.now(), "EZZPR0788",
				"No.66, Kumaran street,Pirapan valasai,Ramanathapuram, 6006476", "Anna Nagar", "PAMANN10180", 99987L,
				10000L, "YCV015678", "TN0593847561029"));

	}

	private void NRIAccountSetUp() {

		nriAccountDetails.add(new NRIAccountRepository("Indira", "Thiyagarajan", "F", "9176066654", "indira@gmail.com",
				789012345678L, LocalDate.now(), "EZZPR8765", "Ohio,USA", "TVK Nagar", "PAMTVK10180", 99988L, 20000L,
				"ETZY654378", "No.10/6, Thillainayagam 2nd street, Vadapalani, Chennai-600065"));

	}

	/*--------------------> create new savings account <------------------------*/

	private List<SavingsAccountRepository> savingsAccountDetails = new ArrayList<>();

	public boolean createNewSavingsAccount(SavingsAccountRepository savingRepository) {

		for (SavingsAccountRepository rep : savingsAccountDetails) {
			if (rep.getAadharNumber().equals(savingRepository.getAadharNumber())
					&& rep.getPanNumber().equals(savingRepository.getPanNumber())) {
				return false;
			}
		}
		savingsAccountDetails.add(savingRepository);
		return true;
	}

	/*--------------------> create new NRI account <------------------------*/

	private List<NRIAccountRepository> nriAccountDetails = new ArrayList<>();

	public boolean createNewNRIAccount(NRIAccountRepository nriRepository) {
		for (NRIAccountRepository nri : nriAccountDetails) {
			if (nri.getAadharNumber().equals(nriRepository.getAadharNumber())
					&& nri.getPanNumber().equals(nriRepository.getPanNumber())) {
				return false;
			}
		}
		nriAccountDetails.add(nriRepository);
		return true;
	}

	/*-------------------->  Money transaction <------------------------*/

	List<Transaction> transaction = new ArrayList<>();

	public boolean moneyTransfer(Long fromACnumber, String fromIFSC, Long toAcNumber, String toIFSC, long amount,
			String fromType, String toType) {
        
		
		if(fromACnumber==toAcNumber) return false;
		CustomerAccounts fromAcc = null;
		CustomerAccounts toAcc = null;
		
		boolean from = false;
		boolean to = false;
		for (CustomerAccounts nri : nriAccountDetails) {
			if (nri.getAccountNumber() == fromACnumber && nri.getIFSCcode().equals(fromIFSC)) {
//				
				fromAcc = nri;
				from = true;
			} else if (nri.getAccountNumber() == toAcNumber && nri.getIFSCcode().equals(toIFSC)) {
				//
				toAcc = nri;
				to = true;
			}
		}

		for (CustomerAccounts rep : savingsAccountDetails) {
			if (rep.getAccountNumber() == fromACnumber && rep.getIFSCcode().equals(fromIFSC)) {
				//rep.setAccountBalance(rep.getAccountBalance() - amount);
				fromAcc = rep;
				from = true;
			} else if (rep.getAccountNumber() == toAcNumber && rep.getIFSCcode().equals(toIFSC)) {
				//rep.setAccountBalance(rep.getAccountBalance() + amount);
				toAcc = rep;
				to = true;
			}
		}
		
		if (fromAcc != null && toAcc != null) {
			if(fromAcc.getAccountBalance() - amount<0) return false;
			fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amount);
			
			toAcc.setAccountBalance(toAcc.getAccountBalance() + amount);
		}
		
		if (from == false || to == false)
			return false;
		transaction.add(
				new Transaction(fromACnumber, fromIFSC, toAcNumber, toIFSC, amount, fromType, toType, LocalDate.now()));
		return true;
	}

	/*-------------------->  View balance <------------------------*/

	public CustomerAccounts viewAccountBalance(String firstName, long accountNumber, String accountType) {

		if (accountType.equalsIgnoreCase("savings")) {
			for (SavingsAccountRepository rep : savingsAccountDetails) {
				if (firstName.equalsIgnoreCase(rep.getFirstName()) && accountNumber == rep.getAccountNumber()) {
					return new CustomerAccounts(rep.getFirstName(), rep.getLastName(), rep.getGender(),
							rep.getPhoneNumber(), rep.getEmailId(), rep.getAadharNumber(), rep.getCreationDate(),
							rep.getPanNumber(), rep.getAddress(), rep.getBranch(), rep.getIFSCcode(),
							rep.getAccountNumber(), rep.getAccountBalance());
				}
			}
		} else if (accountType.equalsIgnoreCase("NRI")) {
			for (NRIAccountRepository nri : nriAccountDetails) {
				if (firstName.equalsIgnoreCase(nri.getFirstName()) && accountNumber == nri.getAccountNumber()) {
					return new CustomerAccounts(nri.getFirstName(), nri.getLastName(), nri.getGender(),
							nri.getPhoneNumber(), nri.getEmailId(), nri.getAadharNumber(), nri.getCreationDate(),
							nri.getPanNumber(), nri.getAddress(), nri.getBranch(), nri.getIFSCcode(),
							nri.getAccountNumber(), nri.getAccountBalance());
				}
			}
		}

		return null;
	}

	/*-------------------->  Withdraw money <------------------------*/

	public CustomerAccounts withdrawAccountMoney(String firstName, long accountNumber, String accountType,
			long amount) {

		if (accountType.equalsIgnoreCase("savings")) {
			for (SavingsAccountRepository rep : savingsAccountDetails) {
				if (firstName.equalsIgnoreCase(rep.getFirstName()) && accountNumber == rep.getAccountNumber()) {
					if (rep.getAccountBalance() > 0 && rep.getAccountBalance() - amount > 0) {
						rep.setAccountBalance(rep.getAccountBalance() - amount);
						return new CustomerAccounts(rep.getFirstName(), rep.getLastName(), rep.getGender(),
								rep.getPhoneNumber(), rep.getEmailId(), rep.getAadharNumber(), rep.getCreationDate(),
								rep.getPanNumber(), rep.getAddress(), rep.getBranch(), rep.getIFSCcode(),
								rep.getAccountNumber(), rep.getAccountBalance());
					} else {
						// model.InsufficientBalance();
					}
				}
			}
		} else if (accountType.equalsIgnoreCase("NRI")) {
			for (NRIAccountRepository nri : nriAccountDetails) {
				if (firstName.equalsIgnoreCase(nri.getFirstName()) && accountNumber == nri.getAccountNumber()) {
					if (nri.getAccountBalance() > 0) {
						nri.setAccountBalance(nri.getAccountBalance() - amount);
						return new CustomerAccounts(nri.getFirstName(), nri.getLastName(), nri.getGender(),
								nri.getPhoneNumber(), nri.getEmailId(), nri.getAadharNumber(), nri.getCreationDate(),
								nri.getPanNumber(), nri.getAddress(), nri.getBranch(), nri.getIFSCcode(),
								nri.getAccountNumber(), nri.getAccountBalance());
					}
				}
			}
		}
		return null;
	}

	/*-------------------->  Deposit Money <------------------------*/

	public CustomerAccounts depositAccountMoney(String firstName, long accountNumber, String accountType, long amount) {

		if (accountType.equalsIgnoreCase("savings")) {
			for (SavingsAccountRepository rep : savingsAccountDetails) {
				if (firstName.equalsIgnoreCase(rep.getFirstName()) && accountNumber == rep.getAccountNumber()) {
					rep.setAccountBalance(rep.getAccountBalance() + amount);
					return new CustomerAccounts(rep.getFirstName(), rep.getLastName(), rep.getGender(),
							rep.getPhoneNumber(), rep.getEmailId(), rep.getAadharNumber(), rep.getCreationDate(),
							rep.getPanNumber(), rep.getAddress(), rep.getBranch(), rep.getIFSCcode(),
							rep.getAccountNumber(), rep.getAccountBalance());
				}
			}
		} else if (accountType.equalsIgnoreCase("NRI")) {
			for (NRIAccountRepository nri : nriAccountDetails) {
				if (firstName.equalsIgnoreCase(nri.getFirstName()) && accountNumber == nri.getAccountNumber()) {
					nri.setAccountBalance(nri.getAccountBalance() + amount);
					return new CustomerAccounts(nri.getFirstName(), nri.getLastName(), nri.getGender(),
							nri.getPhoneNumber(), nri.getEmailId(), nri.getAadharNumber(), nri.getCreationDate(),
							nri.getPanNumber(), nri.getAddress(), nri.getBranch(), nri.getIFSCcode(),
							nri.getAccountNumber(), nri.getAccountBalance());
				}
			}
		}

		return null;
	}

	/*-------------------->  transaction history <------------------------*/
//List<Transaction> transaction = new ArrayList<>();
	List<Transaction> currentCustomerTransaction = new ArrayList<>();

	public List<Transaction> getTranscationHistory(String firstName, long accountNumber, String accountType) {
		for (Transaction t : transaction) {
//			System.out.println(accountNumber);
			if (t.getFromAccountNumber() == accountNumber || t.getToAccountNumber() == accountNumber) {
				currentCustomerTransaction.add(t);
			}
		}
		return currentCustomerTransaction;
	}

	/*-------------------->  get account details <------------------------*/

	public CustomerAccounts getAccountDetails(String firstName, String phoneNumber) {

		for (SavingsAccountRepository rep : savingsAccountDetails) {
			if (rep.getFirstName().equalsIgnoreCase(firstName) && rep.getPhoneNumber().equals(phoneNumber)) {
				return new CustomerAccounts(rep.getFirstName(), rep.getLastName(), rep.getGender(),
						rep.getPhoneNumber(), rep.getEmailId(), rep.getAadharNumber(), rep.getCreationDate(),
						rep.getPanNumber(), rep.getAddress(), rep.getBranch(), rep.getIFSCcode(),
						rep.getAccountNumber(), rep.getAccountBalance());
			}
		}

		for (NRIAccountRepository nri : nriAccountDetails) {
			if (nri.getFirstName().equalsIgnoreCase(firstName) && nri.getPhoneNumber().equals(phoneNumber)) {
				return new CustomerAccounts(nri.getFirstName(), nri.getLastName(), nri.getGender(),
						nri.getPhoneNumber(), nri.getEmailId(), nri.getAadharNumber(), nri.getCreationDate(),
						nri.getPanNumber(), nri.getAddress(), nri.getBranch(), nri.getIFSCcode(),
						nri.getAccountNumber(), nri.getAccountBalance());
			}
		}

		return null;
	}

}
