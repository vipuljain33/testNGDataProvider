import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipuljain on 06/11/17.
 */
public class DemoTest {

    List<List<Object>> testData = new ArrayList<>();        //Structure in which data is fetched from Database


    public Object[][] transformTestData()
    {

        List<Object> temp = new ArrayList<>();       //Use for loop to iterate each row, fetch data from all columns
        temp.add(5);
        temp.add("five");
        testData.add(temp);
        temp = new ArrayList<>();
        temp.add(7);
        temp.add("seven");
        testData.add(temp);
        temp = new ArrayList<>();
        temp.add(8);
        temp.add("eight");
        int colCount = temp.size();
        testData.add(temp);

        int rowCount = testData.size();
        Object[][] finalData = new Object[rowCount][colCount];

        for(int i = 0; i < testData.size(); i++)                 //converting List<List<Object>> to 2D Array
         {
            for(int j = 0; j < testData.get(i).size(); j++)
            {
                finalData[i][j] = testData.get(i).get(j);
            }
        }
        return finalData;
    }

    @Test(dataProvider = "getData")
    public void sampleTest(int p1, String p2)
    {

        System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
    }

    @DataProvider
    public Object[][] getData() {


        return transformTestData();        //return 2D array generated

        //return new Object[][]{{5, "five"}, {6, "six"}};
    }

}
