package org.koreait.global.validators;

/**
 * 자료형 체크
 *
 */
public interface TypeValidator {
    default boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}