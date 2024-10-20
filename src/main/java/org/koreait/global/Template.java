package org.koreait.global;

/**
 * 출력 화면 Template 기본 구성
 *
 */
public interface Template {
    void print();
    default void setData(Object data) {};  // 뷰에서 출력할 데이터가 있는 경우 설정
}
