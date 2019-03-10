package capturarcaracter;

import javax.swing.*;
import java.awt.event.*;
import clases.LibreriaCaracter;

public class CapturarCaracter extends JFrame{
    
    
    public CapturarCaracter(){
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        setLocation(200, 100);
        setTitle("¿Mayuscula o Minuscula?");
        
        JList lista = new JList();
        JScrollPane scroll = new JScrollPane(lista);
        JLabel etiqueta1 = new JLabel("Ingresa un caracter");
        JTextField campo1 = new JTextField();
        JLabel res1 = new JLabel("La letra es: ");
        
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        DefaultListModel dlm = new DefaultListModel();
        dlm.addElement("Letra mayúscula");
        dlm.addElement("Letra minuscula");
        lista.setModel(dlm);
        
        add(scroll); scroll.setBounds(300, 20, 150, 60);
        add(etiqueta1); etiqueta1.setBounds(10, 20, 200, 40);
        add(campo1); campo1.setBounds(140, 20, 100, 30);
        add(res1); res1.setBounds(10, 70, 300, 40);
        
        LibreriaCaracter lc = new LibreriaCaracter();
        
        campo1.addKeyListener(new KeyListener(){

            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                
                int l = e.getKeyCode();
                
                if(l == 10){
                    String letra = campo1.getText();
                    
                    if(lista.isSelectedIndex(0)){
                    lc.setLetra(letra);
                    res1.setText("La letra " + lc.getLetra() + " " + lc.esLetraMayuscula());
                    }else if(lista.isSelectedIndex(1)){
                        lc.setLetra(letra);
                        res1.setText("La letra " + lc.getLetra() + " " + lc.esLetraMinuscula());
                    }
                    
                }
                
            }
            
            public void keyReleased(KeyEvent e) {}
        });
        
    }

    public static void main(String[] args) {
        CapturarCaracter cc = new CapturarCaracter();
    }
    
}
