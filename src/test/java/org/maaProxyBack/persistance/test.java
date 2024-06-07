package org.maaProxyBack.persistance;
/*
public class test {

    @Test
    void postCoffeeShouldReturnCoffee() throws Exception {

        BDDMockito.given(service.save(any(Coffee.class))).willReturn(new Coffee("Albenio"));

        mvc.perform( post("/coffees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                {
                                "name":"Albenio"
                                }
                                """
                        )
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Albenio")));

    }
    @WebMvcTest(controllers = CoffeeContoller.class)
    class CoffeeMachineApplicationTests {

        @Autowired
        private MockMvc mvc;

        @MockBean
        private CoffeeService service;



        @Test
        void getAllCoffeesShouldReturnCoffees() throws Exception {

            BDDMockito.given(service.getAll()).willReturn(
                    List.of(
                            new Coffee("Granador"),
                            new Coffee("Tres puntas")

                    )
            );

            mvc.perform( get("/coffees")    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("Granador")))
                    .andExpect( jsonPath("$.length()").value(2));

        }
        @Test
        void postCoffeeShouldReturnCoffee() throws Exception {

            BDDMockito.given(service.save(any(Coffee.class))).willReturn(new Coffee("Albenio"));

            mvc.perform( post("/coffees")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(
                                    """
                                    {
                                    "name":"Albenio"
                                    }
                                    """
                            )
                    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("Albenio")));

        }

        @Test
        void empty_Post_Should_Return_400() throws Exception {

            mvc.perform(
                            post("/coffees")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(
                                            """
                                            {
                                            }
                                            """
                                    )

                    )
                    .andDo(print())
                    .andExpect(status().is(400))
                    .andExpect(
                            jsonPath("$.name").value("Coffee name cannot be null")

                    );

        }

}


 */