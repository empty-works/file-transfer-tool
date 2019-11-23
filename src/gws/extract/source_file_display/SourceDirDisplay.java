/*
 */
package gws.extract.source_file_display;

import gws.extract.beans.TransferProperties;
import gws.extract.abstract_buttons.OpenButton;
import gws.extract.tool.StaticVar;
import gws.extract.tool.SuperDisplay;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author MP
 */
public class SourceDirDisplay extends SuperDisplay
{
    private File[] files;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public SourceDirDisplay(TransferProperties transferProps)
    {
        super(transferProps);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getIconFileName()
    {
        return "sourceFolder128x128.png";
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected String getButtonTitle()
    {
        return "Source Folder";
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
        hideSuccessIndicators();
        File file = openButton.getFile();
        fullPath = file.getAbsolutePath();
        String subPath = StaticVar.getSubPath(file.toPath());
        StatusLabel2.setText(StaticVar.HTML_START + subPath + StaticVar.HTML_END);
        if(isFolderValid(fullPath))
        {
            transferProps.sourcePath = fullPath;
            transferProps.sourceName = subPath;
            System.out.println(transferProps.sourceName);
            displayTargetFolderFiles(fullPath, transferProps.fileType);
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private boolean isFolderValid(String filePath)
    {
        boolean isValid = true;
        StatusLabel1.setText("");
        CheckmarkLabel.setVisible(true);
        if(filePath.equals(transferProps.targetPath))
        {
            CheckmarkLabel.setVisible(false);
            transferProps.sourcePath = "";
            transferProps.sourceName = "";
            transferProps.NextButton.setVisible(false);
            StatusLabel1.setText(StaticVar.HTML_START + "<font color=red>" + "Cannot be the same as the destination folder!" + "</font>" + StaticVar.HTML_END);
            isValid = false;
        }
        return isValid;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void hideSuccessIndicators()
    {
        CheckmarkLabel.setVisible(false);
        transferProps.NextButton.setVisible(false);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected boolean propertiesAreNotReady()
    {
        return transferProps.sourcePath.equals("") || transferProps.numFiles == 0;
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    protected void checkStatus()
    {
        showStatus(false);
        if(!transferProps.sourcePath.equals(""))
        {
            if(transferProps.numFiles > 0)
            {
                CheckmarkLabel.setVisible(true);
            }
            StaticVar.setStatus(StatusLabel1, transferProps.numFiles, transferProps.fileType);
            StatusLabel2.setText(StaticVar.HTML_START + transferProps.sourceName + StaticVar.HTML_END);
            showStatus(true);
        }
    }
    
    /***************************************************************************
     * Method: displayTargetFolderFiles
     * @param directoryPath
     * @param isAudio 
     ***************************************************************************/
    private void displayTargetFolderFiles(final String directoryPath, 
                                          final String fileExt)
    {
        File selectedDirectory = new File(directoryPath);
        files = applyNameFilter(selectedDirectory, fileExt);
        transferProps.numFiles = files.length;
        runFileDisplay();
    }
    
    /***************************************************************************
     * 
     * @param selectedDirectory
     * @return 
     ***************************************************************************/
    private File[] applyNameFilter(File selectedDirectory, String fileExt)
    {
        return selectedDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(fileExt);
            }
        }); 
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    final public void runFileDisplay()
    {
        resetProgressBar();
        showStatus(true);
        SourceFilesTask sourceTask = new SourceFilesTask(files, transferProps.fileType);
        sourceTask.setProgressBar(ScanProgressBar);
        sourceTask.setStatusLabel(StatusLabel1);
        sourceTask.setProcessingMessage(openButton);
        sourceTask.setTransferProperties(transferProps);
        sourceTask.setCheckmark(CheckmarkLabel);
        openButton.setVisible(false);
        sourceTask.execute();
    }
}
