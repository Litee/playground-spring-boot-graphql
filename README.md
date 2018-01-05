# Playground for Graphql technology using Spring Boot + java-graphql

# Insights

* `java-graphiql` edit is nice, even has autocompletes!
* Could not find an easy way to test `java-graphql` using `MockMvc`, had to use `TestRestTemplate`, which is less elegant and slower
* Do not forget about `@DirtiesContext` for mutable operations!
* Tried JSONAssert for verifying replies. Something like ApprovalTests would be easier to use.
