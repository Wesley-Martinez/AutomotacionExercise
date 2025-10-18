package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("Comenzando el test: %s ", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("test exitoso: %s ", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Logs.info("test fallido: %s ", result.getName());
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
        System.out.printf("soy result.getName : %s ", result.getName()); //esto trae el nombre del ejercicio, esto es una prueba lo puedes borrar
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("test ignorado: %s ", result.getName());
    }
}