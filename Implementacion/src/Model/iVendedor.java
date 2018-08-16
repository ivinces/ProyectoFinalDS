/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fanny
 */
public class iVendedor {
    public boolean ocupado;
    public iVendedor next;
    public iVendedor(){
        this.next=new iVendedor();
    }
    
}
