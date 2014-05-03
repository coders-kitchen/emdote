package com.coderskitchen.emdote.docker;

import com.coderskitchen.emdote.docker.model.Container;
import com.coderskitchen.emdote.docker.model.ContainerConfiguration;
import com.coderskitchen.emdote.docker.model.ContainerRunConfiguration;
import com.coderskitchen.emdote.docker.model.ContainerSpecification;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Docker {

	public static final String PORT = "4243";
	public static final String SERVER = "localhost";
	public static final String BASE_URI = "http://%s:%s";
	public static final String CONTAINERS = "containers";
	public static final String CREATE = "create";
	public static final String START = "start";
	public static final String STOP = "stop";
	public static final String JSON = "json";


	public static Container run(String imageName) {
		WebTarget containersBasePath = createBasePath();

		WebTarget createPath = containersBasePath.path(CREATE);

		ContainerSpecification specification = new ContainerSpecification();
		specification.setImage(imageName);

		Response createResponse = createPath.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(specification));
		return createResponse.readEntity(Container.class);
	}

	public static String getIpOfContainer(Container container) {
		WebTarget containersBasePath = createBasePath();

		containersBasePath.path(container.getId()).path(START).request().post(Entity.json(new ContainerRunConfiguration()));

		Response inspectResponse = containersBasePath.path(container.getId()).path(JSON).request().get();
		ContainerConfiguration containerConfiguration = inspectResponse.readEntity(ContainerConfiguration.class);
		return containerConfiguration.getNetworkSettings().getIpAddress();
	}

	public static void stop(Container container) {
		WebTarget containersBasePath = createBasePath();
		containersBasePath.path(container.getId()).path(STOP).request().post(Entity.text(""));
	}

	private static WebTarget createBasePath() {
		Client client = ClientBuilder.newClient();
		client.register(JacksonFeature.class);
		return client.target(String.format(BASE_URI, SERVER, PORT)).path(CONTAINERS);
	}
}
