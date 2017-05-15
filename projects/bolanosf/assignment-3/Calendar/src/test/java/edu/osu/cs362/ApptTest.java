package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
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
	 
	 
	 @Test
	  public void test01()  throws Throwable  {
		 
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 
	 
	 @Test
	 public void Messages()  throws Throwable  {
	    appt.setStartYear(2000);
		appt.setTitle("new event");
		appt.setDescription("I changed the event");
		
		assertEquals("new event", appt.getTitle());
		assertEquals("I changed the event", appt.getDescription());
		assertEquals(2000,appt.getStartYear());
	 }
	 
	  @Test
	 public void MessageNull()  throws Throwable  {
		appt.setTitle(null);
		appt.setDescription(null);
		
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	 }
	 
	 @Test
	  public void InputsRecorded()  throws Throwable  {
		//changing variable values
		int[] hourP = {0,1,22,23};
		int[] minP = {0,1,58,59};
		int[] dayP = {1,2,30,31};
		int[] monthP ={1,2,11,12};
		int yearP=2000;
				 
		//changing variables of expected to pass
		for(int i=0; i<4; i++)
		{
			appt.setStartHour(hourP[i]);
			assertTrue(appt.getValid());
			
			appt.setStartMinute(minP[i]);
			assertTrue(appt.getValid());
			
			appt.setStartDay(dayP[i]);
			assertTrue(appt.getValid());
			
			appt.setStartMonth(monthP[i]);
			assertTrue(appt.getValid());
			
			// assertions
			assertEquals(hourP[i], appt.getStartHour());
			assertEquals(minP[i], appt.getStartMinute());
			assertEquals(dayP[i], appt.getStartDay());
			assertEquals(monthP[i], appt.getStartMonth());
		}
	  }
	  
	  @Test
	  public void InvalidInputs() throws Throwable {
		
		int[] hourF = {-10,-1,24,30};
		int[] minF = {-3,-1,60,100};
		int[] dayF = {-1,0,32,40};
		int[] monthF ={-4,0,13,20};
			
		appt.setStartYear(2021);
		assertTrue(appt.getValid());
		assertEquals(2021,appt.getStartYear());
			
		for(int i=0; i<4; i++)
		{
			appt.setStartHour(hourF[i]);
			assertEquals(hourF[i], appt.getStartHour());
			assertFalse(appt.getValid());
		}
		
		appt.setStartHour(1);
		for(int i=0; i<4; i++)
		{
			appt.setStartMinute(minF[i]);
			assertEquals(minF[i], appt.getStartMinute());
			assertFalse(appt.getValid());
		}
		
		appt.setStartMinute(1);
		for(int i=0; i<4; i++)
		{
			appt.setStartDay(dayF[i]);
			assertEquals(dayF[i], appt.getStartDay());
			assertFalse(appt.getValid());
		}	
		
		appt.setStartDay(1);
		for(int i=0; i<4; i++)
		{
			appt.setStartMonth(monthF[i]);
			assertEquals(monthF[i], appt.getStartMonth());
			assertFalse(appt.getValid());
		}
		
		appt.setStartYear(2020);
		assertFalse(appt.getValid());
		assertEquals(2020,appt.getStartYear());
		assertFalse(appt.getValid());
	  }
	  
	 @Test
	 public void CreateStringP() throws Throwable {
		appt.setStartHour(12);
		assertEquals(12, appt.getStartHour());
		assertEquals("\t4/10/2017 at 12:30pm ,Birthday Party, This is my birthday party.\n",appt.toString());
		appt.setStartHour(11);
		assertEquals(11, appt.getStartHour());
		assertEquals("\t4/10/2017 at 11:30am ,Birthday Party, This is my birthday party.\n",appt.toString());
	 }
	  
	 @Test
	 public void CreateStringF() throws Throwable {
		 appt.setStartHour(-1);
		 assertEquals(-1, appt.getStartHour());
		 assertEquals(null,appt.toString());
	 }

}
