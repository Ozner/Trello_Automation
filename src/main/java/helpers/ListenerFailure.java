package helpers;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.reporters.ExitCodeListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static helpers.DriverManager.*;
import static helpers.Utils.*;

public class ListenerFailure extends ExitCodeListener {

    /*
    segun allure esto deberia incluir el screenshot en el reporte, pero no funca
    @Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @Attachment(value = "Page screenshot", type = "image/jpg")
    public void saveScreenshotPNG (WebDriver driver, String testName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = testName + "_" + getBrowser() + "_" + getEnvironment()+ "_" + LocalDateTime.now().toString().replaceAll("[-+.^:,]","") + ".jpg";
        System.out.println(screenshotName);
        File destination =new File(Paths.get(".").normalize().toAbsolutePath() + "\\screenshots\\" + screenshotName);
        FileUtils.copyFile(screenshot, destination);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        if (getDriver() != null) {
            try {
                saveScreenshotPNG(getDriver(), getTestMethodName(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
