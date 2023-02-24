package remoteTesting.dockerValidation;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Long t=System.currentTimeMillis();
        System.out.println( t );
        Long x=t+300;
        System.out.println( x );

        
        Calendar cal=Calendar.getInstance();
        System.out.println("cal"+ cal.getTimeInMillis() );
        cal.add(Calendar.SECOND, 30);
        Long L=cal.getTimeInMillis();
        System.out.println("cal"+L );
    }
}
