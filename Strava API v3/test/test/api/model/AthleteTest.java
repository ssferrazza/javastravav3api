package test.api.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import stravajava.api.v3.model.StravaAthlete;

/**
 * @author dshannon
 *
 */
public class AthleteTest {

	@Test
	public void test() {
		new BeanTester().testBean(StravaAthlete.class);
	}

	@Test
	public void testEqualsMethod() {
		EqualsVerifier.forClass(StravaAthlete.class).suppress(Warning.STRICT_INHERITANCE,Warning.NONFINAL_FIELDS).verify();
	}
}