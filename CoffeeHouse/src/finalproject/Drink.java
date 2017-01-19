/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author k11002227
 */
public class Drink extends JPanel {
    private double price;
    private JTextField amount;
    private String name;
    private JLabel priceLabel;
    
    public Drink (String name, double price) {
        this.name = name;
        this.price = price;
        amount = new JTextField(3);
        priceLabel = new JLabel ("$" + price);
        
        setPreferredSize(new Dimension(200, 30));
        JLabel nameLabel = new JLabel(name);
        nameLabel.setPreferredSize(new Dimension(120, 27));
        add(nameLabel);
        add(amount);
        add(priceLabel);
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice () {
        return price;
    }
    
    public int getAmount () {
        try {
             int result;
             result = Integer.parseInt(amount.getText());
             return result;
        }
        catch (NumberFormatException nFE) {
            return 0;
        }
    }
    
    public double getTotal() {
        return price * getAmount();
    }
    
    public void clear() {
        amount.setText("");
    }
            
}
