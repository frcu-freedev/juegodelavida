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


public class GraphCanvas extends Canvas {

    private int tamano;
    private int tamanoCeldas;
    private int tamanoCanvas;
    private boolean matriz[][];
    
    public GraphCanvas(int tmn,int tmnCeldas,int tmnCanvas){
        super();
        tamano=tmn;
        tamanoCeldas=tmnCeldas;
        tamanoCanvas=tmnCanvas;
        matriz= new boolean[tamano][tamano];
    }
    
    public void paint(Graphics g) {
        dibMatriz(g);
        dibCuad(g);
        
     /*
        g.setColor(Color.black);
        g.drawLine(0, 0, i, i);
        g.drawRect(0,0, i, i);
        i++;
      */
    }
    
    public void actGraf(boolean mat[][]){
        igualarMatriz(matriz,mat);
        this.repaint();
    }
    
    private void dibCuad(Graphics g){
        g.setColor(Color.black);
        for(int i=0;i<=tamanoCanvas;i+=tamanoCeldas){
            g.drawLine(0, i, tamanoCanvas, i);
            g.drawLine(i, 0, i, tamanoCanvas);
        }
    }
    
    private void dibMatriz(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                if(matriz[i][j]){
                    g.fillOval(j*tamanoCeldas, i*tamanoCeldas, tamanoCeldas, tamanoCeldas);
                }
            }
        }
        
    }
    
    private void igualarMatriz(boolean dest[][],boolean orig[][]){
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                if(orig[i][j])
                    dest[i][j]=true;
                else
                    dest[i][j]=false;
            }
        }
    }
}
