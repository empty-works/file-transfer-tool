/*
 * Class for static variables.
 */
package gws.extract.tool;

import java.nio.file.Path;
import javax.swing.JLabel;

/**
 * @author MP
 */
public class StaticVar 
{
    final public static String DATA_DIR = "data";
    final public static String AUDIO_FILES_DIR = "transferred_files_audio",
                               IMAGE_FILES_DIR = "transferred_files_image";
    final public static String AUDIO_FILENAME = "Audiofiles Wortebene aus GWS.csv",
                               IMAGE_FILENAME = "Images Wortebene aus GWS.csv";
    final public static String MP3_EXT = ".mp3",
                               IMG_EXT = ".jpg";
    final public static String HTML_START = "<html>";
    final public static String HTML_END = "</html>";
    
    final public static void setStatus(JLabel statusLabel, int numFilesProcessed, String fileExt)
    {
        String newFileExt = normalizedFileType(fileExt);
        switch(numFilesProcessed)
        {
            case 0: statusLabel.setText(HTML_START + "<font color=red>" + "No " + newFileExt + " files found in:" + "</font>" + HTML_END);
                    break;
            case 1: statusLabel.setText(numFilesProcessed + " " + newFileExt + " file in:");
                    break;
            default: statusLabel.setText(numFilesProcessed + " " + newFileExt + " files in:");
        }
    }
    
    final public static String normalizedFileType(String fileExt)
    {
        String newFileExt = fileExt.replace(".", "");
        newFileExt = newFileExt.toUpperCase();
        return newFileExt;
    }
    
    final public static String getSubPath(Path path)
    {
        final int len = path.getNameCount();
        Path newPath = path.subpath(len - 2, len);
        String newPathStr = "\\...\\" + newPath.toString();
        return newPathStr;
    }
}
