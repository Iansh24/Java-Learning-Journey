package org.learning.Multithreading15;

///////////////////////********** Object-Level Locking & Class-Level Locking ********///////////////////////

/*
 * LOCKING IN JAVA
 *
 * 1. Object-Level Locking
 * 2. Class-Level Locking
 *
 * Object-Level Locking:
 * ---------------------
 * When synchronized is used with a non-static method,
 * the lock is obtained on the current object (this).
 *
 * Example:
 * HSBCBank bank1 = new HSBCBank();
 * HSBCBank bank2 = new HSBCBank();
 *
 * bank1 -> Lock 1
 * bank2 -> Lock 2
 *
 * Therefore, two different objects have two different locks.
 *
 *
 * Class-Level Locking:
 * --------------------
 * When synchronized is used with a static method,
 * the lock is obtained on the Class object.
 *
 * Example:
 * synchronized static void withdraw() { }
 *
 * The lock is obtained on:
 *
 * HSBCBank.class
 *
 * There is only ONE class-level lock for the entire class.
 */


class HSBCBank {

    static int accountBal = 4000;

    /*
     * ==============================
     * OBJECT-LEVEL LOCKING
     * ==============================
     *
     * Remove static to make this an instance method.
     *
     * The lock will be obtained on the object
     * that calls this method.
     */

    synchronized void objectWithdraw(int withdrawal) {
        accountBal -= withdrawal;
        System.out.println("Object-Level Withdrawal: " + withdrawal);
    }

    synchronized void objectDeposit(int deposit) {
        accountBal += deposit;
        System.out.println("Object-Level Deposit: " + deposit);
    }


    /*
     * ==============================
     * CLASS-LEVEL LOCKING
     * ==============================
     *
     * static + synchronized
     *
     * The lock is obtained on:
     *
     * HSBCBank.class
     *
     * All static synchronized methods of this class
     * share the same class-level lock.
     */

    synchronized static void withdraw(int withdrawal) {
        accountBal -= withdrawal;
        System.out.println("Class-Level Withdrawal: " + withdrawal);
    }

    synchronized static void deposit(int deposit) {
        accountBal += deposit;
        System.out.println("Class-Level Deposit: " + deposit);
    }

    synchronized static void checkBalance() {
        System.out.println("Balance is: " + accountBal);
    }
}


/*
 * ATM
 * Performs withdrawal using CLASS-LEVEL LOCKING.
 */
class Atm extends Thread {

    @Override
    public void run() {
        System.out.println("ATM Thread: Withdrawal");
        HSBCBank.withdraw(4000);
    }
}


/*
 * Google Pay
 * Performs deposit using CLASS-LEVEL LOCKING.
 */
class GooglePay extends Thread {

    @Override
    public void run() {
        System.out.println("Google Pay Thread: Deposit");
        HSBCBank.deposit(4000);
    }
}


/*
 * PhonePe
 * Checks balance using CLASS-LEVEL LOCKING.
 */
class PhonePe extends Thread {

    @Override
    public void run() {
        System.out.println("PhonePe Thread: Balance Checking");
        HSBCBank.checkBalance();
    }
}


public class Threading4 {

    public static void main(String[] args) {

        /*
         * ==============================
         * OBJECT-LEVEL LOCKING EXAMPLE
         * ==============================
         */

        HSBCBank bank1 = new HSBCBank();
        HSBCBank bank2 = new HSBCBank();

        /*
         * bank1 and bank2 are two different objects.
         *
         * Therefore:
         *
         * bank1 -> Lock 1
         * bank2 -> Lock 2
         *
         * Both objects can acquire their own locks.
         */

        bank1.objectWithdraw(500);
        bank2.objectDeposit(1000);


        /*
         * ==============================
         * CLASS-LEVEL LOCKING EXAMPLE
         * ==============================
         *
         * No object is required.
         *
         * We can directly call static methods
         * using the class name.
         */

        Atm atm = new Atm();
        atm.setName("ATM Thread");

        GooglePay googlePay = new GooglePay();
        googlePay.setName("Google Pay Thread");

        PhonePe phonePe = new PhonePe();
        phonePe.setName("PhonePe Thread");


        atm.start();
        googlePay.start();
        phonePe.start();
    }
}


/*
 * ==========================================================
 *                 1. OBJECT-LEVEL LOCKING
 * ==========================================================
 *
 * When synchronized is used on a NON-STATIC method,
 * the lock is obtained on the current object (this).
 *
 *
 * class HSBCBank {
 *
 *     synchronized void withdraw(int amount) {
 *         accountBal -= amount;
 *     }
 *
 *     synchronized void deposit(int amount) {
 *         accountBal += amount;
 *     }
 * }
 *
 *
 * Example:
 *
 * HSBCBank bank1 = new HSBCBank();
 * HSBCBank bank2 = new HSBCBank();
 *
 *
 * There are two different objects:
 *
 * bank1 -> Lock 1
 * bank2 -> Lock 2
 *
 *
 * Therefore:
 *
 * bank1.withdraw();
 *        ↓
 *    Lock 1
 *
 *
 * bank2.withdraw();
 *        ↓
 *    Lock 2
 *
 *
 * Since they have different locks, threads working on
 * different objects can execute simultaneously.
 */


/*
 * ==========================================================
 *                 2. CLASS-LEVEL LOCKING
 * ==========================================================
 *
 * When synchronized is used with a STATIC method:
 *
 * synchronized static void withdraw() { }
 *
 *
 * This is called Class-Level Locking.
 *
 * The lock is obtained on:
 *
 * HSBCBank.class
 *
 *
 * Think of it as:
 *
 *
 *              HSBCBank.class
 *                    |
 *              ONE CLASS LOCK
 *                    |
 *          -----------------------
 *          |          |          |
 *      withdraw()  deposit()  checkBalance()
 *
 *
 * All static synchronized methods of HSBCBank
 * use the same class-level lock.
 *
 *
 * Therefore, even if we create:
 *
 * HSBCBank bank1 = new HSBCBank();
 * HSBCBank bank2 = new HSBCBank();
 *
 * both objects still use the SAME class-level lock
 * when calling static synchronized methods.
 *
 *
 * Also, because these methods are static,
 * we can directly call them using the class name:
 *
 * HSBCBank.withdraw(4000);
 * HSBCBank.deposit(4000);
 * HSBCBank.checkBalance();
 */


/*
 * ==========================================================
 *                      KEY DIFFERENCE
 * ==========================================================
 *
 *
 * OBJECT-LEVEL LOCKING
 *
 * synchronized void method()
 *
 *              ↓
 *
 *        Object Lock
 *
 * bank1 -> Lock 1
 * bank2 -> Lock 2
 *
 *
 *
 * CLASS-LEVEL LOCKING
 *
 * synchronized static void method()
 *
 *              ↓
 *
 *        Class Lock
 *
 * HSBCBank.class -> ONE LOCK
 *
 *
 * ==========================================================
 */