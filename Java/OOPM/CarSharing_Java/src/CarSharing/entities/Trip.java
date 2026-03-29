package CarSharing.entities;

import CarSharing.provided.Car;
import CarSharing.provided.Customer;
import CarSharing.provided.DateTime;
import CarSharing.provided.Location;
import CarSharing.provided.TripStatus;

import java.security.InvalidParameterException;
import java.util.Date;

/**
 * A trip in the car sharing system.<br>
 * 
 * A trip collects information about time, location, customer and car involved.
 * It also contains a rate responsible for calculation of the total amount charged for
 * a trip.
 * 
 * Some operations' behavior depends on this trip's
 * {@link CarSharing.provided.TripStatus}.
 * 
 */
public class Trip implements Comparable<Trip> {
	
	private final Car car;
	private double distance;
	private Location endLocation;
	private DateTime endTime;
	private final Rate rate;
	private final Customer renter;
	private Location startLocation;
	private DateTime startTime;
	private TripStatus status;

	public Trip(Trip tr){
		this.car = tr.car;
		this.distance = tr.distance;
		this.endLocation = tr.endLocation;
		this.endTime = tr.endTime;
		this.rate = tr.rate;
		this.renter = tr.renter;
		this.startLocation = tr.startLocation;
		this.startTime = tr.startTime;
		this.status = tr.status;
	}
	public Trip(Car car, Customer customer, Rate rate){
		if (car == null || customer == null || rate == null)
			throw new NullPointerException("All variables must be non-null");

		this.car = car;
		renter = customer;
		this.rate = rate;
	}

	public Trip(Car car, Customer renter, Rate rate, Location startLocation, DateTime startTime) {
		this.car = car;
		this.rate = rate;
		this.renter = renter;
		this.startLocation = startLocation;
		this.startTime = startTime;
		status = TripStatus.STARTED;
	}

	public Trip(Car car, Customer renter, Rate rate, Location startLocation,  DateTime startTime, Location endLocation, DateTime endTime, double distance) {
		this.car = car;
		this.distance = distance;
		this.endLocation = endLocation;
		this.endTime = endTime;
		this.rate = rate;
		this.renter = renter;
		this.startLocation = startLocation;
		this.startTime = startTime;
		status = TripStatus.COMPLETED;
	}
	public int compareTo(Trip trip){
		if (this.getStatus()== TripStatus.COMPLETED && trip.getStatus()==TripStatus.COMPLETED)
			return (int) this.startTime.diff(trip.startTime);
		return Integer.MAX_VALUE;
	}
	public Trip end (Location endLocation, DateTime endTime, double distance) {
	try {
		try {
			this.endLocation = endLocation;
			this.endTime = endTime;
			this.distance = distance;
			status = TripStatus.COMPLETED;
		} catch (InvalidParameterException e) {
			System.out.println("please correct input");
		}
	}
	catch (IllegalStateException a){
		System.out.println("only started trips can be completed");
	}
		return this;
	}

	public double getDistance() {
		return distance;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public Rate getRate() {
		return rate;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public TripStatus getStatus() {
		return status;
	}
	public Trip start (Location startLocation, DateTime startTime){
		this.startLocation = startLocation;
		this.startTime = startTime;
		status = TripStatus.STARTED;
		return this;
	}

	@Override
	public String toString() {
		return "Trip{" +
				"car=" + car +
				", distance=" + distance +
				", endLocation=" + endLocation +
				", endTime=" + endTime +
				", rate=" + rate +
				", renter=" + renter +
				", startLocation=" + startLocation +
				", startTime=" + startTime +
				", status=" + status +
				'}';
	}
	public final int total(){
		return rate.total(this);
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
