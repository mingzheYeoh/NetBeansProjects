/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical3;

/**
 *
 * @author mingzhe
 */
public class Password {
    private String passwordStr;

    public Password(String passwordStr) throws InvalidPasswordException {
        if (passwordStr == null || passwordStr.equals("")) {
            throw new InvalidPasswordException("Invalid password: password cannot be null or an empty string.");
        } else {
            int countDigits = 0;
            int countLetters = 0;

            for (int i = 0; i < passwordStr.length(); ++i) {
                char ch = passwordStr.charAt(i);
                if (Character.isDigit(ch)) {
                    countDigits++;
                } else if (Character.isLetter(ch)) {
                    countLetters++;
                }
            }
            int countAlphaNumeric = countDigits + countLetters;

            String errMsg = "";
            if (countDigits == 0) {
                errMsg += "Your password should have at least 1 digit.\n";
            }

            if (countLetters == 0) {
                errMsg += "Your password should have at least 1 letter.\n";
            }

            if (countAlphaNumeric < 7) {
                errMsg += "Your password should have at least 7 alpha-numeric characters.\n";
            }

            if (!errMsg.equals("")) {
                throw new InvalidPasswordException(errMsg);
            }
        }
        this.passwordStr = passwordStr;
    }
}
