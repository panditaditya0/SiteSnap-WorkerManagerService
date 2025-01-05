package com.freerender.WorkerManager.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freerender.WorkerManager.dto.SwarmDtos.*;
import com.freerender.WorkerManager.services.ContainerOrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class SwarmService implements ContainerOrchestrationService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${swarm.api.url}")
    private String apiUrl;

    @Value("${swarm.api.token}")
    private String token;

    @Value("${worker.service.name}")
    private String workerServiceName;

    String endpoint = "services";

    @Override
    public <T> Object[] getAllServices() {
        try {
            ResponseEntity<String> response = this.servicesApi(apiUrl + endpoint, HttpMethod.GET, new Object());
            ServiceDTO[] services = new ObjectMapper()
                    .readValue(response.getBody().toString(), ServiceDTO[].class);

            return services;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> Object serviceInfo(T service) {
        try {
            ServiceDTO[] services = (ServiceDTO[]) this.getAllServices();
            List<ServiceDTO> listOfServices = List.of(services);
            ServiceDTO servicek = listOfServices.stream()
                    .filter(s -> "stage-cache-website".equals(s.serviceName))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Service not found"));

            String serviceId = servicek.id;
            ResponseEntity<String> response = this.servicesApi(apiUrl + "services/" + serviceId, HttpMethod.GET, new Object());
            ServiceDTO aService = new ObjectMapper()
                    .readValue(response.getBody(), ServiceDTO.class);
            return aService;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> Object updateService(T oldService) {
        ServiceDTO old = (ServiceDTO) oldService;

        EditServiceDto editServiceDto = new EditServiceDto();
//        editServiceDto.setAgent(false);
        editServiceDto.setConfigs(new ArrayList<>());
        editServiceDto.setCommand(new ArrayList<>());
        ArrayList<Host> hosts = new ArrayList<Host>();
        hosts.add(new Host("host", "0.0.0.0"));
        editServiceDto.setHosts(hosts);
        editServiceDto.setImmutable(true);
        editServiceDto.setUser("");
        editServiceDto.setContainerLabels(new ArrayList<>());
        editServiceDto.setLogdriver(new LogDriver("", new ArrayList<>()));
        editServiceDto.setTty(true);
        editServiceDto.setRepository(new Repository("nexus.ppustage.dev/cachewebsite-service",
                "20aa6ea",
                "nexus.ppustage.dev/cachewebsite-service:20aa6ea",
                "sha256:03cfdd293ee9eb8f32b0e2d260e77a4be033845e5d5b5742b6e4a056594fd10b"));

        editServiceDto.setNetworks(new ArrayList<>());
        editServiceDto.setMode("replicated");
        editServiceDto.setLabels(new ArrayList<>());
        editServiceDto.setMounts(new ArrayList<>());
        editServiceDto.setServiceName("stage-cache-website");

        Deployment deployment = new Deployment();
        deployment.setUpdate(new Update(1, 0, "stop-first", "pause"));
        deployment.setRollback(new Rollback(1, 0, "stop-first", "pause"));
        deployment.setForceUpdate(0);
        deployment.setRollbackAllowed(false);
        deployment.setAutoredeploy(false);
        deployment.setRestartPolicy(new RestartPolicy("any", 5, 0, 0));


        ArrayList<Placement> placement = new ArrayList<>();
        placement.add(new Placement("node.hostname == master-node"));
        deployment.setPlacement(placement);
        editServiceDto.setDeployment(deployment);

        ArrayList<String> test = new ArrayList();
        test.add("");
        editServiceDto.setHealthcheck(new Healthcheck(test, 0, 0, 0));
        editServiceDto.setDir("");

        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(new Variable("SELENIUM_HUB_URL", "http://localhost:4444/wd/hub"));
        editServiceDto.setVariables(variables);

        editServiceDto.setLinks(new ArrayList<>());
        editServiceDto.setVersion(Integer.valueOf(old.version));
        editServiceDto.setReplicas(old.replicas);
        editServiceDto.setSecrets(new ArrayList<>());
        editServiceDto.setResources(new Resources(new Reservation(0, 0),
                new Limit(0, 0)));

        ArrayList<Port> ports = new ArrayList<>();
        ports.add(new Port(80, "tcp", "ingress", 8085));
        ports.add(new Port(4444, "tcp", "ingress", 4499));
        editServiceDto.setPorts(ports);
        editServiceDto.setStack("");

        ResponseEntity<String> response = this.servicesApi(apiUrl + "services/" + old.id, HttpMethod.POST, editServiceDto);
        return response;
    }

    @Override
    public <T> T deleteService(T service) {
        return null;
    }

    @Override
    public <T> Object createService(T service) {
        CreateServiceDto newService = new CreateServiceDto();
        newService.setConfigs(new ArrayList<>());
        newService.setCommand(new ArrayList<>());
        newService.setMode("replicated");

        ArrayList<Host> hosts = new ArrayList<>();
        hosts.add(new Host("host", "0.0.0.0"));
        newService.setHosts(hosts);

        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(new Variable("SELENIUM_HUB_URL", "http://localhost:4444/wd/hub"));
        newService.setVariables(variables);

        newService.setLogdriver(new LogDriver("", new ArrayList<>()));

        newService.setRepository(new Repository("nexus.ppustage.dev/cachewebsite-service",
                "20aa6ea",
                "nexus.ppustage.dev/cachewebsite-service:20aa6ea",
                "sha256:03cfdd293ee9eb8f32b0e2d260e77a4be033845e5d5b5742b6e4a056594fd10b"));

        newService.setNetworks(new ArrayList<>());
        newService.setLabels(new ArrayList<>());
        newService.setMounts(new ArrayList<>());

        newService.setServiceName("stage-cache-website");

        Deployment deployment = new Deployment();
        deployment.setUpdate(new Update(1, 0, "stop-first", "pause"));
        deployment.setRollback(new Rollback(1, 0, "stop-first", "pause"));
        deployment.setForceUpdate(0);
        deployment.setRollbackAllowed(false);
        deployment.setAutoredeploy(false);
        deployment.setRestartPolicy(new RestartPolicy("any", 5, 0, 0));

        ArrayList<Placement> placements = new ArrayList<>();
        placements.add(new Placement("node.hostname == master-node"));
        deployment.setPlacement(placements);

        newService.setDeployment(deployment);
        newService.setReplicas(1);
        newService.setSecrets(new ArrayList<>());
        newService.setResources(new Resources(new Reservation(0, 0),
                new Limit(0, 0)));

        ArrayList<Port> ports = new ArrayList<>();
        ports.add(new Port(80, "tcp", "ingress", 8085));
        ports.add(new Port(4444, "tcp", "ingress", 4499));
        newService.setPorts(ports);

        ResponseEntity<String> response = this.servicesApi(apiUrl + "services", HttpMethod.POST, newService);
        return response;
    }

    private ResponseEntity<String> servicesApi(String url, HttpMethod method, Object serviceData) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Object> entity = method == HttpMethod.GET ? new HttpEntity<>(headers) : new HttpEntity<>(serviceData, headers);
        return restTemplate.exchange(url, method, entity, String.class);
    }
}