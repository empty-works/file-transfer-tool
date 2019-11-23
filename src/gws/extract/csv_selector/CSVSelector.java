/*
 */
package gws.extract.csv_selector;

import gws.extract.beans.TransferProperties;
import gws.extract.abstract_buttons.OpenButton;
import gws.extract.tool.StaticVar;
import gws.extract.tool.SuperDisplay;
import java.io.File;

/**
 *
 * @author MP
 */
public class CSVSelector extends SuperDisplay
{
    /***************************************************************************
     * 
     ***************************************************************************/
    public CSVSelector(TransferProperties transferProps)
    {
        super(transferProps);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getIconFileName()
    {
        return "csvIcon.png";
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getButtonTitle()
    {
        return "CSV File";
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected int getOpenType()
    {
        return OpenButton.FILE;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected void executeAction()
    {
        File file = openButton.getFile();
        fullPath = file.getAbsolutePath();
        transferProps.csvPath = fullPath;
        transferProps.csvName = file.getName();
        CheckmarkLabel.setVisible(true);
        StatusLabel2.setText(StaticVar.HTML_START + transferProps.csvName + StaticVar.HTML_END);
        transferProps.NextButton.setVisible(true);
        showStatus(true);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected boolean propertiesAreNotReady()
    {
        return transferProps.csvPath.equals("") || transferProps.numFiles == 0;
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected void checkStatus()
    {
        showStatus(false);
        CheckmarkLabel.setVisible(false);
        if(!transferProps.csvPath.equals(""))
        {
            CheckmarkLabel.setVisible(true);
            StatusLabel2.setText(StaticVar.HTML_START + transferProps.csvName + StaticVar.HTML_END);
            showStatus(true);
        }
    }
}
