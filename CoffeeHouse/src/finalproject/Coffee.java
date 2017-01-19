/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Coffee extends JPanel
{
   private JButton calculate, clear, addButton;
   private JLabel finalTotal;
   private JLabel subTotal,tax;
   private JPanel panel2, drinkListPanel;
   private ArrayList<Drink> drinks;
  //private Drink[] drinks = new Drink[5];
   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public Coffee ()
   {
      drinks = new ArrayList();
      
      String[] drinkNames = { "Coffee", "Cappuccino", "Cafe Latte", "Frappuccino",
                                "Expresso"};
       double [] prices = {2.0, 3.0, 5.0, 6.0, 4.0};
       
       drinkListPanel = new JPanel();
       drinkListPanel.setPreferredSize(new Dimension(210, 180));
       
       for (int i = 0; i < drinkNames.length; i++) {
           drinks.add (new Drink(drinkNames[1], prices[i]));
           drinkListPanel.add(drinks.get(i));
       }
       
       
      /*
        * This portion creates the JLabels for the typtes of coffee and prices
       */
      calculate = new JButton ("CALCULATE");
      calculate.addActionListener (new CalcListener());
      subTotal=new JLabel("Subtotal: ");
      tax=new JLabel ("Sales Tax (9%):");
      finalTotal=new JLabel("Your Total: ");
      clear=new JButton("CLEAR");
      clear.addActionListener(new ClearListener());
      
     
      /*
       * Creates the textfields and adds all the labels and prices to the frame
       */
      
      panel2.add(calculate);
      panel2. add (subTotal);
      panel2.add (tax);
      panel2.add (finalTotal);
      panel2.add(clear);
      
      
      
      panel2.setBackground(Color.lightGray);
      subTotal.setHorizontalAlignment(SwingConstants.CENTER);
      tax.setHorizontalAlignment(SwingConstants.CENTER);
      finalTotal.setHorizontalAlignment(SwingConstants.CENTER);
      clear.setHorizontalAlignment(SwingConstants.CENTER);
      add(panel2);

      add(drinkListPanel);
      add(panel2);
      
      addButton = new JButton ("Add new Drink");
      addButton.addActionListener (new
        ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
        String newDrinkName = JOptionPane.showInputDialog("Enter the Drink Name: ");
        double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter price of drink: "));
        drinks.add(new Drink(newDrinkName, newPrice));
        drinkListPanel.setPreferredSize(new Dimension(drinkListPanel.getSize().width, drinkListPanel.getSize().height +35));
        drinkListPanel.add(drinks.get(drinks.size()-1));
        revalidate();
        repaint();
       }
   });
      add(addButton);
      
      setPreferredSize (new Dimension(250, 350));
      setBackground (Color.lightGray);
      
   }

   //*****************************************************************
   //  Represents a listener for button push (action) events.
   //*****************************************************************
   private class CalcListener implements ActionListener
   {
      //--------------------------------------------------------------
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
          
          double total = 0.0;
          for (Drink drink : drinks)
              total+=drink.getTotal();
          
          subTotal.setText("Subtotal: $" + total);
          
         double taxAmount = (total * .09);
         tax.setText("Sales Tax (9%): $"+taxAmount);
         finalTotal.setText("Your Total: $"+total + taxAmount);
         
         
        
         
         
      }
   }
   private class ClearListener implements ActionListener
   {
       public void actionPerformed (ActionEvent event)
      {
         for (Drink drink : drinks)
              drink.clear();
          
          subTotal.setText("Subtotal: ");
          tax.setText("Sales Tax (9%):");
          finalTotal.setText("Your Total: ");
      }
   }
}


