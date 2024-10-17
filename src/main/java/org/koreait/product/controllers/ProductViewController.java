package org.koreait.product.controllers;

import org.koreait.global.Controller;
import org.koreait.global.libs.Utils;
import org.koreait.product.templates.ProductView;

/**
 * 상품 상세 보기
 *
 */
public class ProductViewController extends Controller {

    @Override
    public void view() {
        Utils.loadTpl(ProductView.class);
    }
}
