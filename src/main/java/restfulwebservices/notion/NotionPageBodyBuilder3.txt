package restfulwebservices._notion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NotionPageBodyBuilder3 {

    public String blocks() {
        return """
        {
          "type": "code",
          "code": {
            "language": "java",
            "rich_text": [
              {
                "type": "text",
                "text": {
                  "content": "int cnt = 0;\\n" +
                             "ListNode temp = head;\\n" +
                             "while (temp != null) {\\n" +
                             "    if (temp.val == key) cnt++;\\n" +
                             "    temp = temp.next;\\n" +
                             "}\\n\\n" +
                             "return cnt;"
                }
              }
            ]
          }
        }
        """;
    }
}
