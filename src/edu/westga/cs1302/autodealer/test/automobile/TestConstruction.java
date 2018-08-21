package edu.westga.cs1302.autodealer.test.automobile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.autodealer.model.Automobile;

class TestConstruction {

	private final double DELTA = 0.000001;

	@Test
	void testValidConstruction() {
		Automobile auto = new Automobile("Ford", "Focus", 2008, 108132.2, 6900);

		assertAll(() -> assertEquals("Ford", auto.getMake()), () -> assertEquals("Focus", auto.getModel()),
				() -> assertEquals(2008, auto.getYear()), () -> assertEquals(108132.2, auto.getMiles(), 0.00001),
				() -> assertEquals(6900, auto.getPrice(), 0.00001));

	}

	@Test
	void testNullMake() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile(null, "Focus", 2008, 108132.2, 6900));
	}

	@Test
	void testEmptyMake() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("", "Focus", 2008, 108132.2, 6900));
	}

	@Test
	void testNullModel() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("Ford", null, 2008, 108132.2, 6900));
	}

	@Test
	void testEmptyModel() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("Ford", "", 2008, 108132.2, 6900));
	}

	@Test
	void testYearJustBelowThreshold() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("Ford", "Focus", 1884, 108132.2, 6900));
	}

	@Test
	void testYearAtThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 1885, 108132.2, 6900);
		assertEquals(1885, auto.getYear());
	}

	@Test
	void testYearJustAboveThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 1886, 108132.2, 6900);
		assertEquals(1886, auto.getYear());
	}

	@Test
	void testMileageJustBelowThreshold() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("Ford", "Focus", 2008, -0.1, 6900));
	}

	@Test
	void testMileageAtThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 2008, 0, 6900);
		assertEquals(0, auto.getMiles(), DELTA);
	}

	@Test
	void testMileageJustAboveThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 2008, 0.1, 6900);
		assertEquals(0.1, auto.getMiles(), DELTA);
	}

	@Test
	void testPriceJustBelowThreshold() {
		assertThrows(IllegalArgumentException.class, () -> new Automobile("Ford", "Focus", 2008, 100, -0.01));
	}

	@Test
	void testPriceAtThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 2008, 100, 0);
		assertEquals(0, auto.getPrice(), DELTA);
	}

	@Test
	void testPriceJustAboveThreshold() {
		Automobile auto = new Automobile("Ford", "Focus", 2008, 100, 0.01);
		assertEquals(0.01, auto.getPrice(), DELTA);
	}

}
