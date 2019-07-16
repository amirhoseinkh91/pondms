package ir.viratech.pond_ms.api.layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RasterZonalStatisticsDTO {

	public RasterZonalStatisticsDTO() {
		this.min = Double.NaN;
		this.max = Double.NaN;
		this.avg = Double.NaN;
		this.stddev = Double.NaN;
	}
	
	@JsonProperty("min")
	private double min;

	@JsonProperty("max")
	private double max;
	
	@JsonProperty("avg")
	private double avg;

	@JsonProperty("stddev")
	private double stddev;

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getStddev() {
		return stddev;
	}

	public void setStddev(double stddev) {
		this.stddev = stddev;
	}

}
