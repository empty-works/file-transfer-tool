/*
 */
package gws.extract.confirm_display;

import gws.extract.abstract_buttons.ConfirmButton;
import gws.extract.beans.TransferProperties;

/**
 *
 * @author MP
 */
public class RestartButton extends ConfirmButton
{
    /***************************************************************************
     * 
     * @param tp 
     ***************************************************************************/
    public RestartButton(TransferProperties tp)
    {
        super(tp);
        ButtonLabel.setText("Restart");
    }

    /***************************************************************************
     * 
     ***************************************************************************/
    protected void doAction()
    {
        transProps.resetValues();
    }
}
