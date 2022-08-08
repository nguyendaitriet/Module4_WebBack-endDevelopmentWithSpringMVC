package com.banking.model;

import com.banking.model.dto.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name="locations")
public class Location extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String provinceName;

    @Column(nullable = false)
    private String districtId;

    @Column(nullable = false)
    private String districtName;

    @Column(nullable = false)
    private String wardId;

    @Column(nullable = false)
    private String wardName;

    @Column(length = 300)
    private String address;

    @OneToOne(mappedBy = "location")
    private Customer customer;

    public LocationDTO toLocationDTO() {
        return new LocationDTO()
                .setProvinceId(this.provinceId)
                .setProvinceName(this.provinceName)
                .setDistrictId(this.districtId)
                .setDistrictName(this.districtName)
                .setWardId(this.wardId)
                .setWardName(this.wardName)
                .setAddress(this.address);
    }
}
