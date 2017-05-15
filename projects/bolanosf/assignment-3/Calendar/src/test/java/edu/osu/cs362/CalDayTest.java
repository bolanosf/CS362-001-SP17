package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void emptyConstructor() throws Throwable  {
	
	  CalDay cal = new CalDay();
	  assertFalse(cal.isValid());
	
	  //invalid iterator
	  assertEquals(null,cal.iterator());
	  
	  //invalid appointment
	  assertEquals("",cal.toString());
	 }
	
	@Test
	public void Constructor() throws Throwable  {
		GregorianCalendar Gcal= new GregorianCalendar();
		CalDay cal = new CalDay(Gcal);
		assertEquals(Gcal.get(Gcal.MONTH),cal.getMonth()); //use georgian
		assertEquals(Gcal.get(Gcal.YEAR),cal.getYear());
		assertEquals(Gcal.get(Gcal.DAY_OF_MONTH),cal.getDay());
		assertTrue(cal.isValid());
		assertNotEquals(null,cal.iterator());
	}
	
	@Test
	public void AddApp() throws Throwable  {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=5;
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
	    
		GregorianCalendar Gcal= new GregorianCalendar();
		CalDay cal = new CalDay(Gcal);
		assertEquals(Gcal.get(Gcal.MONTH),cal.getMonth()); //use georgian
		assertEquals(Gcal.get(Gcal.YEAR),cal.getYear());
		assertEquals(Gcal.get(Gcal.DAY_OF_MONTH),cal.getDay());
		
		//adding first appointment
		assertEquals(0,cal.getSizeAppts());
		cal.addAppt(appt);
		assertEquals(1,cal.getSizeAppts());
		
		//adding a new appoitment
		appt.setStartHour(10);
		appt.setStartMinute(30);
		appt.setStartDay(10);
		appt.setStartMonth(5);
		appt.setStartYear(2017);
		appt.setTitle("organize B-day party");
		appt.setDescription("meet up with everyone to plan it out");
		
		cal.addAppt(appt);
		assertEquals(2,cal.getSizeAppts());
		
		//invalid event (shouldn't be added)
		appt.setStartHour(-1);
		cal.addAppt(appt);
		assertEquals(2,cal.getSizeAppts());
		
		//iterator with valid list
		assertNotEquals(cal.getAppts().iterator(), cal.iterator());
		
	}
	
	@Test
	public void print() throws Throwable  {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=5;
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
	    
		GregorianCalendar Gcal= new GregorianCalendar();
		CalDay cal = new CalDay(Gcal);
		
		assertNotEquals("",cal.toString());
		
		assertEquals(0,cal.getSizeAppts());
		cal.addAppt(appt);
		assertEquals(1,cal.getSizeAppts());
		
		//to string assert
		assertNotEquals("",cal.toString());
		
	}
	
}
