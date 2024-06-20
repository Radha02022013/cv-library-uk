package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {
    @DataProvider(name = "jobSearchData")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Tester","Harrow","5 miles","30000","500000","Per annum","Permanent","Permanent Tester jobs in Harrow on the Hill"},
                {"Admin","Hounslow","10 miles","30000","40000","Per month","Contract","Contract Admin job in Hounslow "},
                {"Customer Assistant","Hayes","15 miles" ,"500","1000","Per week" ,"Temporary","Customer assistant job in Hayes" },
                {"Finance","London","25 miles","40000","60000","Per month","Permanent","Finance job in London"},
                {"business Analyst","South London","15 miles","50000","100000","Per annum","Permanent","Permanent Business Analyst jobs in South London"},
                {"Java Developer", "London", "7 miles", "30000", "800000", "Per annum", "Permanent", "Permanent Java Developer jobs in London"},
        };
        return data;
    }

}
