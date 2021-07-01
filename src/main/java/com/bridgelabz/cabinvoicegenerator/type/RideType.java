package com.bridgelabz.cabinvoicegenerator.type;

import java.util.HashMap;
import java.util.Map;

public enum RideType {
	NORMAL(1, 10.0, 5.0), PREMIUM(2, 15.0, 20.0);

	private final int COST_PER_TIME;
	private final double MINIMUM_COST_PER_KM;
	private final double MINIMUM_FARE;

	RideType(int COST_PER_TIME, double MINIMUM_COST_PER_KM, double MINIMUM_FARE) {
		this.COST_PER_TIME = COST_PER_TIME;
		this.MINIMUM_COST_PER_KM = MINIMUM_COST_PER_KM;
		this.MINIMUM_FARE = MINIMUM_FARE;
	}

	private static final Map<Integer, RideType> BY_COST_PER_TIME = new HashMap<>();
	private static final Map<Double, RideType> BY_MINIMUM_COST_PER_KM = new HashMap<>();
	private static final Map<Double, RideType> BY_MINIMUM_FARE = new HashMap<>();

	static {
		for (RideType e : values()) {
			BY_COST_PER_TIME.put(e.COST_PER_TIME, e);
			BY_MINIMUM_COST_PER_KM.put(e.MINIMUM_COST_PER_KM, e);
			BY_MINIMUM_FARE.put(e.MINIMUM_FARE, e);
		}
	}

	public static RideType valueOfCostPerTime(int COST_PER_TIME) {
		return BY_COST_PER_TIME.get(COST_PER_TIME);
	}

	public static RideType valueOfMinimumCostPerKm(double MINIMUM_COST_PER_KM) {
		return BY_MINIMUM_COST_PER_KM.get(MINIMUM_COST_PER_KM);
	}

	public static RideType valueOfMinimumFare(double MINIMUM_FARE) {
		return BY_MINIMUM_FARE.get(MINIMUM_FARE);
	}

	public int getCostPerTime() {
		return COST_PER_TIME;
	}

	public double getMinimumCostPerKm() {
		return MINIMUM_COST_PER_KM;
	}

	public double getMinimumFare() {
		return MINIMUM_FARE;
	}
}
