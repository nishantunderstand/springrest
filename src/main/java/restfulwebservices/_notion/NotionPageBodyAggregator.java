package restfulwebservices._notion;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NotionPageBodyAggregator {

    public String buildChildren() {
        return """
        "children": [
          %s,
          %s,
          %s
        ]
        """.formatted(
                NotionPageBodyBuilder.blocks().trim(),
                NotionPageBodyBuilder2.blocks().trim(),
                NotionPageBodyBuilder3.blocks().trim()
        );
    }
}
