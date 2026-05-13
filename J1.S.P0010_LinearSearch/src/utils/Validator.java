/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
/**
 *
 * @author win
 */
public class Validator {
    private Validator(){
        
    }
    /**
     * Validates if a string input is a valid integer within a specific range.
     *
     * @param input the string input to be validated.
     * @param min the minimum allowable value.
     * @param max the maximum allowable value.
     * @return the parsed integer if validation is successful.
     * @throws Exception if the input is not a number or is out of the specified
     * range.
     */
    public static int validateInt(String input, int min, int max) throws Exception {
        try {
            int number = Integer.parseInt(input.trim());
            if (number < min || number > max) {
                throw new Exception("Number is out of range [" + min + ", " + max + "].");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Invalid input! Please enter a valid integer.");
        }
    }
}
