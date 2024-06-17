package quiz6;

public class Main {
    public static void main(String[] args) {
        String commonServiceUrl = "http://common.chatbot.service";
        String specialServiceUrl = "http://special.chatbot.service";
        CommunicationManager specialManager = new SpecialCommunicationManager(commonServiceUrl, specialServiceUrl);
        UserInteractionManager userManager = new UserInteractionManager(specialManager);

        // Example chat history
        String[][] chatHistory = {
                {"User", "Hello, chatbot!"},
                {"Chatbot", "Hello! How can I assist you today?"},
                {"User", "Can you tell me a joke?"},
                {"Chatbot", "Why don't scientists trust atoms? Because they make up everything!"},
                {"User", "I need help with my homework."}
        };

        // Current user message
        String currentMessage = "What's the weather like today?";

        userManager.interactWithUser(currentMessage, chatHistory);
    }
}

