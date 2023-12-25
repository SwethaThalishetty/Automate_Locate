package TestComponents;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


public class MyReporter implements IReporter{
	
	 @SuppressWarnings("unchecked")
	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		 String reportDirectory="reports";
	        JSONArray results = new JSONArray();
	        suites.forEach(element->{
	            results.add(createSuiteJsonObject(element));
	        });
	        try (FileWriter file = new FileWriter(reportDirectory + "/Automation_Report.json")) {
	            file.write(results.toJSONString());
	        } catch (IOException e) {
	            //handle
	        }

	    }

	    @SuppressWarnings("unchecked")
	    public JSONObject createSuiteJsonObject(ISuite suite) {
	        JSONObject result = new JSONObject();
	        JSONArray passedMethods = new JSONArray();
	        JSONArray failedMethods = new JSONArray();
	        JSONArray skippedMethods = new JSONArray();
	        suite.getResults().entrySet().forEach(element -> {
	            ITestContext context = element.getValue().getTestContext();
	            passedMethods.addAll(createResultJsonArray(context.getPassedTests().getAllResults()));
	            failedMethods.addAll(createFailedResultJsonArray(context.getFailedTests().getAllResults()));
	            skippedMethods.addAll(createSkippedResultJsonArray(context.getSkippedTests().getAllResults()));
	           
	        });
	        result.put("name", suite.getName());
	        result.put("passed", passedMethods);
	        result.put("failed", failedMethods);
	        result.put("skipped", skippedMethods);
	        return result;
	    }


	    @SuppressWarnings("unchecked")
	    public JSONArray createResultJsonArray(Set<ITestResult> results) {
	        JSONArray result = new JSONArray();
	        results.forEach(element ->{
	            JSONObject currentJsonResult = new JSONObject();
	            currentJsonResult.put("name", element.getName());
	            currentJsonResult.put("start time", element.getStartMillis());
	            currentJsonResult.put("end time", element.getEndMillis());
	           
	            currentJsonResult.put("Time Taken", TimeUnit.MILLISECONDS.toSeconds(element.getEndMillis()-element.getStartMillis()));
	            result.add(currentJsonResult);
	        });
	        return result;
	    }
	    
	    @SuppressWarnings("unchecked")
	    public JSONArray createFailedResultJsonArray(Set<ITestResult> results) {
	        JSONArray result = new JSONArray();
	        results.forEach(element ->{
	            JSONObject currentJsonResult = new JSONObject();
	            currentJsonResult.put("name", element.getName());
	            currentJsonResult.put("error", element.getThrowable().getMessage());
	            currentJsonResult.put("start time", element.getStartMillis());
	            currentJsonResult.put("end time", element.getEndMillis());
	           
	            currentJsonResult.put("Time Taken", TimeUnit.MILLISECONDS.toSeconds(element.getEndMillis()-element.getStartMillis()));
	            result.add(currentJsonResult);
	        });
	        return result;
	    }
	    
	    @SuppressWarnings("unchecked")
	    public JSONArray createSkippedResultJsonArray(Set<ITestResult> results) {
	        JSONArray result = new JSONArray();
	        results.forEach(element ->{
	            JSONObject currentJsonResult = new JSONObject();
	            currentJsonResult.put("name", element.getName());
	            currentJsonResult.put("skip reason", element.getSkipCausedBy());
	           
	            result.add(currentJsonResult);
	        });
	        return result;
	    }
}
