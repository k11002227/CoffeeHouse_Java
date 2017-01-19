/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import javax.swing.JFrame;

public class FinalProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame frame=new JFrame ("COFFEE");
       frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       
       frame.getContentPane().add(new Coffee());

      frame.pack();
      frame.setVisible(true);

       
    
        
        
        
    }
}
