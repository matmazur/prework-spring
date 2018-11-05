public class StringMessageProducer implements MessageProducer {

    @Override
    public void produce(String string) {
        System.out.println(string);
    }
}
