package com.road.taxi.model;

public class AppliedFactor {
		private String type;
		private double multiplier;
		public AppliedFactor(String type, double surgeMultiplier) {
				this.type=type;
				this.multiplier=surgeMultiplier;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getMultiplier() {
			return multiplier;
		}
		public void setMultiplier(double multiplier) {
			this.multiplier = multiplier;
		}
		
		
}
