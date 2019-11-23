/*
 */
package gws.extract.dest_dir_display;

import gws.extract.beans.TransferProperties;
import gws.extract.abstract_buttons.OpenButton;
import gws.extract.tool.StaticVar;
import gws.extract.tool.SuperDisplay;
import java.io.File;

/**
 *
 * @author MP
 */
public class DestDirDisplay extends SuperDisplay
{
    /***************************************************************************
     * 
     ***************************************************************************/
    public DestDirDisplay(TransferProperties transferProps)
    {
        super(transferProps);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getIconFileName()
    {
        return "destinationFolder128x128.png";
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getButtonTitle()
    {
        return "Destination Folder";
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected int getOpenType()
    {
        return OpenButton.DIRECTORY;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected void executeAction()
    {
        File file = openButton.getFile();
        fullPath = file.getAbsolutePath();
        String subPath = StaticVar.getSubPath(file.toPath());
        StatusLabel2.setText(StaticVar.HTML_START + subPath + StaticVar.HTML_END);
        if(isFolderValid(fullPath))
        {
            transferProps.targetPath = fullPath;
            transferProps.targetName = subPath;
            transferProps.NextButton.setVisible(true);
        }
        showStatus(true);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private boolean isFolderValid(String filePath)
    {
        boolean isValid = true;
        StatusLabel1.setText("");
        CheckmarkLabel.setVisible(true);
        if(filePath.equals(transferProps.sourcePath))
        {
            CheckmarkLabel.setVisible(false);
            transferProps.targetPath = "";
            transferProps.targetName = "";
            transferProps.NextButton.setVisible(false);
            StatusLabel1.setText(StaticVar.HTML_START + "<font color=red>" + "Cannot be the same as the source folder!" + "</font>" + StaticVar.HTML_END);
            isValid = false;
        }
        return isValid;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected boolean propertiesAreNotReady()
    {
        return transferProps.targetPath.equals("") || transferProps.numFiles == 0;
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected void checkStatus()
    {
        showStatus(false);
        CheckmarkLabel.setVisible(false);
        if(!transferProps.targetPath.equals(""))
        {
            CheckmarkLabel.setVisible(true);
            StatusLabel2.setText(StaticVar.HTML_START + transferProps.targetName + StaticVar.HTML_END);
            showStatus(true);
        }
    }
}
