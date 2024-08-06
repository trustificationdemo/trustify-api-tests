package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.openapi.quarkus.trustd_yaml.api.ImporterApi;

@ApplicationScoped
@Path("/importers")
public class ImporterResource {

    @RestClient
    @Inject
    ImporterApi importerApi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var importers = importerApi.listImporters();
        return "We have importers";
    }
}
