/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agustin
 */

import java.awt.BorderLayout;
import javax.swing.JLabel; 
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.Border; 
import java.awt.Color;
import java.awt.Container;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;


public class JuegoGui extends Vida{
    
    private JFrame frame;
    private GraphCanvas canvas;
    private int tamano;
    private int tamanoCanvas;
    private int tamanoCeldas;
    
    public JuegoGui(int tmn, int tmnCeldas){
        super(tmn);
        tamano=tmn;
        tamanoCeldas=tmnCeldas;
        tamanoCanvas=tamano*10;
        
        
        
        crearFrame(tamano);
        crearCanvas(tamanoCanvas);
        
        
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
        canvas.actGraf(super.actual);

        while(true){
            try {
                Thread.sleep(125);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            super.actualizarEstado();
            canvas.actGraf(super.actual);
        }
        
    }
    
    private void crearFrame(int tmn){
        frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Juego de la vida");
    }
    
    private void crearCanvas(int tmn){
        canvas=new GraphCanvas(tamano,tamanoCeldas,tamanoCanvas);
        canvas.setSize(tmn,tmn);
        //canvas.setBounds(((tamanoCanvas+100)/2) - (tamanoCanvas/2) , ((tamanoCanvas+100)/2) - (tamanoCanvas/2), tamanoCanvas, tamanoCanvas);
    }
    
    
    
    
} //Fin clase
