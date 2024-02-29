package cucumber.forCount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForCountMinus {
    int was, left;

    @Given("minus given {int} records")
    public void minusWasRecords(int x) {
        System.out.println(Thread.currentThread() + " - MinusGiven");
        was = x;
    }

    @When("minus delete {int} records")
    public void minusDeleteRecords(int y) {
        System.out.println(Thread.currentThread() + " - MinusWhen");
        left = was - y;
    }

    @Then("minus left {int} records")
    public void minusLeftRecords(int z) {
        System.out.println(Thread.currentThread() + " - MinusThen");
//        System.out.println(left == z);
        assertThat(left).isEqualTo(z);
    }
}
