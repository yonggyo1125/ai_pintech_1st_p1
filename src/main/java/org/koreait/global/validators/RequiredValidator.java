package org.koreait.global.validators;

import org.koreait.global.exceptions.BadRequestException;

/**
 * 필수 항목 체크
 *
 */
public interface RequiredValidator {

    /**
     * 문자열 값이 있는지 체크(공백 역시 빈 문자열이라고 판단)
     *
     * @param str : 문자열
     * @param e : 발생 예외
     */
    default void check(String str, BadRequestException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}
