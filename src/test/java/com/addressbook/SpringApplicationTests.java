package com.addressbook;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = AddressBookApplication.class)
@AutoConfigureMockMvc
public class SpringApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBuddyArray() throws Exception {
        this.mockMvc.perform(get("/books"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":2,\"name\":\"Default\",\"buddyInfos\":[{\"id\":14,\"name\":\"Jane\",\"address\":\"Doe\",\"phoneNumber\":\"9925\",\"addressBook\":null}]},{\"id\":6,\"name\":\"Default\",\"buddyInfos\":[]}")));
    }

    @Test
    public void shouldReturnOneBuddy() throws Exception {
        this.mockMvc.perform(get("/books/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"Default\",\"buddyInfos\":[{\"id\":4,\"name\":\"Jane\",\"address\":\"123 Address Street\",\"phoneNumber\":\"333-333-3333\",\"addressBook\":null},{\"id\":13,\"name\":\"Test\",\"address\":\"Bud\",\"phoneNumber\":\"124124\",\"addressBook\":null},{\"id\":32,\"name\":\"NewBud\",\"address\":\"BuddyAddy123\",\"phoneNumber\":\"15312124\",\"addressBook\":null},{\"id\":33,\"name\":\"bud1\",\"address\":\"buddstreet\",\"phoneNumber\":\"budnum\",\"addressBook\":null},{\"id\":35,\"name\":\"rwe\",\"address\":\"rqw\",\"phoneNumber\":\"rqw\",\"addressBook\":null}]}")));
    }
}