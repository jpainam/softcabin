
package org.softcabin.desktop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import org.openide.awt.StatusLineElementProvider;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Ainam Jean-Paul
 * Date of creation : 8 July 2013
 * This class display the clock at the bottom of the window
 * The username of the connected user will also be displayed
 */
@ServiceProvider( service = StatusLineElementProvider.class)
public class StatusLineClock implements StatusLineElementProvider{
   private static final DateFormat format =
      DateFormat.getTimeInstance(DateFormat.MEDIUM);
   private static JLabel time = new JLabel(
      " " + format.format(new Date()) + " ");
   private JPanel panel = new JPanel(new BorderLayout());

   public StatusLineClock() {
      Timer t = new Timer(1000, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            time.setText(" " + format.format(new Date()) + " ");
         }
      });
      t.start();
      panel.add(new JSeparator(SwingConstants.VERTICAL),
                BorderLayout.WEST);
      panel.add(time, BorderLayout.CENTER);
   }

   @Override
   public Component getStatusLineElement() {
      return(panel);
   }
}