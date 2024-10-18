package org.koreait.product.controllers;

import org.koreait.global.Controller;
import org.koreait.global.libs.Utils;
import org.koreait.product.templates.ProductForm;

/**
 * 상품 등록/수정 컨트롤러
 *
 */
public class ProductController extends Controller {

    public ProductController() {
        setInputProcess(input -> {
            System.out.println(input);
        });
    }

    @Override
    protected String getPromptText() {
        return "등록할 상품 정보를 입력하세요.";
    }

    @Override
    public void view()  {
        Utils.loadTpl(ProductForm.class);
    }
}
