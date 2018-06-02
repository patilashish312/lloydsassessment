package app.lloyds.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runners.Suite.SuiteClasses;

public class UfoSightingServiceTest {
	@Test
	public void TestAllsightingpositive() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertEquals("Ufosighting no. are as per expected i.e. 61393",
				61393, service.getAllSightings().size());
		Assert.assertNotSame("Ufosighting no. are as per not matched i.e.",
				61390, service.getAllSightings().size());
	}

	@Test
	public void TestAllsightinegative() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNotSame("Ufosighting no. are as per not matched i.e.",
				61390, service.getAllSightings().size());
	}

	@Test
	public void TestValidfilePathpositive() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNotNull("Valid file path", service.getAllSightings());
	}

	@Test
	public void TestValidfilePathnegative() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertEquals("Invalid path", service.getAllSightings().size(), 0);
	}

	@Test
	public void TestvalidMonthnegative() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNull("Invalid month", service.search(1990, 1000));
	}

	@Test
	public void TestvalidMonthpositive() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNotNull("InValid month", service.search(1990, 12));
	}

	@Test
	public void TestvalidYearnegative() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNull("Valid month", service.search(8888, 1));
	}

	@Test
	public void TestvalidYearpositive() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNotNull("InValid year", service.search(1999, 1));
	}

	@Test
	public void TestexpectedCountforYYMMpos() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertEquals("Count of sighting for October 1995", 107, service
				.search(1995, 10).size());
	}

	@Test
	public void TestexpectedCountforYYMMneg() {
		UfoSightingService service = new UfoSightingServiceImpl();
		Assert.assertNotSame("Count of sighting for December 1990", 107,
				service.search(1990, 12).size());
	}
	
	
	
}
