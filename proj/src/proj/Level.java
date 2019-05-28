
package proj;


public class Level
{
	static int level;
	
	
	public static int getLevel()
	{
		return level;
	}
	
	
	public static void addLevel()
	{
		
		if (level < 28)
		{
			level++;
		}
		System.out.println("level:"+level);//เช็คเวล
	}

	
	public static void initLevel()
	{
		level = 0;
	}
}