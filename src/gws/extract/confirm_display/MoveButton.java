/*
 */
package gws.extract.confirm_display;

import gws.extract.abstract_buttons.ConfirmButton;
import gws.extract.beans.TransferProperties;
import javax.swing.JOptionPane;

/**
 *
 * @author MP
 */
public class MoveButton extends ConfirmButton
{
    /***************************************************************************
     * 
     * @param tp 
     ***************************************************************************/
    public MoveButton(TransferProperties tp)
    {
        super(tp);
        ButtonLabel.setText("Move");
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    protected void doAction()
    {
        int reply = JOptionPane.showConfirmDialog(null, "Warning: this will remove the files from the source folder. Proceed?", 
                                                  "Confirm Move Files", JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION)
        {
            MyTransferHandler tranHand = new MyTransferHandler(transProps, MyTransferHandler.MOVE);
            tranHand.setDataContent();
        }
    }
}
