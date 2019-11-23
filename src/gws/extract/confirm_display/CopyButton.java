/*
 */
package gws.extract.confirm_display;

import gws.extract.abstract_buttons.ConfirmButton;
import gws.extract.beans.TransferProperties;

/**
 *
 * @author MP
 */
public class CopyButton extends ConfirmButton
{
    /***************************************************************************
     * 
     * @param tp 
     ***************************************************************************/
    public CopyButton(TransferProperties tp)
    {
        super(tp);
        ButtonLabel.setText("Copy");
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    protected void doAction()
    {
        MyTransferHandler tranHand = new MyTransferHandler(transProps, MyTransferHandler.COPY);
        tranHand.setDataContent();
    }
}
