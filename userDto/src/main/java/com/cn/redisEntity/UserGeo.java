package com.cn.redisEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGeo implements Serializable {
    /*
    why use specific userId && userName or not get current use ?
     */
    private int userId;
    private String username;
    private double latitude;
    private double longitude;
}
