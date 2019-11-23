/*
 */
package gws.extract.libs;

/**
 *
 * @author MP
 */
public class OSSepLib 
{
    /***************************************************************************
     * Method: getOSSeparator
     * 
     * Sets directory separator depending on operating system.
     * @return
     ***************************************************************************/
    final static public String getOSSeparator()
    {
        String OSsep = "";
        try
        {
            String OSName = System.getProperty("os.name","").toLowerCase();
            System.out.println("Operating System:"+ OSName);

            if ( OSName.startsWith("windows")) 
            {
               // windows
                OSsep = "\\";
            } 
            else if (OSName.startsWith("linux")) 
            {
               // linux
                OSsep = "//";
            } 
            else if (OSName.startsWith("mac")) 
            {
               // mac
            } 
        }
        catch(Exception e)
        {
            System.out.println("Sorry, your operating system is not supported.");
        }
        return OSsep;
    }
}
