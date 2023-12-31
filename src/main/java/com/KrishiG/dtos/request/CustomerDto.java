package com.KrishiG.dtos.request;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private Long id;

    private String fullName;

    private String mobileNo;

    private String gender;

    private List<CustomerAddressDto> address;

    private Long createdBy;

    private Date createdAt;

    private Long modifiedBy;

    private Date modifiedAt;
}
