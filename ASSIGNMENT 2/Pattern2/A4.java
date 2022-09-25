class A4{

public static void main(String args[]){
	
	for(int i=1;i<=5;i++)//rows
	{
		for(int j=2;j<=i;j++)//space
		{
			System.out.print(" ");
			
		}
		for(int k=5;k>=i;k--)//col
		{
			System.out.print("*");
			
		}
		
		System.out.println();
	}
}
}