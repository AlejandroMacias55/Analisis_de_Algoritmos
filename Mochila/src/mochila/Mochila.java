/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Macias
 */
public class Mochila {

    private final ArrayList listaCosas;
    private final int[][] matrizValores;
    
    public Mochila(int pesoMochila, int cantidadCosas){
        listaCosas=new ArrayList <>();
        matrizValores=new int [cantidadCosas+1][pesoMochila+1];
        
    }
    
    public int valorMaximo(int icosa, int mochilaPeso){
        if(icosa<0||mochilaPeso<0){//si son los 2 cero
            return 0;
        }
        
        if (matrizValores[icosa][mochilaPeso]>0){
            return matrizValores[icosa][mochilaPeso];
           }
        int cosaActual[]=(int []) listaCosas.get(icosa);
        int cosaPeso=cosaActual[0];
        int cosaBeneficio=cosaActual[1];
        
        if(cosaPeso>mochilaPeso){//si la cosa se exede a la capacidad
            matrizValores[icosa][mochilaPeso]=valorMaximo(icosa-1, mochilaPeso);
            return matrizValores[icosa][mochilaPeso];
            
        }
        matrizValores[icosa][mochilaPeso]=Math.max(valorMaximo(icosa-1,mochilaPeso), valorMaximo(icosa-1,mochilaPeso-cosaPeso)+cosaBeneficio);
        return matrizValores[icosa][mochilaPeso];
    }
    
    public void agregarCosa(int peso, int beneficio){
        int cosa[]=new int [2];//creamos nuestra cosa tiene peso y beneficio 
        cosa[0]=peso;//posicion 0 es el peso
        cosa[1]=beneficio;//posicion 1 es el beneficio
        listaCosas.add(cosa);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mochila m=new Mochila(10, 20);
        m.agregarCosa(2, 5);
        m.agregarCosa(6, 7);
        m.agregarCosa(8, 2);
        m.agregarCosa(2, 4);
        System.out.println(m.valorMaximo(1, 15));
        
       
        
    }
    
}
