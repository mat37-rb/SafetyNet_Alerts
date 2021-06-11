package com.mat37.SafetyNet_Alerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	private Person personMock;
//	@MockBean
//	private PersonService personServiceMock;

//	@Mock
//	private static Person person1;
//	@Mock
//	private static Person person2;
//	@Mock
//	private static Person person3;

//	@BeforeEach
//	public void setUpEach() {
//	}

//	@Test
//	public void testGetPersons() throws Exception {
//		mockMvc.perform(get("/persons")).andExpect(status().isOk());
//	}
}

//	@Test
//	public void testGetAllPersons() throws Exception {
//		this.personServiceMock.getPersons().willReturn(
//				asList(new Person().withId("1").withTitle("title1"), new Person().withId("2").withTitle("title2")));
//		mockMvc.perform(get("/persons")).andExpect(status().isOk());
//	}
//
//	@Test
//	public void shouldAddNewPerson() throws Exception {
//
//		// GIVEN
//		personMock.setFirstName("Luciani");
//		personMock.setLastName("Mathieu");
//		personMock.setAddress("Lieu dit Le Bordage");
//		personMock.setCity("Chemillé sur Dême");
//		personMock.setZip("37370");
//		personMock.setPhone("0648729932");
//		personMock.setEmail("mat37.rb@gmail.com");
//		Person expected_result = (Person) when(personServiceMock.savePerson(personMock)).thenReturn(personMock);
//		// WHEN
//		Person actual_result = personServiceMock.savePerson(personMock);
//		// THEN
//		// mockMvc.perform(post("/person").content.)
//		assertEquals(expected_result, actual_result);
//	}

//	@Test
//	public void simpleTest() throws Exception {
//         //Lancer une requête Rest de type GET pour l'url '/data'
//  		mockMvc.perform(get("/data"))
//        //Assert le statut de la réponse http est égal a OK.
//        .andExpect(status().isOk())
//        //Assert le type de contenue de réponse.
//        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//        //Assert l’existence d'une réponse json.
//        .andExpect(jsonPath("$").exists())
//        //Assert l’existence d'un attribut 'java-version' dans la réponse json.
//        .andExpect(jsonPath("$.java-version").exists())
//        //Assert le type de l'attribut 'java-version'
//        .andExpect(jsonPath("$.java-version").isString())
//        //Assert la valeur de l'attribut 'java-version' dans la réponse json.
//        .andExpect(jsonPath("$.java-version").value("8.24"))
//        //Afficher la réponse.
//        .andDo(print());
//    }
