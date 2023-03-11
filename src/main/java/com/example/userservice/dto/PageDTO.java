package com.example.userservice.dto;

import java.util.List;

public class PageDTO<T> {
    private int number;
    private int size;
    private int total_pages;
    private long total_elements;
    private boolean first;
    private int number_of_elements;
    private boolean last;
    private List<T> content;

    public PageDTO(int number,
                int size,
                int total_pages,
                long total_elements,
                boolean first,
                int number_of_elements,
                boolean last,
                List<T> content) {
        this.number = number;
        this.size = size;
        this.total_pages = total_pages;
        this.total_elements = total_elements;
        this.first = first;
        this.number_of_elements = number_of_elements;
        this.last = last;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public long getTotal_elements() {
        return total_elements;
    }

    public boolean isFirst() {
        return first;
    }

    public int getNumber_of_elements() {
        return number_of_elements;
    }

    public boolean isLast() {
        return last;
    }

    public List <T> getContent() {
        return content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_elements(int total_elements) {
        this.total_elements = total_elements;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setNumber_of_elements(int number_of_elements) {
        this.number_of_elements = number_of_elements;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setContent(List <T> content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "PageOfUser{" +
                "number=" + number +
                ", size=" + size +
                ", total_pages=" + total_pages +
                ", total_elements=" + total_elements +
                ", first=" + first +
                ", number_of_elements=" + number_of_elements +
                ", last=" + last +
                ", content=" + content +
                '}';
    }
}
