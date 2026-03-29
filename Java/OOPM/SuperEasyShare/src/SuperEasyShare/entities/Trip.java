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
