package restfulwebservices._notion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NotionPageBodyBuilder2 {

    public String blocks() {
        return """
        {
          "type": "paragraph",
          "paragraph": {
            "rich_text": [
              {
                "type": "text",
                "text": {
                  "content": "Dependency Injection makes classes loosely coupled and delegates object creation to the IoC container."
                }
              }
            ]
          }
        }
        """;
    }
}
