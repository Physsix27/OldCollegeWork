/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Starlyn
 */
public class OnesInBinaryNumber {
    
    
    public static int ones(int number){
        int sum = 0;
        
        while(number != 0) {
            // WORK GOES HERE //
            
            sum++;
        }
        
        return sum;
    }
    
    public static void main(String[] args){
        
        System.out.println(ones(1110011));
    }
}
