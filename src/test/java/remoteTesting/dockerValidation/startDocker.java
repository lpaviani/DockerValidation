package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.testng.annotations.BeforeSuite;

public class startDocker {

	@BeforeSuite
	
	public void startFile() throws IOException, InterruptedException 
	{
		
	boolean flag=false;	
	Runtime runtime=Runtime.getRuntime();	
	runtime.exec("cmd /c start dockerUp.bat");			
	Thread.sleep(3000); // time for the File to be created on the OS
	
	//Calendar cal=Calendar.getInstance();
	//cal.add(Calendar.SECOND,30);
	//Long stopnow=cal.getTimeInMillis();
	
	Long tf=System.currentTimeMillis()+30000;	
	String file = "output.txt";
	
	//while(System.currentTimeMillis()<stopnow)
	while(System.currentTimeMillis()<tf)
	{	
		
		if (flag)
		{
			break;
		}
	BufferedReader reader=new BufferedReader(new FileReader(file));
	String currentLine=reader.readLine();
	while(currentLine !=null && !flag)
	{
		if(currentLine.contains("Node has been added"))
		{
			System.out.println("Docker Running!!!");
			flag=true;
			break;
		}
		currentLine=reader.readLine();
	}
	reader.close();
	}
	Assert.assertTrue(flag);
	Thread.sleep(3000);
		
	}
}
