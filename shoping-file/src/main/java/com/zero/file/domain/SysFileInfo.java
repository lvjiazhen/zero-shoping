package com.zero.file.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_file_info")
public class SysFileInfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "FILE_CD")
    private String fileCd;

    @Column(name = "FILE_TITL")
    private String fileTitl;

    @Column(name = "KEY_WORD")
    private String keyWord;

    @Column(name = "EST_ORG")
    private String estOrg;

    @Column(name = "ORG_CD")
    private String orgCd;

    @Column(name = "EST_PERS")
    private String estPers;

    @Column(name = "EST_DT")
    private Date estDt;

    @Column(name = "PUB_ORG")
    private String pubOrg;

    @Column(name = "PUB_ORG_CD")
    private String pubOrgCd;

    @Column(name = "PUB_DT")
    private Date pubDt;

    @Column(name = "ABS")
    private String abs;

    @Column(name = "MUL_TP")
    private String mulTp;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "FILE_NM")
    private String fileNm;

    @Column(name = "FILE_SIZE")
    private BigDecimal fileSize;

    @Column(name = "FILE_EXT")
    private String fileExt;

    @Column(name = "IS_SEC")
    private String isSec;

    @Column(name = "SEC_G")
    private String secG;

    @Column(name = "DOC_TP")
    private String docTp;

    @Column(name = "MANG_CD")
    private String mangCd;

    @Column(name = "TS")
    private Date ts;

    @Column(name = "NT")
    private String nt;

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

    /**
     * @return FILE_TITL
     */
    public String getFileTitl() {
        return fileTitl;
    }

    /**
     * @param fileTitl
     */
    public void setFileTitl(String fileTitl) {
        this.fileTitl = fileTitl == null ? null : fileTitl.trim();
    }

    /**
     * @return KEY_WORD
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * @param keyWord
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    /**
     * @return EST_ORG
     */
    public String getEstOrg() {
        return estOrg;
    }

    /**
     * @param estOrg
     */
    public void setEstOrg(String estOrg) {
        this.estOrg = estOrg == null ? null : estOrg.trim();
    }

    /**
     * @return ORG_CD
     */
    public String getOrgCd() {
        return orgCd;
    }

    /**
     * @param orgCd
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd == null ? null : orgCd.trim();
    }

    /**
     * @return EST_PERS
     */
    public String getEstPers() {
        return estPers;
    }

    /**
     * @param estPers
     */
    public void setEstPers(String estPers) {
        this.estPers = estPers == null ? null : estPers.trim();
    }

    /**
     * @return EST_DT
     */
    public Date getEstDt() {
        return estDt;
    }

    /**
     * @param estDt
     */
    public void setEstDt(Date estDt) {
        this.estDt = estDt;
    }

    /**
     * @return PUB_ORG
     */
    public String getPubOrg() {
        return pubOrg;
    }

    /**
     * @param pubOrg
     */
    public void setPubOrg(String pubOrg) {
        this.pubOrg = pubOrg == null ? null : pubOrg.trim();
    }

    /**
     * @return PUB_ORG_CD
     */
    public String getPubOrgCd() {
        return pubOrgCd;
    }

    /**
     * @param pubOrgCd
     */
    public void setPubOrgCd(String pubOrgCd) {
        this.pubOrgCd = pubOrgCd == null ? null : pubOrgCd.trim();
    }

    /**
     * @return PUB_DT
     */
    public Date getPubDt() {
        return pubDt;
    }

    /**
     * @param pubDt
     */
    public void setPubDt(Date pubDt) {
        this.pubDt = pubDt;
    }

    /**
     * @return ABS
     */
    public String getAbs() {
        return abs;
    }

    /**
     * @param abs
     */
    public void setAbs(String abs) {
        this.abs = abs == null ? null : abs.trim();
    }

    /**
     * @return MUL_TP
     */
    public String getMulTp() {
        return mulTp;
    }

    /**
     * @param mulTp
     */
    public void setMulTp(String mulTp) {
        this.mulTp = mulTp == null ? null : mulTp.trim();
    }

    /**
     * @return FILE_PATH
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * @return FILE_NM
     */
    public String getFileNm() {
        return fileNm;
    }

    /**
     * @param fileNm
     */
    public void setFileNm(String fileNm) {
        this.fileNm = fileNm == null ? null : fileNm.trim();
    }

    /**
     * @return FILE_SIZE
     */
    public BigDecimal getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     */
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return FILE_EXT
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * @param fileExt
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    /**
     * @return IS_SEC
     */
    public String getIsSec() {
        return isSec;
    }

    /**
     * @param isSec
     */
    public void setIsSec(String isSec) {
        this.isSec = isSec == null ? null : isSec.trim();
    }

    /**
     * @return SEC_G
     */
    public String getSecG() {
        return secG;
    }

    /**
     * @param secG
     */
    public void setSecG(String secG) {
        this.secG = secG == null ? null : secG.trim();
    }

    /**
     * @return DOC_TP
     */
    public String getDocTp() {
        return docTp;
    }

    /**
     * @param docTp
     */
    public void setDocTp(String docTp) {
        this.docTp = docTp == null ? null : docTp.trim();
    }

    /**
     * @return MANG_CD
     */
    public String getMangCd() {
        return mangCd;
    }

    /**
     * @param mangCd
     */
    public void setMangCd(String mangCd) {
        this.mangCd = mangCd == null ? null : mangCd.trim();
    }

    /**
     * @return TS
     */
    public Date getTs() {
        return ts;
    }

    /**
     * @param ts
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }

    /**
     * @return NT
     */
    public String getNt() {
        return nt;
    }

    /**
     * @param nt
     */
    public void setNt(String nt) {
        this.nt = nt == null ? null : nt.trim();
    }
}