package edu.umb.cs681.hw18;

import java.util.LinkedList;

public class PrimeFactorizer {
	protected long dividend, from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();

	public PrimeFactorizer(long dividend) {
		if (dividend >= 2) {
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		} else {
			throw new RuntimeException("dividend must be greater 2. dividend==" + dividend);
		}
	}

	public long getDividend() {
		return dividend;
	}

	public long getFrom() {
		return from;
	}

	public long getTo() {
		return to;
	}

	public LinkedList<Long> getPrimeFactors() {
		return factors;
	}

	public void generatePrimeFactors() {
		long divisor = 2;
		while (dividend != 1 && divisor <= to) {
			if (dividend % divisor == 0) {
				factors.add(divisor);
				dividend /= divisor;
			} else {
				if (divisor == 2) {
					divisor++;
				} else {
					divisor += 2;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Prime factors of 7: ");
		PrimeFactorizer fac = new PrimeFactorizer(7);
		factors1.generatePrimeFactors();
		System.out.println(factors1.getPrimeFactors());

		System.out.print("Prime factors of 21: ");
		factors1 = new PrimeFactorizer(21);
		factors1.generatePrimeFactors();
		System.out.println(factors1.getPrimeFactors());

		System.out.print("Prime factors of 207: ");
		factors1 = new PrimeFactorizer(207);
		factors1.generatePrimeFactors();
		System.out.println(factors1.getPrimeFactors());

		System.out.print("Prime factors of 100: ");
		factors1 = new PrimeFactorizer(100);
		factors1.generatePrimeFactors();
		System.out.println(factors1.getPrimeFactors());

	}
}
