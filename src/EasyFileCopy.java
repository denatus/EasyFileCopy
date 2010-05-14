/**
 *
 * @author Kjeld K. B. Massali <kjeldkarim@gmail.com>
 */

import DomainLogic.*;
import Presentation.*;

public class EasyFileCopy {
    /**
     * Main entry point for the application
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FileHandlingLibrary fileDomainModel = new FileHandlingLibrary();
                SocketHandlingLibrary socketDomainModel = new SocketHandlingLibrary();
                new MainGui(fileDomainModel, socketDomainModel).setVisible(true);
            }
        });
    }
}
