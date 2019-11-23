/*
 */
package gws.extract.source_file_display;

import java.io.File;
import java.nio.file.Path;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

/**
 *
 * @author MP
 */
public class StringDisplay 
{
    static void buildFilesString(Path path, JLabel StatusLabel, DefaultStyledDocument document, int numFilesProcessed)
    {
        File f = path.toAbsolutePath().toFile();
        String fileName = f.getName();
        try
        {
            document.insertString(document.getLength(), 
                                  fileName, null);
            StatusLabel.setText("" + numFilesProcessed++);
        }
        catch(BadLocationException e)
        {
            e.printStackTrace();
        }
    }
}
