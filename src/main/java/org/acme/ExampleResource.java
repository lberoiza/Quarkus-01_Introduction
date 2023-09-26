package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class ExampleResource {

  @ConfigProperty(name = "ExampleResource.greeting")
  String greeting;


  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from RESTEasy Reactive";
  }


  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String customGreeting(@PathParam("name") String name) {
    String question = "How are you doing?";
    return String.format("%s, %s. %s", greeting, name, question);
  }
}
