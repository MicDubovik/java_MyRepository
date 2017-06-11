package restbook.booking;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestTemplates {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenCallstartPageGetPageContains() {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Welcome");
    }

    @Test
    public void whenCallindexPageGetContains() {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/voting",
                String.class)).contains("Add book for voting");
    }

    @Test
    public void whenVotingResultPageGetContains() {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/view",
                String.class)).contains("Booking API");
    }

    @Test
    public void whenCallresultPageGetContains() {

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/result",
                String.class)).contains("Click for view result");
    }


}
