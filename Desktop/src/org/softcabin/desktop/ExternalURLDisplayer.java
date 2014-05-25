package org.softcabin.desktop;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.awt.HtmlBrowser;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Ainam Jean-Paul
 * Date of creation : 8 July 2013
 * This class launch the default browser  when an URL is clicked
 * instead of the default IDE integrated into the net-beans
 */
@ServiceProvider (service = HtmlBrowser.URLDisplayer.class, position = 0)
public class ExternalURLDisplayer extends HtmlBrowser.URLDisplayer{

    @Override
    public void showURL(URL url) {
        try {
            Desktop.getDesktop().browse(url.toURI());
        }catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, null, ex);
            Exceptions.printStackTrace(ex);
        }
    }
}
