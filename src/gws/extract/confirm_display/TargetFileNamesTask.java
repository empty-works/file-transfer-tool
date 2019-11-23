/*
 */
package gws.extract.confirm_display;

import com.opencsv.CSVReader;
import gws.extract.beans.TransferProperties;
import gws.extract.libs.OSSepLib;
import gws.extract.tool.StaticVar;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author MP
 */
public class TargetFileNamesTask extends
            SwingWorker<Void, Void>
{
    final private TransferProperties transProps;

    private String[] lineArray;
    private int numFilesProcessed = 0;
    private CSVReader openCSVReader = null;
    private int transferType = -1;
    private boolean overwriteAll = false;
    private Path sourcePath, targetPath;
    private boolean filesAlreadyExist = false;
    
    /***************************************************************************
     * 
     * @param tp 
     ***************************************************************************/
    public TargetFileNamesTask(CSVReader openCSVReader, TransferProperties tp)
    {
        transProps = tp; 
        this.openCSVReader = openCSVReader;
    }
    
    /***************************************************************************
     * 
     * @param tranType 
     ***************************************************************************/
    final public void setTransferType(int tranType)
    {
        transferType = tranType;
    }

    /***************************************************************************
     * 
     * @return 
     ***************************************************************************/
    @Override
    public Void doInBackground()
    {
        transProps.CopyMoveCon.setVisible(false);
        processCSV();
        return null;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    @Override
    public void done()
    {
        overwriteAll = false; // Reset value.
        transProps.TransferProgressBar.setIndeterminate(false);
        transProps.TransferProgressBar.setValue(100);
        if(numFilesProcessed != 0)
        {
            transProps.TransferProgressBar.setString("Done!");
        }
        else
        {
            if(filesAlreadyExist)
            {
                transProps.TransferProgressBar.setString("Files already transferred!");
            }
            else
            {
                transProps.TransferProgressBar.setString("No files to transfer!");
            } 
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void processCSV()
    {
        try
        {
            while((lineArray = openCSVReader.readNext()) != null)
            {
                if(lineArray.length > 0)
                {
                    for(String fileName : lineArray)
                    {
                        if(!fileName.isEmpty() && fileName.endsWith(transProps.fileType))
                        {
                            moveFile(fileName);
                        }
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("TargetFileNamesTask - doInBackground error: " + e);
        }
    }
    
    /***************************************************************************
     * Method: moveFile
     * @param targetFolderPath 
     ***************************************************************************/
    private void moveFile(final String fileName)
     {
        // First add the searched for file name to the source directory path.
        String sourceFilePath = transProps.sourcePath + OSSepLib.getOSSeparator() + formatFilePath(fileName);
        sourcePath = Paths.get(sourceFilePath);
        targetPath = Paths.get(transProps.targetPath);
        if(sourceFileExists(sourceFilePath))
        { 
            if(targetFileExists(fileName) /*&& overwriteAll == false*/)
            {
                filesAlreadyExist = true;
                //showOverwriteMessage(fileName);
            }
            else
            {
                incrementFileCount();
                displayFiles(fileName);
                transferFile(sourcePath, targetPath);
            }
        }
    }
    
    /***************************************************************************
     * 
     * @param targetPath
     * @return 
     ***************************************************************************/
    private boolean sourceFileExists(String sourceFilePath)
    {
        File sourceFile = new File(sourceFilePath);
        boolean sourceFileExists = sourceFile.getAbsoluteFile().exists();
        return sourceFileExists;
    }
    
    /***************************************************************************
     * 
     * @param targetPath
     * @return 
     ***************************************************************************/
    private boolean targetFileExists(String filename)
    {
        String targetFilePath = transProps.targetPath + OSSepLib.getOSSeparator() + formatFilePath(filename);
        File targetFile = new File(targetFilePath);
        boolean targetFileExists = targetFile.getAbsoluteFile().exists();
        return targetFileExists;
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void showOverwriteMessage(String filename)
    {
        String[] options = new String[] {"Replace", "Replace All Files", "Cancel"};
        int reply = JOptionPane.showOptionDialog(null, filename + " already exists in the destination folder!", "Confirm Overwrite",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        // Where response == 0 for Replace, 1 for Replace All Files, 2 for Escape/Cancel.
        takeOverwriteAction(reply);
    }
    
    /***************************************************************************
     * 
     * @param response 
     ***************************************************************************/
    private void takeOverwriteAction(int reply)
    {
        switch(reply)
        {
            case 0: transferFile(sourcePath, targetPath);
                    break;
            case 1: transferFile(sourcePath, targetPath);
                    overwriteAll = true;
                    break;
            case 2: this.cancel(true);
                    break;
            default: 
        }
    }

    /***************************************************************************
     * 
     * @param sourcePath
     * @param targetPath 
     ***************************************************************************/
    private void transferFile(Path sourcePath, Path targetPath)
    {
        try
        {
            Files.copy(sourcePath, targetPath.resolve(sourcePath.getFileName()), REPLACE_EXISTING);
            // Only use for moving files (copy and delete).
            if(transferType == MyTransferHandler.MOVE)
            {
                Files.delete(sourcePath);
            }
        }
        catch(IOException e)
        {
            System.out.println("TargetFileNamesTask - moveFile error: " + e);
        }
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    private void incrementFileCount()
    {
        if(transProps.NumTransferFilesLabel != null)
        {
            numFilesProcessed++;
            transProps.NumTransferFilesLabel.setText(
                    numFilesProcessed + " " + StaticVar.normalizedFileType(transProps.fileType) + " files transferred!");
        }
    }
    
    /***************************************************************************
     * 
     ***************************************************************************/
    private void displayFiles(String fileName)
    {
        transProps.FilesDisplay.append(fileName);
    }
    
    /***************************************************************************
     * Method: formatFilePath
     * @param fileName
     * @param isAudio
     * @return 
     ***************************************************************************/
    private String formatFilePath(final String fileName)
    {
        String newFileName = fileName;
        if(isAudio() && !fileName.contains(StaticVar.MP3_EXT))
        {
            newFileName = fileName + StaticVar.MP3_EXT;
        }
        else if(!isAudio() && !fileName.contains(StaticVar.IMG_EXT))
        {
            newFileName = fileName + StaticVar.IMG_EXT;
        }
        return newFileName;
    }
    
    /***************************************************************************
     * 
     * @return 
     ***************************************************************************/
    private boolean isAudio()
    {
        return transProps.fileType.equals(StaticVar.MP3_EXT);
    }   
}
