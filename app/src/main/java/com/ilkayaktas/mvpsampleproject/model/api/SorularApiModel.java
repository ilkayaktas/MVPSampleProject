package com.ilkayaktas.mvpsampleproject.model.api;

import lombok.Data;

import java.util.UUID;

/**
 * Created by ilkayaktas on 13.06.2018 at 01:16.
 * This class is used to retrieve data from remote server. It will converted SorularAppModel.
 */
@Data
public class SorularApiModel {
    public String id;
    public String soru;

    public SorularApiModel() {
        id = UUID.randomUUID().toString();
        soru = "Soru from Api " + id;
    }
}
