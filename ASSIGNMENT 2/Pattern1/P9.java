class P9{
public static void main(String[]args){
for(char i='A';i<='E';i++) //ROWS
{
	for(char j='D';j>=i;j--) //SPACE
{
System.out.print(" ");
}

for(char j='A';j<=i;j++) //COLUMN
{
System.out.print(j+" ");
}
{
	System.out.println();
}
}
}
}