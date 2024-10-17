package org.koreait.product.controllers;

import org.koreait.global.Controller;
import org.koreait.global.libs.Utils;
import org.koreait.product.templates.ProductList;

/**
 * 상품 목록
 *
 */
public class ProductListController extends Controller {
    @Override
    public void view() {
        Utils.loadTpl(ProductList.class);
    }
}
