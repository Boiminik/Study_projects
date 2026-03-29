
package Workout;

public class BasicWorkout {
	protected Date date = new Date();
	protected String description;
	protected int duration;
	protected int energy;
	protected int intensity;




	/**
	 * Constructs a basic workout on a specified date and of a specified duration.
	 * 
	 * @param date
	 *            the date on which this workout started
	 * @param duration
	 *            the duration of this workout in s
	 * @param intensity
	 *            the intensity of this workout
	 * @param energy
	 *            the energy burned during this workout in kcal
	 * @param description
	 *            the description of this workout
	 */
	public BasicWorkout deepCopy (BasicWorkout bw){
		bw.date=this.date;
		bw.description = this.description;
		bw.duration = this.duration;
		bw.energy = this.energy;
		bw.intensity = this.intensity;
		return bw;
	}
	public BasicWorkout (Date date, int duration){
		this.date = date;
		if (duration > 0){this.duration = duration;}
	}
	public BasicWorkout (Date date, int duration, int intensity){
		this(date,duration);
		if (intensity >= 1 && intensity <= 10){this.intensity = intensity;}
	}
	public BasicWorkout (Date date, int duration, int intensity, int energy){
		this(date,duration,intensity);
		if (energy > 0){this.energy = energy;}
	}
	public BasicWorkout(Date date, int duration, int intensity, int energy, String description) {
		this(date, duration, intensity, energy);
		this.description = (description == null) ? null : String.format("%.100s", description);
	}

	public String getDescription(){
		return description;
	}
	public int getEnergy(){
		return energy;
	}
	public int getIntensity(){
		return intensity;
	}
	public String getIntensityString(){
		String IntensityString ="[";
		for (int i = 1; i <= 10 ; i++) {
			if (i<=intensity){
				IntensityString += "*";
			} else
				IntensityString += " ";
		}
		IntensityString += "]";
		return IntensityString;
	}

	/**
	 * Creates a String representation of this workout.<br>
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s: %s \"%s\" %.1fh, %dkcal ", date, getIntensityString(), getDescription(), 
				duration/3600., getEnergy());
	}



}
