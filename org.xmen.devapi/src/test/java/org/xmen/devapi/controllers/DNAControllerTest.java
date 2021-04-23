package org.xmen.devapi.controllers;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.xmen.devapi.models.StatsResponse;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@SpringBootTest
@AutoConfigureMockMvc
class DNAControllerTest {
	
	private String mutant="{" + 
			"\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]" + 
			"}";
	
	private String human ="{" + 
			"\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATTT\",\"AGACGG\",\"GCGTCA\",\"TCACTG\"]" + 
			"}";
	
	@Autowired
	private MockMvc mock;
	
	@Test
	public void getOKStatusInHumanCase() throws Exception {
		this.mock.perform(post("/mutant")
				.content(human)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
	
	@Test
	public void getOKStatusInMutantCase() throws Exception {
		this.mock.perform(post("/mutant")
				.content(mutant)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testDelete() throws Exception {
		this.mock.perform(delete("/wipedata"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testGetAll() throws Exception {
		this.mock.perform(get("/all"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void getCorresctResultAfterInput() throws Exception {
		this.mock.perform(delete("/wipedata"));
		this.mock.perform(post("/mutant")
				.content(mutant)
				.contentType(MediaType.APPLICATION_JSON));
		this.mock.perform(post("/mutant")
				.content(human)
				.contentType(MediaType.APPLICATION_JSON));
		this.mock.perform(post("/mutant")
				.content(human)
				.contentType(MediaType.APPLICATION_JSON));
		this.mock.perform(get("/stats"))
		.andExpect(status().isOk()).andDo(print())
		.andExpect(content().json("{\"count_mutant_dna\":1, \"count_human_dna\":2, \"ratio\":0.5}",false));
	}
	
	
	
	

}
