/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

/**
 *
 * @author Etude
 */
public enum TestTypeDefinition {
    NORMAL_TYPE(1, "正常系"),
    ABNORMAL_TYPE(2, "異常系"),
    ;
    private int num;
    private String label;
    private TestTypeDefinition(int n, String l){
        num = n;
        label = l;
    }

    public int getNum() {
        return num;
    }

    public String getLabel() {
        return label;
    }
    
    public static String toLabel(int n){
        return values()[n-1].getLabel();
    }
    
    
}
