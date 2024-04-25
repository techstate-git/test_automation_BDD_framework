package tech_state_cucumber.apis;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;

// Assuming you have a class representing the response body
public class ResponseBody {
    private Map<String, String> data;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }


    private Map<String, String> getResponseBodyAsMap(String jsonResponse ) {
        // Parse the JSON response into a ResponseBody object

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResponseBody responseBody = objectMapper.readValue(jsonResponse, ResponseBody.class);
            return responseBody.getData(); // Return the data as a Map
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap(); // Return an empty map in case of an error
        }
    }
}