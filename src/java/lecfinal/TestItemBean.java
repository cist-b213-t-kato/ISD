/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecfinal;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Etude
 */
public class TestItemBean {
    private int testId;
    private int testNumber;
    private int productId; 
    private String accountId;
    private int testType;
    private String testStep;
    private String expectedResult;
    private Date testDate;
    private int testResult;
    private String remarks;

    public TestItemBean(int testId, int testNumber, int productId, String accountId, int testType, String testStep, String expectedResult, Date testDate, int testResult, String remarks) {
        this.testId = testId;
        this.testNumber = testNumber;        
        this.productId = productId;
        this.accountId = accountId;
        this.testType = testType;
        this.testStep = testStep;
        this.expectedResult = expectedResult;
        this.testDate = testDate;
        this.testResult = testResult;
        this.remarks = remarks;
    }

    public int getTestType() {
        return testType;
    }

    public void setTestType(int testType) {
        this.testType = testType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTestStep() {
        return testStep;
    }

    public void setTestStep(String testStep) {
        this.testStep = testStep;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public int getTestResult() {
        return testResult;
    }

    public void setTestResult(int testResult) {
        this.testResult = testResult;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    
    
}
