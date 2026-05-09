package restfulwebservices._notion;

import jakarta.annotation.PostConstruct;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NotionDatabaseTest {

    @Value("${notion.token}")
    private String notionToken;

    @Value("${notion.parent-page-id}")
    private String parentPageId;

    @Value("${notion.version}")
    private String notionVersion;

    private final OkHttpClient client = new OkHttpClient();

    @PostConstruct
    public void run() throws Exception {
        String databaseId = createDatabase();
        insertTestRow(databaseId);
        System.out.println("✅ Database created and row inserted");
    }

    private String createDatabase() throws IOException {

        String jsonBody = """
        {
          "parent": { "type": "page_id", "page_id": "%s" },
          "title": [{ "type": "text", "text": { "content": "API Test Database" } }],
          "properties": {
            "Name": { "title": {} },
            "Status": { "select": { "options": [
              { "name": "New", "color": "blue" },
              { "name": "Done", "color": "green" }
            ]}},
            "Priority": { "number": {} },
            "URL": { "url": {} }
          }
        }
        """.formatted(parentPageId);

        Request request = new Request.Builder()
                .url("https://api.notion.com/v1/databases")
                .post(RequestBody.create(jsonBody, MediaType.parse("application/json")))
                .addHeader("Authorization", "Bearer " + notionToken)
                .addHeader("Notion-Version", notionVersion)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return extractId(response.body().string());
        }
    }

    private void insertTestRow(String databaseId) throws IOException {

        String jsonBody = """
    {
      "parent": { "database_id": "%s" },
      "properties": {
        "Name": { "title": [{ "text": { "content": "Test Record" } }] },
        "Status": { "select": { "name": "New" } },
        "Priority": { "number": 1 },
        "URL": { "url": "https://www.google.com" }
      },
      %s
    }
    """.formatted(databaseId, NotionPageBodyAggregator.buildChildren());

        Request request = new Request.Builder()
                .url("https://api.notion.com/v1/pages")
                .post(RequestBody.create(jsonBody, MediaType.parse("application/json")))
                .addHeader("Authorization", "Bearer " + notionToken)
                .addHeader("Notion-Version", notionVersion)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException(response.body().string());
            }
        }
    }


    private String extractId(String json) {
        int start = json.indexOf("\"id\":\"") + 6;
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}
