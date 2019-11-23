/*
 */
package gws.extract.libs;

/**
 *
 * @author MP
 */
public class NumFileLib 
{
    final static public int getFileNumPadder(int totalNumFiles)
    {
        int padder = 0;
        if(totalNumFiles > 5000)
        {
            padder = 10;
        }
        if(totalNumFiles > 15000)
        {
            padder = 20;
        }
        if(totalNumFiles > 25000)
        {
            padder = 30;
        }
        return padder;
    }
}
