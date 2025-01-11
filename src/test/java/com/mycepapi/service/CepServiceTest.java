package com.mycepapi.service;

//import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.standalone.WireMockServerRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


//@ExtendWith(WireMockExtension.class)
@RunWith(SpringRunner.class)
//@SpringBootTest
public class CepServiceTest {

//    @RegisterExtension
//    static WireMockExtension wm = WireMockExtension.newInstance()
//            .options(WireMockConfiguration.options()
//                    .port(8081)
//                    ).build();
//    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    //@Autowired
    //private CepService cepService;

    //@InjectMocks
    //private CepServiceImpl cepServiceImpl;

//    public CepServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void test() throws Exception{
        stubFor(get(urlEqualTo("/ws/01234567"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"Hello, world!\"}")));

        //cepService.getCepInfo("01234567");
        URL url = new URL("http://localhost:8080/api/cep/01234567");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        assertEquals(connection.getResponseCode(), 200);
        assertEquals(connection.getHeaderField("Content-Type"), "application/json");
        //assert
    }
//    @Test
//    void test_getCepInfo_with_wiremock(WireMockRuntimeInfo wireMockRuntimeInfo) {
//        stubFor(get("/ws/06726370").willReturn(ok()));
//
//        WireMock wireMock = wireMockRuntimeInfo.getWireMock();
//        wireMock.register(get("/ws/06726370").willReturn(ok()));
//
//        int port = wireMockRuntimeInfo.getHttpPort();
//    }
//    @Test
//    public void testGetCepInfo() {
//        CepInfo info = new CepInfo("06726370");
//        MappingBuilder mb = get("http://localhost:80801/ws/06726370/json")
//                .willReturn(aResponse()
//                        .withStatus(200));
//        wm.stubFor(mb);
//
//        CepInfo cepInfo = cepService.getCepInfo("06726370");
//
//        assertEquals(cepInfo, info);
//        //when(cepService.getCepInfo("01001000")).thenReturn("Cep Info");
//
//        //String result = cepServiceImpl.getCepInfo("01001000");
//        //assertEquals("Cep Info", result);
//    }
}
