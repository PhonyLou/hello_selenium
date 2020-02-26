package com.tw.helloselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        List<String> resourcesList = loadConfiguration();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(resourcesList.get(0));
        Thread.sleep(1000);

        WebElement name = driver.findElement(By.xpath("//*[@id='root']/div/form/div[3]/div/div[1]/div/div[2]/div/span/span/span/input"));
        name.sendKeys(resourcesList.get(1));

        WebElement dates = driver.findElement(By.xpath("//*[@id='root']/div/form/div[3]/div/div[2]/div/div[2]/div/span/span/span/div/input"));
        dates.click();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        String today = sdf.format(new Date());
        WebElement date = driver.findElement(By.xpath(".//*[@title='"+today+"']"));
        date.click();

        WebElement projects = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[3]/div/div[2]/div/span/span/div/div/div/div/div[1]"));
        projects.click();
        WebElement project = driver.findElement(By.xpath("//*[@id=\"react-select-2-option-4\"]"));
        project.click();

        WebElement area = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[4]/div/div[2]/div/span/span/textarea"));
        area.sendKeys(resourcesList.get(2));

        WebElement myselfHealthy = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[5]/div/div[2]/div/span/span/div/div[1]/div/div/label/span[2]/span"));
        myselfHealthy.click();

        WebElement roomMateHealthy = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[5]/div/div[2]/div/span/span/div/div[2]/div/div/label/span[2]/span"));
        roomMateHealthy.click();

        WebElement tripToHuBei = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[6]/div/div[2]/div/span/span/div/div[4]/div/div/label/span[2]/span"));
        tripToHuBei.click();

        WebElement isolated = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[7]/div/div[2]/div/span/span/div/div[4]/div/div/label/span[2]/span"));
        isolated.click();

        WebElement outside = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/div/div[8]/div/div[2]/div/span/span/textarea"));
        outside.clear();
        outside.sendKeys(resourcesList.get(3));

//        WebElement submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[5]/div[1]/button"));
//        submit.click();
    }

    private static List<String> loadConfiguration() throws IOException, URISyntaxException {
        URI uri = ClassLoader.getSystemResource("input.txt").toURI();
        return Files.readAllLines(Paths.get(uri));
    }
}