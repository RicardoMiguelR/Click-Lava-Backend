package org.clicLava;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.clicLava.dto.ChangePassword;
import org.clicLava.model.Producto;
import org.clicLava.model.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ClicLavaApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	/* *** Tests para endpoints de productos *** --> */
	
	// test GET para producto:
	@Test
	@DisplayName("Se prueba el GET de producto [4] del endpoint http://localhost:8080/api/productos/[4]")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/productos/4"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("ace.jpg")));
	}
	
	// Metodo para test de endpoint POST de producto:
	private static String asJsonStringProducto(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	// test POST para producto:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba crear un producto del endpoint http://localhost:8080/api/productos/")
	void pruebaPOST() throws Exception {
		Producto prod = new Producto("Jabon Ace",
				"Detergente liquido, suavizante de telas",
				15.5,
				10,
				"ace.jpg");
		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonStringProducto(prod)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Jabon Ace")));
	}
	
	// test DELETE para producto:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba eliminar el producto [] del endpoint http://localhost:8080/api/productos/[]")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/productos/"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("cloro.jpg")));
	}
	
	// test PUT para producto:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba actualzar el producto [3] del endpoint http://localhost:8080/api/productos/[3]")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/productos/3?nombre=Lavadora Samsung Inteligente"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Lavadora Samsung Inteligente")));
	}
	
	/* *** Tests para endpoints de usuarios *** --> */
	
	// Metodo para test de endpoint POST de producto:
	private static String asJsonStringUsuario(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	// test POST de usuarios:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba crear un producto del endpoint http://localhost:8080/api/usuarios/")
	void pruebaPOSTUsuario() throws Exception {
		Usuario user = new Usuario("Edu",
				"El Senior del team",
				"edu@email.com",
				"edu",
				"3425587572",
				"2025-05-26",
				3L);
		this.mockMvc.perform(post("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonStringUsuario(user)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Edu")));
	}
	
	// test GET de usuarios:
	@Test
	@DisplayName("Se prueba el GET del usuario [] del endpoint http://localhost:8080/api/usuarios/[2]")
	void pruebaGETUsuarios() throws Exception {
		this.mockMvc.perform(get("/api/usuarios/2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Karla")));
	}
	
	// test DELETE de usuarios:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba eliminar el usuario [1] del endpoint http://localhost:8080/api/usuarios/[1]")
	void pruebaDELETEUsuario() throws Exception {
		this.mockMvc.perform(delete("/api/usuarios/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Ray")));
	}
	
	// test PUT de usuarios:
	@Test
	@Disabled("Probado una vez, deshabilitado para subsecuentes ocaciones, descomentar o comentar cuando sea necesario")
	@DisplayName("Se prueba actualizar el usuario [2] del endpoint http://localhost:8080/api/usuarios/[2]")
	void pruebaPUTUsuario() throws Exception {
		ChangePassword newPassword = new ChangePassword(
				"ana",
				"Karla"
				);
		this.mockMvc.perform(put("/api/usuarios/2")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonStringUsuario(newPassword)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Karla")));
	}

}
