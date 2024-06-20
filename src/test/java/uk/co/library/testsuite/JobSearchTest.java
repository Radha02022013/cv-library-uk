package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.customelistener.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();
        softAssert = new SoftAssert();
    }

    /*
    1.verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
      String result).
        enter job title 'jobTitle'
        enter Location 'location'
        select distance 'distance'
        click on moreSearchOptionsLink
        enter salaryMin 'salaryMin'
        enter salaryMax 'salaryMax'
        select salaryType 'salaryType'
        select jobType 'jobType'
        click on 'Find Jobs' button
        verify the result 'result'

    Data set

    |jobTitle|location|distance|salaryMin|salaryMax|salaryType|jobType|result|
    |Tester|Harrow| up to 5 miles|30000|500000|Per annum| Permanent|Permanent Tester jobs in Harrow on the Hill|

    Create 6 More data set.

     */
    @Test(groups = {"sanity", "regression"}, dataProvider = "jobSearchData", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                                           String result) throws InterruptedException {
        Thread.sleep(2000);
        resultPage.accpetCookies();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickOnFindJobsButton();
        softAssert.assertEquals(resultPage.verifyResult(), result, "not matched");


    }


}
