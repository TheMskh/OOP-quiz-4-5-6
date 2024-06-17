package quiz6;

public class SpecialCommunicationManager implements CommunicationManager {
    private String commonServiceUrl;
    private String specialServiceUrl;

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
    }

    @Override
    public String sendMessage(String jsonRequest) {
        if (jsonRequest.contains("help")) {
            return sendToSpecialService(jsonRequest);
        } else {
            return sendToCommonService(jsonRequest);
        }
    }

    private String sendToSpecialService(String jsonRequest) {
        // Simulate sending to special service
        return "Request sent to special service at " + specialServiceUrl;
    }

    private String sendToCommonService(String jsonRequest) {
        // Simulate sending to common service
        return "Request sent to common service at " + commonServiceUrl;
    }
}
