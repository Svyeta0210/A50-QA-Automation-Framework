package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17_AddSong extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;
  @Test(testName = "Add a song to the playlist", groups = "Smoke")
  public void addSongToPlaylist(){
    loginPage = new LoginPage(getDriver());
    homePage = new HomePage(getDriver());
    allSongsPage = new AllSongsPage(getDriver());

    loginPage.loginKoel("son.nam.kim@testpro.io","koel08/23");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();
    homePage.createNewPlaylist();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/nav/ul/li[1]")));
    homePage.clickOptionSimpleNewPlaylist()
            .typeInNewPlaylistName();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='songs']")));
    allSongsPage.clickSidePanelListAllSongs();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper > header > div.heading-wrapper > h1)")));
    allSongsPage.getAllSongsPageTitle();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr[class='song-item selected']>td[class='title']")));
    allSongsPage.clickFirstSongInAllSongsPlaylist();
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
    allSongsPage.clickGreenButtonAddTo();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists']>ul>li:nth-child(4)>a")));
    allSongsPage.clickDropdownMenuPlaylistNewP();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists']>ul>li:nth-child(4)>a")));
    homePage.clickCreatedSimplePlaylistNewP()
            .clickDeletePlaylistButton()
            .clickDeleteOkButton();
    Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());

}
}
