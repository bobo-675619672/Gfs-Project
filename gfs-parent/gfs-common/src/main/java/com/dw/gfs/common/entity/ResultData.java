package com.dw.gfs.common.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultData<T> {
    public int code;
    public T data;
    public String msg;
}
