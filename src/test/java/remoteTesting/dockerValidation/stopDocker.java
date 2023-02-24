package remoteTesting.dockerValidation;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class stopDocker {
	@AfterSuite
	public void stopAndDelete() throws IOException, InterruptedException 
	{
		Runtime runtime=Runtime.getRuntime();	
		runtime.exec("cmd /c start dockerDown.bat");	
		Thread.sleep(5000);
		
		File fileLog=new File("output.txt");
			if(fileLog.exists()) 
			{
				assertEquals(fileLog.exists(), true);
				fileLog.delete();
				System.out.println("output File deleted");
				
			}
			
			else 
				System.out.println("Error on deleting the file");
				assertEquals(fileLog.exists(), false);
	}
}


