package org.koreait.product.entities;

/**
 * 상품 정보를 담는 데이터 클래스 정의
 *
 */
public class Product {
    private long seq;
    private String name;
    private int price;
    private int stock;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
