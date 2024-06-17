import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;

public class ChatbotConsoleApp {
    private static final String API_URL = "http://your-chatbot-service-url/api/chat";
    private static List<ChatMessage> chatHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        while (true) {
            System.out.print("User: ");
            String userMessage = scanner.nextLine();

            // Add user message to chat history
            chatHistory.add(new ChatMessage("user", userMessage));

            // Create request JSON
            ChatRequest chatRequest = new ChatRequest(chatHistory);
            String jsonRequest = gson.toJson(chatRequest);

            // Send POST request to the chatbot service
            String jsonResponse = sendPostRequest(jsonRequest);

            // Parse response and add to chat history
            ChatMessage chatbotResponse = gson.fromJson(jsonResponse, ChatMessage.class);
            chatHistory.add(chatbotResponse);

            // Print chatbot response
            System.out.println("Chatbot: " + chatbotResponse.getContent());
        }
    }

    private static String sendPostRequest(String jsonInputString) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (Scanner scanner = new Scanner(con.getInputStream(), "UTF-8")) {
                return scanner.useDelimiter("\\A").next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"role\": \"chatbot\", \"content\": \"Error: Unable to get response from chatbot service.\"}";
        }
    }
}
