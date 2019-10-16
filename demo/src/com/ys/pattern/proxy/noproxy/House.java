package com.ys.pattern.proxy.noproxy;

public class House {
    private String addr;
    private String area;
    private String type;
    private double price;

    public House(String addr, String area, String type, double price) {
        this.addr = addr;
        this.area = area;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "addr='" + addr + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
