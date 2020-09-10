package com.tazkia.moodlesmile.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Entity
public class MdlEnrol {

    @Id
    private BigInteger id;
}
