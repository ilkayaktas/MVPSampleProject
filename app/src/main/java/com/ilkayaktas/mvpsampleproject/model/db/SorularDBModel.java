package com.ilkayaktas.mvpsampleproject.model.db;

import lombok.Data;

import java.util.UUID;

/**
 * Created by ilkayaktas on 13.06.2018 at 01:16.
 * This class is used to retrieve data from database. It will converted SorularAppModel.
 */
@Data
public class SorularDBModel {
    public String id;
    public String soru;

    public SorularDBModel() {
        id = UUID.randomUUID().toString();
        soru = "Soru from DB" + id;
    }
}
