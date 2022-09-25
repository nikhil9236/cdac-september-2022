class P10{
public static void main(String[]args){
for(char i='E';i>='A';i--) //ROWS
{
	for(char j=i;j>'A';j--) //SPACE
{
System.out.print(" ");
}

for(char j=i;j<='E';j++) //COLUMN
{
System.out.print(j+" ");
}
{
	System.out.println();
}
}
}
}