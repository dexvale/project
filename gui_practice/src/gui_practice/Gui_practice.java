/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package gui_practice;
import javax.swing.JOptionPane;
public class Gui_practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name = JOptionPane.showInputDialog("Enter you name: ");
        JOptionPane.showMessageDialog(null, "Hello "+name);
        
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter you age: "));
        JOptionPane.showMessageDialog(null, "You age " + age+ " years old");
        
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height: "));
        JOptionPane.showMessageDialog(null,"your are "+ height+ "cm tall" );
        
        JOptionPane.showMessageDialog(null, "Thank you");
        
    }
    
}


