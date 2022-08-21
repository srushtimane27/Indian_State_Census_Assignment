package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IndianCensusTest {
    IndianCensus census = null;

    @Before
    public void setUp() {
        census = new IndianCensus();
    }

    @Test
    public void given_IndianCensusCSVFile_ReturnsNumberOfRecords() throws CustomCsvException {
        int result = census.getSizeOfCsv("IndiaStateCensusData.csv");
        Assert.assertEquals(29, result);
    }

    @Test
    public void given_IndianCensusCSVFile_WhenIncorrect_ThrowsCustomException() {
        try {
            @SuppressWarnings("unused")
            int result = census.getSizeOfCsv("IndiaStateCensusdddata.csv");
        } catch (CustomCsvException e) {
            Assert.assertEquals(CustomCsvException.ExceptionType.INCORRECT_FILE, e.type);
        }
    }

    @Test
    public void given_IndianCensusCSVFile_WhenCorrectButDelimitorIsIncorrect_ThrowsCustomException() {
        try {
            @SuppressWarnings("unused")
            int result = census.getSizeOfCsv("IndiaStateCensusDataIncorrectDelimitor.csv");
        } catch (CustomCsvException e) {
            Assert.assertEquals(CustomCsvException.ExceptionType.IMPROPER_CSV, e.type);
        }
    }

    @Test
    public void given_IndianStateCodeCSVFile_ReturnsNumberOfRecords() throws CustomCsvException {
        int result = census.getSizeOfIndianStateCodeCsv("IndiaStateCode.csv");
        Assert.assertEquals(37, result);
    }

    @Test
    public void given_IndianStateCodeCSVFile_WhenIncorrect_ThrowsCustomException() {
        try {
            @SuppressWarnings("unused")
            int result = census.getSizeOfCsv("IndiaStateCodeeee.csv");
        } catch (CustomCsvException e) {
            Assert.assertEquals(CustomCsvException.ExceptionType.INCORRECT_FILE, e.type);
        }
    }

    @Test
    public void given_IndianStateCodeCSVFile_WhenTypeIsIncorrect_ThrowsCustomException() {
        try {
            @SuppressWarnings("unused")
            int result = census.getSizeOfCsv("IndiaStateCode.txt");
        } catch (CustomCsvException e) {
            Assert.assertEquals(CustomCsvException.ExceptionType.INCORRECT_FILE, e.type);
        }
    }

    @Test
    public void given_IndianStateCodeCSVFile_WhenCorrectButDelimitorIsIncorrect_ThrowsCustomException() {
        try {
            @SuppressWarnings("unused")
            int result = census.getSizeOfCsv("IndiaStateCodeIncorrect.csv");
        } catch (CustomCsvException e) {
            Assert.assertEquals(CustomCsvException.ExceptionType.IMPROPER_CSV, e.type);
        }
    }

}
