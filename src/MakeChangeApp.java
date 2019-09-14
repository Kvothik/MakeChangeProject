import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		System.out.println("Enter the total: ");
		double total = kb.nextDouble();
		System.out.println("Enter amount tendered: ");
		double amountTendered = kb.nextDouble();

		makeChange(total, amountTendered);
		kb.close();

	}

	public static void makeChange(double total, double amountTendered) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setCurrency(Currency.getInstance(Locale.US));

		if (amountTendered < total) {
			double additionalAmtReq = total - amountTendered;
			System.out.println("That is not enough, you still need " + nf.format(additionalAmtReq) + ".");
		} else if (amountTendered == total) {
			System.out.println("Exact change given, no change required.");
		} else if (amountTendered > total) {
			currencySorter(total, amountTendered);
		}
	}

	public static void currencySorter(double total, double amountTendered) {

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setCurrency(Currency.getInstance(Locale.US));

		double changeReq = amountTendered - total;

		System.out.println("Your change is: " + nf.format(changeReq) + "\tIt will be given as: ");
		System.out.println("******************************");
		System.out.println("|       JAVA BABE CAFE       |");
		System.out.println("|    --------------------    |");
		System.out.println("|                            |");
		System.out.println("|                            |");
		System.out.println("|                            |");
		System.out.println("|                            |");
		System.out.println("|    Total: " + nf.format(total) + "            |");
		System.out.println("|    Tendered: " + nf.format(amountTendered) + "         |");
		System.out.println("|    Your change is: " + nf.format(changeReq) + "   |");
		System.out.println("|    --------------------    |");
		System.out.println("|     See you next time!     |");
		System.out.println("******************************");

		while (amountTendered > 0) {
			if (changeReq >= 100) {
				int hundred = (int) (changeReq / 100);
				changeReq %= 100;
				System.out.println("$100 bills: " + hundred);
				continue;
			} else if (changeReq >= 50) {
				int fifty = (int) (changeReq / 50);
				changeReq %= 50;
				System.out.println("$50 bills: " + fifty);
				continue;
			} else if (changeReq >= 20) {
				int twenty = (int) (changeReq / 20);
				changeReq %= 20;
				System.out.println("$20 bills: " + twenty);
				continue;
			} else if (changeReq >= 10) {
				int ten = (int) (changeReq / 10);
				changeReq %= 10;
				System.out.println("$10 bills: " + ten);
				continue;
			} else if (changeReq >= 5) {
				int five = (int) (changeReq / 5);
				changeReq %= 5;
				System.out.println("$5 bills: " + five);
				continue;
			} else if (changeReq >= 1) {
				int one = (int) (changeReq / 1);
				changeReq %= 1;
				System.out.println("$1 bills: " + one);
				continue;
			} else if (changeReq >= .25) {
				int quarter = (int) (changeReq / .25 + .0005);
				changeReq %= .25;
				System.out.println("Quarters: " + quarter);
				continue;
			} else if (changeReq >= .1) {
				int dime = (int) (changeReq / .1 + .0005);
				changeReq %= .1;
				System.out.println("Dimes: " + dime);
				continue;
			} else if (changeReq >= .05) {
				int nickel = (int) (changeReq / .05 + .0005);
				changeReq %= .05;
				System.out.println("Nickels: " + nickel);
				continue;
			} else if (changeReq >= .01) {
				int penny = (int) (changeReq / .01 + .0005);
				changeReq %= .01;
				System.out.println("Pennies: " + penny);
				continue;
			}
		}
	}

}
