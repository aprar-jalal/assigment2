package Strategy;

public class EncStrategy implements EventProcessingStrategy {
    @Override
    public String process(String payload) {
        return "Enc(" +payload+ ")";
    }
}
