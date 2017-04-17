// Francisco Bolanos
// cs 362, assignment 1

package edu.osu.cs362;
import java.util.Random;
//package tutorial;

public class prog<T>{
	static void calc_winner(team x, team y){
		int sumX;
		int sumY;

		sumX=x.calc_sum();
		sumY=y.calc_sum();

	
		//bug: forgetting the case for when the teams tie
		if(sumX>sumY)
		{	
			x.wins();
			y.losses();
		}

		else
		{
			x.losses();
			y.wins();
		}

	}

	static void show_stats(team[] array){
		for(int i=0; i<array.length; i++)
                {
			array[i].print_stats();
		}

	}
	
	static void match_ups(team[] array, int times){
	
		Random rand= new Random();
		System.out.println("each team played " + times + " rounds of games");
		
	
		for(int i=0; i<times; i++)
		{
			for(int j=0; j<array.length; j++)
                	{
				for(int k=j; k<array.length; k++) //bug should be k=k+1
				{
					int num=rand.nextInt(1);
					if(num==0)
                	        	{
                        	        	array[j].set_home(true);
                                		array[k].set_home(false);
        	                	}
	
                        		else
                        		{
                                	array[j].set_home(false);
                                	array[k].set_home(true);
                        		}

					calc_winner(array[j], array[k]);
				}
			}
		}

	}



	public static void main(String[] args){

		int num_teams=4;
		int num_rounds=3;

		team[] roster= new team[num_teams];
		for( int i=0; i<num_teams; i++ )
    			roster[i] = new team();

		
		roster[0].set_name("sharks");
		roster[1].set_name("gators");
		roster[2].set_name("knights");
                roster[3].set_name("divers");

		match_ups(roster,num_rounds);
		show_stats(roster);		
	}
}


class team{
	private String name;
	private int Offense;
	private int Defense;
	private int Chemistry;
	private int wins;
	private int losses;
	private int ties;

	private boolean Home;


	team(){
		Random rand= new Random();
		int num[] =new int[3];	
		num[0]=num[1]=num[2]=0;

		while(num[0]+num[1]+num[2]<= 100) //bug 
		{
			num[0]= rand.nextInt(100) + 1;
			num[1]= rand.nextInt(100) + 1;
			num[2]= rand.nextInt(100) + 1;
		}

		Offense=num[0];
		Defense=num[1];
		Chemistry=num[2];
		wins=ties=losses=0;
		Home=true;
	}

	void set_home(boolean x){ Home=x;}
	void set_name(String x){ name=x;}
	void wins(){ wins++;}
	void losses(){ ties++;}
	void ties(){ ties++;} //bug 
	int calc_sum()
	{
		double homeb;
		int sum;
		if(Home)
			homeb=1.1;
		else
			homeb=1;

		sum=(int)((double)(Offense+Defense+(Chemistry/2)+wins-losses)*homeb); // formula for overall score of team

		return sum;
	}	

	void print_stats()
	{
		System.out.println(name);
		System.out.println("offense, defense, chemistry:");
                System.out.println(Offense+","+Defense+","+Chemistry);
		System.out.println("wins, losses , ties:");
		System.out.println(wins+","+losses+","+ties);
	}
}


