package helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.IndianCensusCSV;
import model.IndianStateCodeCsv;
import service.CustomCsvException;

public class Helpercsv<E> {

    /**
     * csv operaqtion
     *
     * @param csvFilepath
     * @return contents of CSV file
     * @throws CustomCsvException
     */
    public static List<IndianCensusCSV> readIndianCensusCsv(String csvFilepath) throws CustomCsvException {
        List<IndianCensusCSV> returnList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilepath))) {
            @SuppressWarnings("unused")
            String headerLine = reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                IndianCensusCSV csvmodel = ObjectBuilder.createObjectOfIndianCensus(attributes);
                returnList.add(csvmodel);
                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new CustomCsvException("File not found");
        } catch (IOException e) {
            throw new CustomCsvException(e.getMessage(), CustomCsvException.ExceptionType.INCORRECT_FILE);
        } catch (RuntimeException e) {
            throw new CustomCsvException(e.getMessage(), CustomCsvException.ExceptionType.IMPROPER_CSV);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;

    }

    /**
     * @param path of State code csv file
     * @return contents from csv file
     * @throws CustomCsvException
     */
    public static List<IndianStateCodeCsvModel> readIndianStateCodeCsv(String csvFilepath) throws CustomCsvException{
        List<IndianStateCodeCsvModel> returnList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFilepath)))
        {
            @SuppressWarnings("unused")
            String headerLine = reader.readLine();
            String line = reader.readLine();
            while(line != null) {
                String[] attributes = line.split(",");
                IndianStateCodeCsvModel csvmodel = ObjectBuilder.createObjectOfIndianStateCode(attributes);
                returnList.add(csvmodel);
                line = reader.readLine();
            }
        }
        catch(IOException e) {
            throw new CustomCsvException(e.getMessage(),CustomCsvException.ExceptionType.INCORRECT_FILE);
        }
        catch(RuntimeException e) {
            throw new CustomCsvException(e.getMessage(),CustomCsvException.ExceptionType.IMPROPER_CSV);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;
    }
}

