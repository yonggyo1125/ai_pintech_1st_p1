package org.koreait.product.templates;

import org.koreait.global.Template;

/**
 * 상품 목록 템플릿
 *
 */
public class ProductList implements Template {

    @Override
    public void print() {
        System.out.println("상품 목록 출력...");
    }
}
