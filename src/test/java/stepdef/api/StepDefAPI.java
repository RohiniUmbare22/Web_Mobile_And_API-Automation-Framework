package stepdef.api;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.List;
import java.util.Map;

public class StepDefAPI {
    private String apiUrl;
    //private String apiKey = "";
    private CloseableHttpResponse response;

    @Given("I have the API URL")
    public void iHaveTheApiUrl() {
        apiUrl = "https://jsonplaceholder.typicode.com/posts";
    }

    @When("I send a POST request with the following data")
    public void iSendAPostRequestWithTheFollowingData(DataTable dataTable) throws Exception {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> postData = data.get(0); // Get the first row

        sendPostRequest(postData);
    }

    private void sendPostRequest(Map<String, String> postData) throws Exception {
        if (postData == null || postData.isEmpty()) {
            throw new IllegalArgumentException("Post data cannot be null or empty");
        }

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(apiUrl);
        post.setHeader("Content-Type", "application/json");
       // post.setHeader("Authorization", "Bearer " + apiKey);// Open source API so not required authentication

        String jsonInputString = String.format("{\"title\":\"%s\", \"body\":\"%s\", \"userId\":%s}",
                postData.get("title"), postData.get("body"), postData.get("userId"));
        post.setEntity(new StringEntity(jsonInputString));

        response = client.execute(post);
        client.close();
    }

    @Then("I receive a success response")
    public void iReceiveASuccessResponse() throws Exception {
        if (response == null) {
            throw new IllegalStateException("Response is null. Ensure that the request was executed properly.");
        }
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + statusCode);
        assert statusCode == 201; // Check for Created status
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println("Response Body: " + responseBody);
    }
}
