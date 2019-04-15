import impl.TrackCoach;
import interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
//		interfaces.Coach theCoach = new impl.BaseballCoach();
		Coach theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());
	}

}
