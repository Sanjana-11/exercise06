package exercise06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
