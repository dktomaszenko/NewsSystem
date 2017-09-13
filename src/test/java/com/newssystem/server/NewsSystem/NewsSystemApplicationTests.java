package com.newssystem.server.NewsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsSystemApplicationTests {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private NewsRepository newsRepository;

    @BeforeClass
    public static void setUpBefore() throws Exception {
        // antes de los tests
    }

    @AfterClass
    public static void afterTest() throws Exception {
        // después de los tests
    }

    @Before
    public void setUp() throws Exception {
        // antes que cada test
    }

    @After
    public void after() throws Exception {
        // después de cada test
    }

    @Test
    public void testCreateNews() throws IOException {
        Map<String,  Object> requestBody = new HashMap<>();
        requestBody.put("title", "Tytul");
        requestBody.put("text", "Tresc");
        requestBody.put("data", "12.09.2017");
        requestBody.put("author", "Darek");
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/api/news/saveNews", httpEntity, Map.class, Collections.emptyMap());

        assertNotNull(apiResponse);


        String message = apiResponse.get("message").toString();
        assertEquals("News created succesfully", message);

        String newsId = ((Map<String,Object>)apiResponse.get("news")).get("id").toString();
        assertNotNull(newsId);

        News news = newsRepository.findOne(newsId);
        assertEquals("Tytul", news.getTitle());
        assertEquals("Tresc", news.getText());
        assertEquals("12.09.2017", news.getData());
        assertEquals("Darek", news.getAuthor());
    }

}
