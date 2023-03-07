package exercise06;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
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
