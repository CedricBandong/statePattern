public class AccountTest {
    public static void main(String[] args) {

        // Set the account into an active state
        Account myAccount = new Account("0520", 1000.0);

        myAccount.activate();

        myAccount.suspend();

        // Activating
        myAccount.activate();

        // Deposit
        myAccount.deposit(1000.0);

        // Withdrawal
        myAccount.withdraw(100.0);

        // Closing
        myAccount.close();

        // Activating
        myAccount.activate();

        // Suspending
        myAccount.suspend();

        // Withdrawal
        myAccount.withdraw(500.0);

        // Deposit
        myAccount.deposit(1000.0);
    }
}