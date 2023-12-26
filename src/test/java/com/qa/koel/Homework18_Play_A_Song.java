package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18_Play_A_Song extends BaseTest {
        LoginPage loginPage;
        HomePage homePage;
        AllSongsPage allSongsPage;

    @Test(testName = "Play A Song", groups = {"Smoke","Regression"})

    public void playSong() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io","koel08/23");
        allSongsPage.clickSidePanelListAllSongs("a[class='songs']")
                    .clickFirstSongInAllSongsPlaylist("tr[class='song-item selected']>td.title")
                    .contextClickFirstSongInAllSongsPlaylist("tr[class='song-item selected']>td.title")
                    .clickOptionPlayInDropdownMenu("li.playback");

        Assert.assertTrue(allSongsPage.soundBarsImage("div>img").isDisplayed());
    }
}