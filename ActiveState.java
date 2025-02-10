public class ActiveState implements AccountState {
    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. " + account.toString());
    }

    @Override
    public void withdraw(Account account, double amount) {

        Runnable successfulWithdrawal = new Runnable() {
            @Override
            public void run() {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Successful withdrawal. " + account.toString());
            }
        };

        Runnable insufficientBalance = new Runnable() {
            @Override
            public void run() {
                System.out.println("Insufficient balance.");
            }
        };

        Runnable[] actions = new Runnable[] {
                insufficientBalance, // index 0 for insufficient balance
                successfulWithdrawal // index 1 for successful withdrawal
        };

        actions[account.getBalance() >= amount ? 1 : 0].run();
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account activated");
    }

    @Override
    public void suspend(Account account) {
        account.setAccountState(new SuspendedState());
        System.out.println("Account suspended");
    }

    @Override
    public void close(Account account) {
        account.setAccountState(new ClosedState());
        System.out.println("Account closed");
    }
}