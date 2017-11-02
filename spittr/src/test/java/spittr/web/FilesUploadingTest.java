package spittr.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spittr.config.RootConfig;
import spittr.config.WebConfig;

/**
 * <p>
 * Created on 02.11.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration("file:web")
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class FilesUploadingTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void profilePictureUploadingTest() throws Exception {

        MockMultipartFile profilePictureFile = new MockMultipartFile(
                "profilePicture",
                "foo.jpg",
                MediaType.MULTIPART_FORM_DATA_VALUE,
                "foo".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/spitter/register").file(profilePictureFile))
                .andDo(MockMvcResultHandlers.log());

    }
}
