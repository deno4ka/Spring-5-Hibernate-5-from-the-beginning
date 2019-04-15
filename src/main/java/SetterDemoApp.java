import interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		impl.CricketCoach cricketCoach = context.getBean("myCricketCoach", impl.CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(String.format("team: \"%s\", email: \"%s\"", cricketCoach.getTeam(), cricketCoach.getEmailAddress()));
		context.close();
	}

}
