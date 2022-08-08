package com.banking.model.dto;

import com.banking.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LocationDTO {

    private Long id;

    @NotNull(message = "Province ID must NOT be empty.")
    private String provinceId;

    @NotEmpty(message = "Province name must NOT be empty.")
    private String provinceName;

    @NotNull(message = "District ID must NOT be empty.")
    private String districtId;

    @NotEmpty(message = "District name must NOT be empty.")
    private String districtName;

    @NotNull(message = "Ward ID must NOT be empty.")
    private String wardId;

    @NotEmpty(message = "Ward name must NOT be empty.")
    private String wardName;

    @Column(length = 300)
    private String address;

    public Location toLocation() {
        return new Location()
                .setProvinceId(this.provinceId)
                .setProvinceName(this.provinceName)
                .setDistrictId(this.districtId)
                .setDistrictName(this.districtName)
                .setWardId(this.wardId)
                .setWardName(this.wardName)
                .setAddress(this.address);
    }
}
