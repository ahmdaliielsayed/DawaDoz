package com.example.dawadoz.db.entity.searchproducts;

public class Product {

    private int PageNumber;
    private int RowspPage;

    public Product () { }

    public Product(int pageNumber, int rowspPage) {
        PageNumber = pageNumber;
        RowspPage = rowspPage;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getRowspPage() {
        return RowspPage;
    }

    public void setRowspPage(int rowspPage) {
        RowspPage = rowspPage;
    }
}
