package edu.westga.cs1302.autodealer.model;

/**
 * The class Automobile.
 * 
 * @author CS1302
 */
public class Automobile {
	private static final String INVALID_PRICE = "price must be >= 0.";
	private static final String INVALID_MILES = "miles must be >= 0.";
	private static final String INVALID_YEAR = "year must be >= 1885.";
	private static final String MODEL_CANNOT_BE_EMPTY = "model cannot be empty.";
	private static final String MODEL_CANNOT_BE_NULL = "model cannot be null.";
	private static final String MAKE_CANNOT_BE_EMPTY = "make cannot be empty.";
	private static final String MAKE_CANNOT_BE_NULL = "make cannot be null.";
	
	private String make;
	private String model;
	private int year;
	private double miles;
	private double price;

	/**
	 * Instantiates a new Automobile.
	 *
	 * @precondition make != null && make is not empty; model != null && model is
	 *               not empty year >= LOWER_BOUND_YEAR; miles >= 0; price >= 0
	 * @postcondition getMake() == make; getModel() == model; getYear() == year;
	 *                getMiles() == miles; getPrice() == price
	 * 
	 * @param make  the make
	 * @param model the model
	 * @param year  the year
	 * @param miles the miles
	 * @param price the price
	 */
	public Automobile(String make, String model, int year, double miles, double price) {
		if (make == null) {
			throw new IllegalArgumentException(MAKE_CANNOT_BE_NULL);
		}

		if (make.isEmpty()) {
			throw new IllegalArgumentException(MAKE_CANNOT_BE_EMPTY);
		}

		if (model == null) {
			throw new IllegalArgumentException(MODEL_CANNOT_BE_NULL);
		}

		if (model.isEmpty()) {
			throw new IllegalArgumentException(MODEL_CANNOT_BE_EMPTY);
		}

		if (year < 1885) {
			throw new IllegalArgumentException(INVALID_YEAR);
		}

		if (miles < 0) {
			throw new IllegalArgumentException(INVALID_MILES);
		}

		if (price < 0) {
			throw new IllegalArgumentException(INVALID_PRICE);
		}

		this.make = make;
		this.model = model;
		this.year = year;
		this.miles = miles;
		this.price = price;
	}

	/**
	 * Get the miles.
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the miles
	 */
	public double getMiles() {
		return this.miles;
	}

	/**
	 * Set the miles.
	 * 
	 * @precondition miles >= 0
	 * @postcondition miles == getMiles()
	 *
	 * @param miles the miles to set
	 */
	public void setMiles(double miles) {
		if (miles < 0) {
			throw new IllegalArgumentException(INVALID_MILES);
		}

		this.miles = miles;
	}

	/**
	 * Gets the price.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Sets the price.
	 *
	 * @precondition price >= 0
	 * @postcondition price == getPrice()
	 * 
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException(INVALID_PRICE);
		}

		this.price = price;
	}

	/**
	 * Gets the make.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the make
	 */
	public String getMake() {
		return this.make;
	}

	/**
	 * Gets the model.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the model
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Gets the year.
	 *
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

}
