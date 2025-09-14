package com.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WishInfo {
    private String name;
    private String info;
}
