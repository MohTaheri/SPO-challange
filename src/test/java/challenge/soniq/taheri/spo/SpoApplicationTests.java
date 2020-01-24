package challenge.soniq.taheri.spo;

import challenge.soniq.taheri.spo.models.OptimalStaffsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// for restTemplate
//@ActiveProfiles("test")
public class SpoApplicationTests {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void invalidWorkforceInfoRequest() throws JSONException {

        String workforceInfoRequest = "{\"rooms\":[ 123, 23 ,12], \"senior\":12,\"junior\":2}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(workforceInfoRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange("/api/spo", HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void testForWhenPayloadIsValidExpectSuccess() throws Exception {
        String workforceInfoRequest = "{\"rooms\":[ 24, 28], \"senior\":11,\"junior\":6}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/spo")
                .content(workforceInfoRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        OptimalStaffsResponse[] apiResponse = objectMapper.readValue(result.getResponse().getContentAsString(),
                OptimalStaffsResponse[].class);

        Assertions.assertThat(apiResponse).isNotNull();
        Assertions.assertThat(2).isEqualTo(apiResponse.length);
        OptimalStaffsResponse[] expected = new OptimalStaffsResponse[]{
                new OptimalStaffsResponse(2, 1),
                new OptimalStaffsResponse(2, 1)};
        Assertions.assertThat(expected).isEqualTo(apiResponse);
    }

}
