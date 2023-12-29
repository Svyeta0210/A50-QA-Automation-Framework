package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18_Play_A_Song extends BaseTest {
        LoginPage loginPage;
        HomePage homePage;
        AllSongsPage allSongsPage;

    @Test(testName = "Play A Song", groups = {"Smoke","Regression"})

    public void playSong() {
        loginPage = new LoginPage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io","koel08/23");
            explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='songs active']")));
        allSongsPage.clickSidePanelListAllSongs();
            explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr[class='song-item selected']>td[class='title']")));
        allSongsPage.clickFirstSongInAllSongsPlaylist();
            explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr[class='song-item selected']>td[class='title']")));
        allSongsPage.contextClickFirstSongInAllSongsPlaylist()
                    .clickOptionPlayInDropdownMenu();

        Assert.assertTrue(allSongsPage.soundBarsImage().isDisplayed());
    }
}
