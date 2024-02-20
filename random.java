import java.util.Scanner;
class random
{
	public static int countprime=0;
	public static int countnonprime=0;

	public static void main(String args[])
	{	
		int l=0;
		while(l<4)
		{
			long starttime=System.nanoTime();
			System.out.println("Start Time="+starttime);
			long[] array=randomarray();
			primecount(array);
			System.out.println(countprime);
			System.out.println(countnonprime);
			long endtime=System.nanoTime();
			System.out.println("End Time="+endtime);
			long timediff=endtime-starttime;
			System.out.println("Time Difference="+timediff);
			System.out.println(" ");
			l++;
			countprime=0;
			countnonprime=0;
		}
	}
	
	public static boolean isprime(long number)
	{
		for(int l=2;l<number;l++)
		{
			if(number%l!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	return true;
	}
	
	public static void primecount(long[] arr)
	{
		for(int l=0;l<arr.length;l++)
		{
			if(isprime(arr[l]))
			{
				countprime++;
			}
			else
			{
				countnonprime++;
			}
		}
	}
	
	public static long[] randomarray()
	{
		long[] arr=new long[1000000];
		for(int l=0;l<1000000;l++)
		{
			arr[l]=randomnumber();
		}
		return arr;
	}
	
	public static long randomnumber()
	{
		long number=0;
		for(int n=0;n<7;n++)
		{
			long randomdigit=generaterandomdigit();
			number=number*10+randomdigit;
		}
	return number;
	}
	
	public static long generaterandomdigit()
	{
		long randomdigit=System.nanoTime()%10;
		return randomdigit;
	}
}
