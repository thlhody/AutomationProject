package objectData;

import java.util.Map;

public class AlertObject {
    private String inputText;

    public AlertObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "inputText":
                    setInputText(testData.get(key));
                    break;
            }
        }
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
