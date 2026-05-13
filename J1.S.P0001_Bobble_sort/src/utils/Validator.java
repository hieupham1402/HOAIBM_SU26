/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author MinhHieu
 */
public class Validator {

    private Validator() {
    }

    /**
     * Validates if the input string is a valid integer within a specified
     * range.
     *
     * @param input the string to be parsed.
     * @param min the minimum allowed value.
     * @param max the maximum allowed value.
     * @return the validated integer.
     * @throws Exception if input is not a number or is out of range.
     */
    public static int validateInt(String input, int min, int max) throws Exception {
        try {
            int number = Integer.parseInt(input.trim());
            if (number < min || number > max) {
                throw new Exception("Number must be in range [" + min + ", " + max + "].");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Invalid format! Please enter an integer.");
        }
    }

    /**
     * Validates if the input string is a valid double within a specified range.
     *
     * @param input the string to be parsed.
     * @param min the minimum allowed value.
     * @param max the maximum allowed value.
     * @return the validated double.
     * @throws Exception if input is not a number or is out of range.
     */
    public static double validateDouble(String input, double min, double max) throws Exception {
        try {
            double number = Double.parseDouble(input.trim());
            if (number < min || number > max) {
                throw new Exception("Value must be in range [" + min + ", " + max + "].");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Invalid format! Please enter a numeric value.");
        }
    }

    /**
     * Validates if the input string matches a specific regular expression.
     *
     * @param input the string to be checked.
     * @param regex the regular expression pattern.
     * @return the input string if it matches the pattern.
     * @throws Exception if the input does not match the pattern.
     */
    public static String validateString(String input, String regex) throws Exception {
        if (input == null || !input.trim().matches(regex)) {
            throw new Exception("Input does not match the required format.");
        }
        return input.trim();
    }
}
