package com.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GiftInfo {
    private String name;
    private String info;
    private String urlMarket;
    private Integer price;
    private String urlImage;
}
