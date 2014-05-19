package cz.boris.demo;

/**
 * Created by Boris on 14.5.2014.
 */
@MyTransactional
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 4, max = 7)
    private int repeat;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }

    }
}
