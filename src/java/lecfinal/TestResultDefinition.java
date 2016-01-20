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
public enum TestResultDefinition {
    UNEXECUTED(0, "－"),
    SUCCESS(1, "○"),
    FAILURE(2, "×"),
    ;
    private int num;
    private String label;
    private TestResultDefinition(int n, String l){
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
        return values()[n].getLabel();
    }
    
    
}
