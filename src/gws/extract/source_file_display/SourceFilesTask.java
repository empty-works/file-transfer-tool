/*
 */
package gws.extract.source_file_display;

import gws.extract.beans.TransferProperties;
import gws.extract.libs.NumFileLib;
import gws.extract.tool.StaticVar;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author MP
 */
public class SourceFilesTask extends SwingWorker<Void, Void>
{
    private JProgressBar ScanProgressBar;
    private JLabel StatusLabel, CheckmarkLabel;
    private JPanel OpenFolderButton;
    private TransferProperties transferProps;
    private String fileExt;
    private int fileNumber = 0, paddingNum = 0;
    private double numFiles; 
    private double progress = (fileNumber / numFiles) * 100.0d;
    private File[] files;
    
    /***************************************************************************
     * 
     ***************************************************************************/
    public SourceFilesTask(File[] files, String fileExt)
    {
        this.files = files;
        this.fileExt = fileExt;
        setnumFiles();
        setFileNumPadding();
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void setnumFiles()
    {
        numFiles = (double)files.length;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void  setFileNumPadding()
    {
        paddingNum = NumFileLib.getFileNumPadder(files.length);
    }
    
    /***************************************************************************
     * 
     * @param jpb 
     ***************************************************************************/
    final public void setProgressBar(JProgressBar jpb)
    {
        ScanProgressBar = jpb;
    }
    
    /***************************************************************************
     * 
     * @param jpb 
     ***************************************************************************/
    final public void setStatusLabel(JLabel StatusLabel)
    {
        this.StatusLabel = StatusLabel;
        StaticVar.setStatus(this.StatusLabel, (int)numFiles, fileExt);
    }
    
    /***************************************************************************
     * 
     * @param procMsg 
     ***************************************************************************/
    final public void setProcessingMessage(JPanel openFoldButton)
    {
        OpenFolderButton = openFoldButton;
    }
    
    /***************************************************************************
     * 
     * @param checkmark 
     ***************************************************************************/
    final public void setCheckmark(JLabel checkmark)
    {
        this.CheckmarkLabel = checkmark;
    }
    
    /***************************************************************************
     * 
     * @param transferProps 
     ***************************************************************************/
    final public void setTransferProperties(TransferProperties transferProps)
    {
        this.transferProps = transferProps;
    }

    /***************************************************************************
     * 
     * @return
     * @throws Exception 
     ***************************************************************************/
    @Override
    protected Void doInBackground() throws Exception 
    {
        setProgress(0);
        String path = getPath();
        showTraverseButtons(false);
        for(File file : files)
        {
            if(fileNumber < numFiles)
            {
                if(file.isFile())
                {
                    try
                    {
                        String canonPathString = file.getCanonicalPath();
                        Path canonPath = Paths.get(canonPathString);
                        String fileName = canonPath.getFileName().toString();
                        if(fileName.contains(fileExt))
                        {
                            buildFilesString();
                            final int newProg = updateProgress(numFiles);
                            setProgress(Math.min(newProg, 100));
                        }
                    }
                    catch(IOException e)
                    {

                    }
                }
            }
            else
            {
                break;
            }
        }
        /*
        try
        {
            int maxDepth = 1; // the maximum number of directory levels to visit
            Files.walk(Paths.get(path), maxDepth)
                .forEach(filePath ->
                {
                    if (Files.isRegularFile(filePath))
                    {
                        String file = filePath.getFileName().toString().toLowerCase();
                        if(file.endsWith(fileExt))
                        {
                            final int newProg = updateProgress(numFiles);
                            //displayFileName(file);
                            buildFilesString();
                            setProgress(Math.min(newProg, 100));
                        }
                    }
                }
            );
        }
        catch(IOException e)
        {
            System.out.println("SourceFilesTask - doInBackground error: " + e);
        }
        */
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    public void done() 
    {
        OpenFolderButton.setVisible(true);
        CheckmarkLabel.setVisible(false);
        if(fileNumber != 0)
        {
            StaticVar.setStatus(StatusLabel, files.length, fileExt);
            fileNumber = 0;
            showTraverseButtons(true);
            CheckmarkLabel.setVisible(true);
        }
    }
    
    /***************************************************************************
     * 
     * @param show 
     ***************************************************************************/
    private void showTraverseButtons(boolean show)
    {
        transferProps.NextButton.setVisible(show);
        transferProps.BackButton.setVisible(show);
    }

    /***************************************************************************
     * 
     * @param numFiles
     * @return 
     ***************************************************************************/
    private int updateProgress(double numFiles)
    {
        fileNumber++;
        fileNumber += paddingNum;
        double fileCalc = (fileNumber / numFiles) * 100.0d;
        progress = fileCalc;
        int newNum = (int)progress;
        ScanProgressBar.setValue(newNum);
        return newNum;
    }
        
     /***************************************************************************
     * 
     ***************************************************************************/
    private String getPath()
    {
        File file = files[0];
        String canonPathString = "";
        String filePath = "";
        canonPathString = file.getParent();
        Path canonPath = Paths.get(canonPathString);
        filePath = canonPath.toString();
        return filePath;
    }
    
    /***************************************************************************
     * 
     * @param fileName 
     ***************************************************************************/
    private void displayFileName(String fileName)
    {
        //transferProps.FilesDisplay.append(fileName);
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void buildFilesString()
    {
        StaticVar.setStatus(StatusLabel, fileNumber, fileExt);
    }
}
