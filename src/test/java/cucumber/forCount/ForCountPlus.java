package cucumber.forCount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForCountPlus {

    int was, became1, became2;

    @Given("есть {int} записей")
    public void plusWasRecords(int x) {
        System.out.println(Thread.currentThread() + " - PlusGiven");
        was = x;
    }

    @When("добавляем {int} записей")
    public void plusAddRecords(int y) {
        System.out.println(Thread.currentThread() + " - PlusWhen");
        became1 = was + y;
    }

    @When("добавляем еще {int} записей")
    public void plusAddStilRecords(int w) {
        System.out.println(Thread.currentThread() + " - PlusStillWhen");
        became2 = became1 + w;
    }

    @Then("получилось {int} записей")
    public void plusBecomeRecords(int z) {
        System.out.println(Thread.currentThread() + " - PlusThen");
//        System.out.println(left == z);
        assertThat(became1).isEqualTo(z);
    }
}
