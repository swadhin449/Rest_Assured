package Files;

public class Payload {
    public static String addPlace(){
        return "{\n" +
                "    \"location\":{\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 32.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\": \"Swadhin Jena\",\n" +
                "    \"phone_number\": \"(+91) 789 789 7890\",\n" +
                "    \"address\":\"Hyderabad\",\n" +
                "    \"types\":[\n" +
                "        \"shoe park\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"https://rahulshettyacademy.com\",\n" +
                "    \"language\": \"English\"\n" +
                "}";
    }
    public static String coursePrice(){
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"https://rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"cources\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium with Java\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Python\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
    public static String addBookJson(String isbn,String aisle){
        String payloadAddBook = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
        return payloadAddBook;
    }

}
