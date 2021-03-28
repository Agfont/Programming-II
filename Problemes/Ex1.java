/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author SERGIO
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Day myDay = new Day (11,30,0);
        Day anotherDay = myDay;
        
        System.out.println("Day before the method: " + myDay.getHour() + ":” + "
                + myDay.getMinute() + ":" + myDay.getSecond());
                            
        changeValueReferenceType(myDay);
    
        System.out.println("Day after the method: " + myDay.getHour() + ":” +"
                + myDay.getMinute() + ":" + myDay.getSecond());
        
        System.out.println("Day after the method: " + anotherDay.getHour() + ":” +"
                + anotherDay.getMinute() + ":" + anotherDay.getSecond());
    }
    public static void changeValueReferenceType(Day oneDay){
        oneDay.setHour(24);
        oneDay.setMinute(24);
        oneDay.setSecond(24);
    }
}
