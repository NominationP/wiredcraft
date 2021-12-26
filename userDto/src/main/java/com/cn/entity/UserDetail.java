package com.cn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    private int id;

    @NotNull(message = "name is not null")
    @Size(max = 60, min = 3)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotNull(message = "dob is not null")
    private Date dob;

    @NotNull(message = "address is not null")
    @Size(max = 128, message = "address max length is 120")
    private String address;

    @NotNull(message = "description is not null")
    @Size(max = 256, message = "description max length is 120")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdAt;

}
