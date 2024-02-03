import java.util.Scanner;
class SY2022BIT015
{
	public static void main(String[] args)
	{
		//Creating an object of class
		SY2022BIT015 sy = new SY2022BIT015();
		//Registration numbers using string array
		String str[]={"2023bit059","2020bme010","2021btt032","2024bcs111","2017bpt033","2024bch021","2021bec032","2023bme019",
		"2026bit019","2013bcs019"};
		System.out.println(sy.getValidRegistrationsCount(str));
	}
	public int getValidRegistrationsCount(String v[]) 
	{
		int start = 0;
		//Applying 'for' loop
		for(int i=0;i<v[0].length();i++)
		{
	 		if(v[i].length()==10 && 
        		(v[i].contains("2020")|v[i].contains("2021")||v[i].contains("2022")||v[i].contains("2023")||v[i].contains("2024")) &&
        		((v[i].charAt(4)=='b' && v[i].charAt(5)=='c' && v[i].charAt(6)=='s')||(v[i].charAt(4)=='b' && v[i].charAt(5)=='i' && 
        		v[i].charAt(6)=='t')||(v[i].charAt(4)=='b'&& v[i].charAt(5)=='m' && v[i].charAt(6)=='e')||(v[i].charAt(4)=='b'&& 
        		v[i].charAt(5)=='c' && v[i].charAt(6)=='h')) && 
       			(v[i].charAt(7)=='0'||v[i].charAt(7)=='1'||v[i].charAt(7)=='2'||v[i].charAt(7)=='3'||v[i].charAt(7)=='4'||
       			v[i].charAt(7)=='5'||v[i].charAt(7)=='6'||v[i].charAt(7)=='7'||v[i].charAt(7)=='8'||v[i].charAt(7)=='9') &&
			(v[i].charAt(8)=='0'||v[i].charAt(8)=='1'||v[i].charAt(8)=='2'||v[i].charAt(8)=='3'||v[i].charAt(8)=='4'||
			v[i].charAt(8)=='5'||v[i].charAt(8)=='6'||v[i].charAt(8)=='7'||v[i].charAt(8)=='8'||v[i].charAt(8)=='9') &&
			(v[i].charAt(9)=='0'||v[i].charAt(9)=='1'||v[i].charAt(9)=='2'||v[i].charAt(9)=='3'||v[i].charAt(9)=='4'||
			v[i].charAt(9)=='5'||v[i].charAt(9)=='6'||v[i].charAt(9)=='7'||v[i].charAt(9)=='8'||v[i].charAt(9)=='9'))
			{
        			start++;
        		}
        	}
         	return start;
        }
}

