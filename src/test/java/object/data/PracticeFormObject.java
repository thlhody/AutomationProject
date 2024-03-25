package object.data;

import java.util.List;
import java.util.Map;

public class PracticeFormObject extends GeneralObject {
    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String mobilValue;
    private String dobDayValue;
    private String dobMonthValue;
    private String dobYearValue;
    private String subjectValue;
    private List<String> hobbies;
    private String filePath;
    private String addressValue;
    private String cityValue;
    private String stateValue;

    public PracticeFormObject(Map<String, String> testData) {
        prepareObject(testData);
    }
    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstNameValue":
                    setFirstNameValue(testData.get(key));
                    break;
                case "lastNameValue":
                    setLastNameValue(testData.get(key));
                    break;
                case "emailValue":
                    setEmailValue(testData.get(key));
                    break;
                case "genderValue":
                    setGenderValue(testData.get(key));
                    break;
                case "mobileValue":
                    setMobilValue(testData.get(key));
                    break;
                case "dobDayValue":
                    setDobDayValue(testData.get(key));
                    break;
                case "dobMonthValue":
                    setDobMonthValue(testData.get(key));
                    break;
                case "dobYearValue":
                    setDobYearValue(testData.get(key));
                    break;
                case "subjectValue":
                    setSubjectValue(testData.get(key));
                    break;
                case "hobbies":
                    hobbies = getPreparedValue(testData.get(key));
                    break;
                case "filePath":
                    setFilePath(testData.get(key));
                    break;
                case "addressValue":
                    setAddressValue(testData.get(key));
                    break;
                case "stateValue":
                    setStateValue(testData.get(key));
                    break;
                case "cityValue":
                    setCityValue(testData.get(key));
                    break;
            }
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobilValue() {
        return mobilValue;
    }

    public void setMobilValue(String mobilValue) {
        this.mobilValue = mobilValue;
    }

    public String getDobDayValue() {
        return dobDayValue;
    }

    public void setDobDayValue(String dobDayValue) {
        this.dobDayValue = dobDayValue;
    }

    public String getDobMonthValue() {
        return dobMonthValue;
    }

    public void setDobMonthValue(String dobMonthValue) {
        this.dobMonthValue = dobMonthValue;
    }

    public String getDobYearValue() {
        return dobYearValue;
    }

    public void setDobYearValue(String dobYearValue) {
        this.dobYearValue = dobYearValue;
    }

    public String getSubjectValue() {
        return subjectValue;
    }

    public void setSubjectValue(String subjectValue) {
        this.subjectValue = subjectValue;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }
}
