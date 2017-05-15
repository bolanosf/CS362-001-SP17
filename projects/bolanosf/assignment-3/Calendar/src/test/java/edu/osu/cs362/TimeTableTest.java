package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	 int startHour=13;
		 int startMinute=30;
		 int startDay=2;
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
				 
	GregorianCalendar Gcal= new GregorianCalendar(2017,4,1);
	CalDay cal = new CalDay(Gcal);
	
	
	 @Test
	 public void ApptRange()  throws Throwable  {
		TimeTable tt= new TimeTable();
		GregorianCalendar Gday1= new GregorianCalendar(2017,4,1);
		GregorianCalendar Gday2= new GregorianCalendar(2017,4,30);
		GregorianCalendar Gday3= new GregorianCalendar(2017,4,2);
		
		cal.addAppt(appt);
		appt.setStartHour(10);
		appt.setStartMinute(30);
		appt.setStartDay(4);
		appt.setStartMonth(4);
		appt.setStartYear(2017);
		appt.setTitle("organize B-day party");
		appt.setDescription("meet up with everyone to plan it out");
		cal.addAppt(appt);
	
		
		//valid 
		LinkedList<CalDay> calDays = tt.getApptRange(cal.getAppts(),Gday1,Gday2);
		assertEquals(1,(calDays.getFirst()).getDay());
		assertEquals(4,(calDays.getFirst()).getMonth());
		assertEquals(2017,(calDays.getFirst()).getYear());
		assertEquals(2,(calDays.get(3)).getSizeAppts());
		assertEquals(29,calDays.size());
		
	 }
	 
	 @Test
	 public void RemovingNothing()  throws Throwable  {
		TimeTable tt= new TimeTable();
		LinkedList<Appt> appts = null;
		Appt ap=null;
		int Hour=13;
		 int Minute=30;
		 int Day=10;
		 int Month=4;
		 int Year=2017;
		 String tit="Birthday Party";
		 String desc="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(Hour,
		          Minute ,
		          Day ,
		          Month ,
		          Year ,
		          tit,
		         desc);
				 
		
				 
		//empty list
		assertEquals(null,tt.deleteAppt(appts,appt1));
		assertEquals(null,tt.deleteAppt(cal.getAppts(),ap));
		
		//invalid appointments
		appt1.setStartHour(-1);
		assertEquals(null,tt.deleteAppt(cal.getAppts(),appt1));
		
		appt1.setStartHour(10);
		assertEquals(null,tt.deleteAppt(cal.getAppts(),appt1));
		
		//valid
		appt1.setStartHour(13);
		cal.addAppt(appt1);
		assertNotEquals(null,tt.deleteAppt(cal.getAppts(),appt1));
		assertEquals(null,tt.deleteAppt(cal.getAppts(),appt));
	 }
	 
	 

}
