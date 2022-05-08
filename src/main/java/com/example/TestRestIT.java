public class RestIT {
    @Test
    public void whenSendingGet_thenMessageIsReturned() throws IOException {
        String url = "http://localhost:8999";
        URLConnection connection = new URL(url).openConnection();
        try (InputStream response = connection.getInputStream();
        Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.nextLine();
            assertEquals("Welcome to Baeldung!", responseBody);
        }
    }
}