package personal.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personal.quote.helper.IQuote;
import personal.quote.helper.TaylorSwift;
import personal.quote.model.Quote;
import personal.quote.model.TaylorSwiftDTO;

import static org.junit.jupiter.api.Assertions.*;
class TaylorSwiftTest {
    IQuote iTaylor;
    Quote taylor;
    String api = "https://api.taylor.rest/";
    String broken = "https://www.baeldung.com/httpclient-status";
    String author = "Taylor Swift";
   //String anything;
    @BeforeEach
    void setUp() {
        iTaylor = new TaylorSwift();
        taylor = new TaylorSwiftDTO();
        iTaylor.connect(api);
        taylor = (Quote) iTaylor.transform(taylor);
    }
    @Test
    void doesItConnectOk(){
        assertTrue(iTaylor.connect(api));
        assertFalse(iTaylor.connect(broken));
    }
    @Test
    void willItReturnString(){
        // it failed but transform works
        // work now
        assertEquals(taylor.getAuthor(),author);

    }

}