package Strategy;

public class CompressStrategy implements EventProcessingStrategy
{
    @Override
    public String process(String payload)
    {
        return "Com(" +payload +")";
    }
}
