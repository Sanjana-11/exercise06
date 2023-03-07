package exercise06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidURLException extends Exception {
	InvalidURLException(String message) {
		super(message);
	}
}

class NoHistoryFoundException extends Exception {
	public NoHistoryFoundException(String message) {
		super(message);
	}
}

class InvalidPositionException extends Exception {
	public InvalidPositionException(String message) {
		super(message);
	}
}

class BrowserHistory {

	List<String> history = new ArrayList<String>();
	int position = 0;
	String homePage;

	BrowserHistory(String homePage) {
		this.homePage = homePage;
	}

	public void visit(String url) throws InvalidURLException {
		if (url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org")) {
			history.add(url);
			position = position + 1;
		} else {
			throw new InvalidURLException("Invalid url extension");
		}
	}

	public String back(int steps) throws NoHistoryFoundException {
		if ((position - steps) > 0) {
			position = position - steps - 1;
		} else {
			throw new NoHistoryFoundException("No History Found");
		}
		return history.get(position);
	}

	public String forward(int steps) throws NoHistoryFoundException {
		if ((position - steps) < history.size()) {
			position = position + steps;
		} else {
			throw new NoHistoryFoundException("No History Found");
		}
		return history.get(position);
	}

	public String get(int urlPosition) throws InvalidPositionException {
		if (urlPosition < 0) {
			throw new InvalidPositionException("Provide only positive values");
		} else if (position >= this.history.size()) {
			throw new IndexOutOfBoundsException("Invalid position");
		} else {
			for (int i = 0; i < history.size(); i++) {
				if (i == urlPosition) {
					break;
				}
			}
		}
		return history.get(urlPosition - 1);

	}
}

public class Main {
	public static void main(String[] args) {

		String continueOption;

		System.out.println("Enter home page : ");
		Scanner sc = new Scanner(System.in);
		String homePage = sc.nextLine();

		BrowserHistory browser = new BrowserHistory(homePage);

		do {
			System.out.println("1. Visit \n2. Back \n3. Forward \n4. Get");
			System.out.println("Enter your choice");
			Scanner sc1 = new Scanner(System.in);
			int choice = sc1.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("Enter url");
					Scanner sc2 = new Scanner(System.in);
					String url = sc2.nextLine();
					browser.visit(url);
					break;

				case 2:
					System.out.println("Enter steps");
					Scanner sc3 = new Scanner(System.in);
					int backSteps = sc3.nextInt();
					String backUrl = browser.back(backSteps);
					System.out.println(backUrl);
					break;

				case 3:
					System.out.println("Enter steps");
					Scanner sc4 = new Scanner(System.in);
					int forwardSteps = sc4.nextInt();
					String forwardUrl = browser.forward(forwardSteps);
					System.out.println(forwardUrl);

					break;

				case 4:
					System.out.println("Enter position");
					Scanner sc5 = new Scanner(System.in);
					int urlPosition = sc5.nextInt();
					String getUrl = browser.get(urlPosition);
					System.out.println(getUrl);
					break;

				default:
					System.out.println("Invalid choice");
					break;

				}
			} catch (InvalidURLException e) {
				System.out.println(e.getMessage());
			} catch (NoHistoryFoundException e) {
				System.out.println(e.getMessage());
			} catch (InvalidPositionException e) {
				System.out.println(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Something went wrong");
			}

			System.out.println("Do you wish to continue?");
			Scanner sc6 = new Scanner(System.in);
			continueOption = sc6.nextLine();
		} while ("Y".equalsIgnoreCase(continueOption));
	}
}
