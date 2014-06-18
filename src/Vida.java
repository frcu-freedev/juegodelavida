/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agustin
 */

import javax.swing.JLabel; 
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.Border; 
import java.awt.Color;
import java.awt.Container;


public class Vida {
    
    private int tamano;
    private boolean matriz[][];
    protected boolean actual[][];
    
    public Vida(int tmn){
        tamano=tmn;
        matriz= new boolean[tamano][tamano];
        actual= new boolean[tamano][tamano];
        inicializarMatriz(actual);
        
        //planeador(25);
        
        //acorn(25);
        //acorn(10);
        //acorn(40);
        
        creceIndef(10,10);
        creceIndef(60,10);
        creceIndef(10,60);
        creceIndef(60,60);
        
        
        
    }
    
    
    private void inicializarMatriz(boolean matriz[][]){
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                matriz[i][j]=false;
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
    
    protected void actualizarEstado(){
        int vivos;
        int icom;
        int ifin;
        int jcom;
        int jfin;
        igualarMatriz(matriz,actual);
        
        
        
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){  //Bucle para cada elemento
                
                vivos=0;
                
                
                //Comprobacion si el elemento se encuentra en la esquina
                icom= i-1;
                ifin= i+1;
                
                jcom= j-1;
                jfin=j+1;
                
                if(i==0){
                    icom=i;
                }
                else if(i==tamano-1){
                    ifin= i;
                }
                
                
                
                if(j==0){
                    jcom=j;
                }
                else if(j==tamano-1){
                    jfin= j;
                }
               
                
                //////////////////////////////
                //Bucle de analisis de alrededores
                for(int k=icom;k<=ifin;k++){
                    for(int l=jcom;l<=jfin;l++){
                        //System.out.print(k+"-"+l+"/");
                        if(matriz[k][l]){
                            if(k!=i || l!=j){
                                vivos++;
                            }
                        }
                            
                    }
                }
                
                
                //System.out.print("i="+i+". j="+j+". Vivos="+vivos+".\n\r");
                
                //////////////////////////////
                
                //en base a la cant de vivos o muertos decido el valor de la
                //celda y lo asigno a otra matriz
                if(matriz[i][j]){ //si esta viva
                    if(vivos==2 || vivos==3)
                        actual[i][j]=true;
                    else
                        actual[i][j]=false;
                }
                else if(vivos==3)
                    actual[i][j]=true; //si esta muerta

                
            }
        } //fin de bucle de analisis de cada elemento de la matriz.
        
    }
    
    
    //algoritmos para asignar a matriz valores
    private void planeador(int i){
        actual[i][i]=true;
        actual[i][i+1]=true;
        actual[i][i+2]=true;
        actual[i-1][i+1]=true;
        actual[i+2][i+1]=true;
    }
    
    private void acorn(int i){
        actual[i][i+1]=true;
        actual[i+1][i+3]=true;
        actual[i+2][i]=true;
        actual[i+2][i+1]=true;
        actual[i+2][i+4]=true;
        actual[i+2][i+5]=true;
        actual[i+2][i+6]=true;

    }
    
    private void creceIndef(int i,int j){
        actual[i][j]=true;
        actual[i][j+1]=true;
        actual[i][j+2]=true;
        actual[i][j+4]=true;
        
        actual[i+1][j]=true;
        
        actual[i+2][j+3]=true;
        actual[i+2][j+4]=true;
        
        actual[i+3][j+1]=true;
        actual[i+3][j+2]=true;
        actual[i+3][j+4]=true;
        
        actual[i+4][j]=true;
        actual[i+4][j+2]=true;
        actual[i+4][j+4]=true;
        
    }
    
} //Fin Clase
