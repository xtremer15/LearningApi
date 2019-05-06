public class Payload {
    public static String bodyJsonPayload() {
        String bodyJsonPayload = "{\n" +
                "\n" +
                "    \"location\":{\n" +
                "\n" +
                "        \"lat\" : -38.383494,\n" +
                "\n" +
                "        \"lng\" : 33.427362\n" +
                "\n" +
                "    },\n" +
                "\n" +
                "    \"accuracy\":50,\n" +
                "\n" +
                "    \"name\":\"Frontline house\",\n" +
                "\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "\n" +
                "    \"language\" : \"French-IN\"\n" +
                "\n" +
                "}";
        return bodyJsonPayload;
    }

    public static String bodyJsonPayload2() {
        String bodyJsonPayload2 = "{\n" +
                "\n" +
                "    \"location\":{\n" +
                "\n" +
                "        \"lat\" : -38.383494,\n" +
                "\n" +
                "        \"lng\" : 33.427362\n" +
                "\n" +
                "    },\n" +
                "\n" +
                "    \"accuracy\":50,\n" +
                "\n" +
                "    \"name\":\"Frontline house\",\n" +
                "\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "\n" +
                "    \"language\" : \"French-IN\"\n" +
                "\n" +
                "}";
        return bodyJsonPayload2;
    }

    public static String bodyXML() {
        String xmlPayLoad = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<root>\n" +
                "    <location>\n" +
                "        <lat>-38.383494</lat>\n" +
                "        <lng>33.427362</lng>\n" +
                "    </location>\n" +
                "    <accuracy>50</accuracy>\n" +
                "    <name>The Mens store</name>\n" +
                "    <phone_number>(+91) 983 893 3937</phone_number>\n" +
                "    <address>Anna Salai, Chennai</address>\n" +
                "    <types>shoe park</types>\n" +
                "    <types>kadai</types>\n" +
                "    <website>http://google.com</website>\n" +
                "    <language>tamil-IN</language>\n" +
                "</root>\n";

        return xmlPayLoad;
    }


}

