package lec01;

import java.io.Serializable;

/**
 * 短距離走者のデータを管理するクラス
 */
public class Sprinter implements Serializable {

    private int zeichen;
    private String familyName;
    private String givenName;
    private int bestTime;

    public Sprinter() {
        this(0, null, null, 0);
    }

    /**
     * @param zeichen ゼッケン番号
     * @param familyName 名字
     * @param givenName 名前
     * @param bestTime ベストタイム
     */
    public Sprinter(int zeichen, String familyName, String givenName, int bestTime) {
        this.zeichen = zeichen;
        this.familyName = familyName;
        this.givenName = givenName;
        this.bestTime = bestTime;
    }

    public int getZeichen() {
        return zeichen;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public int getBestTime() {
        return bestTime;
    }
    
    public boolean isValidated(){
        return zeichen>0
                && bestTime>0
                && familyName!= null
                && givenName!= null
                && familyName.length()+givenName.length()>=8;
    }

}
