
package edu.osu.cs362;


import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 30 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=400;


    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =10;//System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				GregorianCalendar Gcal= new GregorianCalendar();
				CalDay cal = new CalDay(Gcal);
				
				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 
				//Construct a new Appointment object with the initial data	 
				Appt[] appt = new Appt[NUM_TESTS];
				
				for (int i = 0; i < NUM_TESTS; i++) {
					appt[i] = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				          description);
					
					cal.addAppt(appt[i]);
					startDay= ValuesGenerator.getRandomIntBetween(random,-40,40);
					startMinute= ValuesGenerator.getRandomIntBetween(random,-100,100);
					startHour= ValuesGenerator.getRandomIntBetween(random,-30,30);
					startMonth= ValuesGenerator.getRandomIntBetween(random,-20,20);
					startYear= ValuesGenerator.getRandomIntBetween(random,-10,3000);
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing...");
		 
		 
	 }


	
}
