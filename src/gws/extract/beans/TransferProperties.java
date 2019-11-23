/*
 */
package gws.extract.beans;

import gws.extract.abstract_buttons.TraverseButton;
import gws.extract.tool.FilesDisplay;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author MP
 */
public class TransferProperties 
{
    public String fileType = "";
    public String sourcePath = "";
    public String sourceName = "";
    public int    numFiles = 0;
    public String csvPath = "";
    public String csvName = "";
    public String targetPath = "";
    public String targetName = "";
    public TraverseButton NextButton;
    public TraverseButton BackButton;
    public FilesDisplay FilesDisplay;
    public JLabel NumTransferFilesLabel;
    public JProgressBar TransferProgressBar;
    public JPanel CopyMoveCon;
    
    final public void resetValues()
    {
        fileType = "";
        sourcePath = "";
        numFiles = 0;
        csvPath = "";
        targetPath = "";
    }
}
