package com.petshop.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private final String BASE_URL = "http://localhost:8082/api";

    @Autowired
    private RestTemplate restTemplate;

    // -- Member 1 --
    public List<?> getPets() {
        return restTemplate.getForObject(BASE_URL + "/pets", List.class);
    }
    public Map<?, ?> getPet(Long id) {
        return restTemplate.getForObject(BASE_URL + "/pets/" + id, Map.class);
    }
    public List<?> getPetsByCategory(String name) {
        return restTemplate.getForObject(BASE_URL + "/pets/category/" + name, List.class);
    }

    // -- Member 2 --
    public List<?> getCustomers() {
        return restTemplate.getForObject(BASE_URL + "/customers", List.class);
    }
    public Map<?, ?> getCustomer(Long id) {
        return restTemplate.getForObject(BASE_URL + "/customers/" + id, Map.class);
    }

    // -- Member 3 --
    public List<?> getCustomerTransactions(Long id) {
        return restTemplate.getForObject(BASE_URL + "/transactions/customer/" + id, List.class);
    }
    public List<?> getAllTransactions() {
        return restTemplate.getForObject(BASE_URL + "/transactions", List.class);
    }

    // -- Member 4 --
    public List<?> getPetGroomingServices(Long id) {
        Map<?, ?> services = restTemplate.getForObject(BASE_URL + "/pets/" + id + "/services", Map.class);
        return services != null ? (List<?>) services.get("grooming") : null;
    }
    public List<?> getPetVaccinations(Long id) {
        Map<?, ?> services = restTemplate.getForObject(BASE_URL + "/pets/" + id + "/services", Map.class);
        return services != null ? (List<?>) services.get("vaccinations") : null;
    }
    public List<?> getAllGroomingServices() {
        return restTemplate.getForObject(BASE_URL + "/grooming-services", List.class);
    }
    public List<?> getAllVaccinations() {
        return restTemplate.getForObject(BASE_URL + "/vaccinations", List.class);
    }
    public void addGroomingService(Map<String, Object> payload) {
        restTemplate.postForObject(BASE_URL + "/grooming-services", payload, Map.class);
    }
    public void addVaccination(Map<String, Object> payload) {
        restTemplate.postForObject(BASE_URL + "/vaccinations", payload, Map.class);
    }

    // -- Member 5 --
    public List<?> getFood() {
        return restTemplate.getForObject(BASE_URL + "/pet-food", List.class);
    }
    public List<?> getSuppliers() {
        List<Map<String, Object>> list = restTemplate.getForObject(BASE_URL + "/suppliers", List.class);
        if (list != null) {
            list.forEach(this::formatSupplierAddress);
        }
        return list;
    }
    public List<?> getEmployees() {
        return restTemplate.getForObject(BASE_URL + "/employees", List.class);
    }
    public Map<?, ?> getFood(Long id) {
        return restTemplate.getForObject(BASE_URL + "/pet-food/" + id, Map.class);
    }
    public Map<?, ?> getSupplier(Long id) {
        Map<String, Object> supplier = restTemplate.getForObject(BASE_URL + "/suppliers/" + id, Map.class);
        if (supplier != null) {
            formatSupplierAddress(supplier);
        }
        return supplier;
    }
    public Map<?, ?> getEmployee(Long id) {
        return restTemplate.getForObject(BASE_URL + "/employees/" + id, Map.class);
    }
    public void addPetFood(Map<String, Object> payload) {
        restTemplate.postForObject(BASE_URL + "/pet-food", payload, Map.class);
    }
    public void addSupplier(Map<String, Object> payload) {
        restTemplate.postForObject(BASE_URL + "/suppliers", payload, Map.class);
    }

    @SuppressWarnings("unchecked")
    private void formatSupplierAddress(Map<String, Object> item) {
        if (item.containsKey("address") && item.get("address") instanceof Map) {
            Map<String, Object> address = (Map<String, Object>) item.get("address");
            String street = address.get("street") != null ? address.get("street").toString() : "";
            String city = address.get("city") != null ? address.get("city").toString() : "";
            String state = address.get("state") != null ? address.get("state").toString() : "";
            String zipCode = address.get("zipCode") != null ? address.get("zipCode").toString() : "";
            
            String formatted = String.format("%s, %s, %s %s", street, city, state, zipCode).trim();
            // clean up leading/trailing spaces and commas
            formatted = formatted.replaceAll("^[,\\s]+|[,\\s]+$", "").replaceAll(",\\s*,", ", ").replaceAll("\\s+", " ").trim();
            if (formatted.isEmpty() || formatted.equals(",")) {
                formatted = "No Address Provided";
            }
            item.put("address", formatted);
        }
    }
}
