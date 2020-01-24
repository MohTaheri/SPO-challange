package challenge.soniq.taheri.spo;

import challenge.soniq.taheri.spo.models.WorkforceInfoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
//@ActiveProfiles("test")
class SpoApplicationTests {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    /*
    {
        "timestamp":"2019-03-05T09:34:13.207+0000",
        "status":400,
        "errors":["Author is not allowed."]
    }
 */
    @Test
    public void invalidWorkforceInfoRequest() throws JSONException {

        String workforceInfoRequest = "{\"rooms\":[ 23, 23 ,12], \"senior\":12,\"junior\":2}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(workforceInfoRequest, headers);

        //Try exchange
        ResponseEntity<String> response = restTemplate.exchange("/api/spi", HttpMethod.POST, entity, String.class);

        String expectedJson = "{\"status\":400,\"errors\":[\"Workforce Info is not valid.\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

    }

}
