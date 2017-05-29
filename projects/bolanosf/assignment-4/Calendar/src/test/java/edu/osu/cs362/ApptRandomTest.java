package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 30* 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=400;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","setStartHour","setStartMinute","setStartDay","setStartMonth","setStartYear"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
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
				
				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
						else if(methodName.equals("setDescription")){
						   String newDesc=(String) ValuesGenerator.getString(random);
						   appt.setDescription(newDesc);						   
						}
						else if(methodName.equals("setStartDay")){
						   int num=ValuesGenerator.getRandomIntBetween(random,-100,100);
						   appt.setStartDay(num);						   
						}
						else if(methodName.equals("setStartMinute")){
						   int num= ValuesGenerator.getRandomIntBetween(random,-100,100);
						   appt.setStartMinute(num);						   
						}
						else if(methodName.equals("setStartHour")){
						   int num= ValuesGenerator.getRandomIntBetween(random,-30,30);
						   appt.setStartHour(num);						   
						}
						else if(methodName.equals("setStartMonth")){
						   int num=ValuesGenerator.getRandomIntBetween(random,-20,20);
						   appt.setStartMonth(num);						   
						}
						else if(methodName.equals("setStartYear")){
						   int num= ValuesGenerator.getRandomIntBetween(random,-10,3000);
						   appt.setStartYear(num);						   
						}
						
						// resets all values to valid inputs so next iterations isValid()
						// is only dependent on the value that is changed in that iteration
						appt.setStartDay(1);
						appt.setStartMinute(1);
						appt.setStartHour(1);
						appt.setStartMonth(1);
						appt.setStartYear(1);	
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing...");
	 }


	
}
