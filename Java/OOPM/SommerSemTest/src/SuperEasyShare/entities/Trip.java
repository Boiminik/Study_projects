package SuperEasyShare.entities;

import SuperEasyShare.provided.Car;
import SuperEasyShare.provided.Customer;
import SuperEasyShare.provided.DateTime;
import SuperEasyShare.provided.TripStatus;

/**
 * A trip in the car sharing system.<br>
 * 
 * A trip collects information about time, customer and car involved.
 * It also contains a rate responsible for calculation of the total amount
 * charged for
 * a trip.
 * 
 * Some operations' behavior depends on this trip's
 * {@link SuperEasyShare.provided.TripStatus}.
 * 
 */
public class Trip {
	private Car car;
	private double distance;
	private DateTime endTime;
	private Rate rate;
	private Customer renter;
	private DateTime startTime;
	private TripStatus status = TripStatus.CREATED;

	public Trip(Trip tr) {
		this.car = new Car(tr.car);
		this.distance = tr.distance;
		this.endTime = new DateTime(tr.endTime);
		this.renter = new Customer(tr.renter);
		this.startTime = new DateTime(tr.startTime);
		this.status = tr.status;
	}

	public Trip(Car car, Customer customer, Rate rate) {
		this.car = car;
		renter = customer;
		this.rate = rate;

	}

	public Trip(Car car, Customer renter, Rate rate, DateTime startTime) {
		this.car = car;
		this.rate = rate;
		this.renter = renter;
		this.startTime = startTime;
	}

	public Trip(Car car,  Customer renter,  Rate rate, DateTime startTime, DateTime endTime,  double distance) {
		this.car = car;
		this.distance = distance;
		this.endTime = endTime;
		this.rate = rate;
		this.renter = renter;
		this.startTime = startTime;
	}

	public double getDistance() {
		return distance;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public Rate getRate() {
		return rate;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public TripStatus getStatus() {
		return status;
	}
	public Trip end(DateTime endTime, double distance){
		if (endTime != null && status ==TripStatus.STARTED && endTime.diff(startTime)>0) {
			this.endTime = endTime;
			this.distance = distance;
			status = TripStatus.COMPLETED;
		} else {
			System.out.println("this Trip cannot end");
		}
		return this;
	}

	public Trip start(DateTime startTime){
		if (startTime != null && status==TripStatus.CREATED) {
			this.startTime = startTime;
			status = TripStatus.STARTED;
		}
		return this ;
	}
	public final int total(){
		return rate.total(this);
	}

	@Override
	public String toString() {
		return "Trip{" +
				"car=" + car +
				", distance=" + distance +
				", endTime=" + endTime +
				", rate=" + rate +
				", renter=" + renter +
				", startTime=" + startTime +
				", status=" + status +
				'}';
	}

	/**
	 * The duration of this trip in seconds.<br>
	 * 
	 * 
	 * 
	 * @ProgrammingProblem.Hint use {@link DateTime#diff(DateTime)}
	 * @return the difference in seconds if this trip is completed, zero otherwise
	 */
	public int duration() {
		if (status == TripStatus.COMPLETED)
			return (int) (startTime.diff(endTime));

		return 0;
	}
}
