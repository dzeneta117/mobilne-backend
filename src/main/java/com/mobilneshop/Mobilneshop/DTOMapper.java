package com.mobilneshop.Mobilneshop;

public interface DTOMapper<T,C>{
    public <T> T apply(C item);
}
