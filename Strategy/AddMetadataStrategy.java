package Strategy;

public class AddMetadataStrategy implements EventProcessingStrategy {
    private final String metaData;
    public  AddMetadataStrategy(String metaData) {
        this.metaData=metaData;
    }
    @Override
    public String process(String payload){
        return "metaData("+metaData+")--" + payload;
    }
}
