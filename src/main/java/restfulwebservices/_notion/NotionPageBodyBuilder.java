package restfulwebservices._notion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NotionPageBodyBuilder {

    public String blocks() {
        return """
        {
          "type": "heading_2",
          "heading_2": {
            "rich_text": [
              { "type": "text", "text": { "content": "Body" } }
            ]
          }
        }
        """;
    }
}
