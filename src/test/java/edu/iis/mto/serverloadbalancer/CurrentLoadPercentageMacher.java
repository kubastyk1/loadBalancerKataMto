package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMacher extends TypeSafeMatcher<Server> {

	private double expectedLoadPercentage;

	public CurrentLoadPercentageMacher(double expectedLoadPercentage) {
		this.expectedLoadPercentage = expectedLoadPercentage;
	}

	public void describeTo(Description description) {
		description.appendText("a server with load percentage of ").appendValue(expectedLoadPercentage);
	}

	@Override
	protected boolean matchesSafely(Server server) {
		return doubleAreEqual(expectedLoadPercentage, server.currentLoadPercentage);
	}

	private boolean doubleAreEqual(double d1, double d2) {
		return d1 == d2 || Math.abs(d1 - d2) < 0.01d;
	}

	public static CurrentLoadPercentageMacher hasCurrentLoadOf(double expectedLoadPercentage) {
		return new CurrentLoadPercentageMacher(expectedLoadPercentage);
	}
}
