package edu.osu.cs362;

import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import java.util.LinkedList;


/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 30 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=300;

	
    /**
     * Generate Random Tests that tests TimeTable Class.
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
				 
				 int startHour2=13;
				 int startMinute2=30;
				 int startDay2=10;
				 int startMonth2=4;
				 int startYear2=2017;
				 String title2="Birthday Party";
				 String description2="This is my birthday party.";
				 
				//Construct a new Appointment object with the initial data	 
				Appt[] apptAdd= new Appt[NUM_TESTS];
				Appt[] apptCheck = new Appt[NUM_TESTS];
				LinkedList<Appt> apptsNull = null;
				Appt apptNull = null;
				TimeTable tt= new TimeTable();
				
				for (int i = 0; i < NUM_TESTS; i++) {
					apptAdd[i]=new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				          description);
				
					apptCheck[i] = new Appt(startHour2,
				          startMinute2,
				          startDay2 ,
				          startMonth2 ,
				          startYear2 ,
				          title2,
				          description2);
					
					cal.addAppt(apptAdd[i]);
					
					int rand= ValuesGenerator.getRandomIntBetween(random,0,3);
					if(rand== 0)
						tt.deleteAppt(apptsNull,apptCheck[i]);
					else if(rand == 1)
						tt.deleteAppt(cal.getAppts(),apptNull);
					else if(rand == 2)
						tt.deleteAppt(cal.getAppts(),apptCheck[i]);
					else
						tt.deleteAppt(cal.getAppts(),apptAdd[i]);
					
					startDay= ValuesGenerator.getRandomIntBetween(random,-1,33);
					startMinute= ValuesGenerator.getRandomIntBetween(random,-3,61);
					startHour= ValuesGenerator.getRandomIntBetween(random,-2,25);
					startMonth= ValuesGenerator.getRandomIntBetween(random,-3,13);
					
					startDay2= ValuesGenerator.getRandomIntBetween(random,-1,33);
					startMinute2= ValuesGenerator.getRandomIntBetween(random,-3,61);
					startHour2= ValuesGenerator.getRandomIntBetween(random,-2,25);
					startMonth2= ValuesGenerator.getRandomIntBetween(random,-3,13);
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing..."); 
		 
	 }


	
}
