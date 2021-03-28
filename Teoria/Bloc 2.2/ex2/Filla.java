/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2.tema2;

/**
 *
 * @author sergiosayago
 */
public class Filla extends Pare {
    @Override
    public void suma_a_i(int j){
        j = this.getI() + (j/2);
        super.suma_a_i(j);
    }
}
