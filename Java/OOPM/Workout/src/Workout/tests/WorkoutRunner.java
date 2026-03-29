package Workout.tests;


import java.util.Locale;

import static Workout.Main.*;

public class WorkoutRunner {

	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("US", "en"));
		//System.out.printf("[WorkoutRunner] calling Workout.Main.main: ");
		Workout.Main.main(args);

	}

}
