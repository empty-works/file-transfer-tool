/*
 */
package gws.extract.confirm_display;

import com.opencsv.CSVReader;
import gws.extract.beans.TransferProperties;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author MP
 */
public class MyTransferHandler 
{
    final private TransferProperties transProps;
    private CSVReader openCSVReader = null;
    final static int COPY = 0, MOVE = 1;
    final private int transferType;
    
    /***************************************************************************
     * 
     * @param tp 
     ***************************************************************************/
    public MyTransferHandler(TransferProperties tp, int transferType)
    {
        transProps = tp;
        this.transferType = transferType;
        openCSVReader = setFileReader(transProps.csvPath);
    }
    
    /***************************************************************************
     * Method: setWorkbookStuff
     * 
     * Instantiate Workbook and set worksheet.
     * @param dataDirPath
     * @return CSVReader
     * @throws IOException
     ***************************************************************************/
    private CSVReader setFileReader(final String dataDirPath)
    {
        CSVReader csvReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            File file = new File(dataDirPath);
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"ISO-8859-1"));
            csvReader = new CSVReader(bufferedReader);
        }
        catch(FileNotFoundException | UnsupportedEncodingException fnf)
        {
            System.out.println("TargetFileNamesTask - setFileReader error: " + fnf);
        }
        finally
        {
            if(csvReader == null)
            {
                try
                {
                    // Always close files.
                    bufferedReader.close();   
                }
                catch(IOException ioe)
                {
                    System.out.println("TargetFileNamesTask - setFileReader error: " + ioe);
                }         
            }
        }
        return csvReader;
    }
    
    /***************************************************************************
     * Method: setDataContent
     * @param sourceDirectoryPath
     * @param destDirectoryPath
     * @throws IOException 
     ***************************************************************************/
    final public void setDataContent()
    {
        TargetFileNamesTask targetFileTask = new TargetFileNamesTask(openCSVReader, transProps);
        targetFileTask.setTransferType(transferType);
        targetFileTask.execute();
    }
}
