package com.zero.goods.domain;

import javax.persistence.*;

@Table(name = "goods_baseinfo")
public class GoodsBaseinfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FILE_CD")
    private String fileCd;

    /**
     * @return UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return FILE_CD
     */
    public String getFileCd() {
        return fileCd;
    }

    /**
     * @param fileCd
     */
    public void setFileCd(String fileCd) {
        this.fileCd = fileCd == null ? null : fileCd.trim();
    }
}