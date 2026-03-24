package com.petshop.frontend.controller;

import com.petshop.frontend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // --- Member 1 ---
    @GetMapping("/member1")
    public String member1(Model model) {
        return "member1";
    }

    @GetMapping("/member1/pets")
    public String getPets(Model model) {
        model.addAttribute("dataTitle", "All Pets");
        model.addAttribute("dataList", apiService.getPets());
        return "member1";
    }

    @GetMapping("/member1/pets/{id}")
    public String getPet(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("dataTitle", "Pet Details");
            model.addAttribute("singleData", apiService.getPet(id));
        } catch (Exception e) {
            model.addAttribute("dataTitle", "Error: " + e.getMessage() + " | Cause: " + e.getCause());
        }
        return "member1";
    }

    @GetMapping("/member1/pets/category/{name}")
    public String getPetsByCategory(@PathVariable("name") String name, Model model) {
        try {
            model.addAttribute("dataTitle", "Pets in Category: " + name);
            model.addAttribute("dataList", apiService.getPetsByCategory(name));
        } catch (Exception e) {
            model.addAttribute("dataTitle", "Error: " + e.getMessage() + " | Cause: " + e.getCause());
        }
        return "member1";
    }

    // --- Member 2 ---
    @GetMapping("/member2")
    public String member2(Model model) {
        return "member2";
    }

    @GetMapping("/member2/customers")
    public String getCustomers(Model model) {
        model.addAttribute("dataTitle", "All Customers");
        model.addAttribute("dataList", apiService.getCustomers());
        return "member2";
    }

    @GetMapping("/member2/customers/{id}")
    public String getCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dataTitle", "Customer Details");
        model.addAttribute("singleData", apiService.getCustomer(id));
        return "member2";
    }

    // --- Member 3 ---
    @GetMapping("/member3")
    public String member3(Model model) {
        return "member3";
    }

    @GetMapping("/member3/customers/{id}/transactions")
    public String getTransactions(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dataTitle", "Transactions for Customer " + id);
        model.addAttribute("dataList", apiService.getCustomerTransactions(id));
        return "member3";
    }

    @GetMapping("/member3/transactions")
    public String getAllTransactions(Model model) {
        model.addAttribute("dataTitle", "All Transactions");
        model.addAttribute("dataList", apiService.getAllTransactions());
        return "member3";
    }

    // --- Member 4 ---
    @GetMapping("/member4")
    public String member4(Model model) {
        return "member4";
    }

    @GetMapping("/member4/pets/{id}/grooming")
    public String getGrooming(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dataTitle", "Grooming Services for Pet " + id);
        model.addAttribute("dataList", apiService.getPetGroomingServices(id));
        return "member4";
    }

    @GetMapping("/member4/pets/{id}/vaccinations")
    public String getVaccinations(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dataTitle", "Vaccinations for Pet " + id);
        model.addAttribute("dataList", apiService.getPetVaccinations(id));
        return "member4";
    }

    @GetMapping("/member4/grooming")
    public String getAllGrooming(Model model) {
        model.addAttribute("dataTitle", "All Grooming Services");
        model.addAttribute("dataList", apiService.getAllGroomingServices());
        return "member4";
    }

    @GetMapping("/member4/vaccinations")
    public String getAllVaccinations(Model model) {
        model.addAttribute("dataTitle", "All Vaccinations");
        model.addAttribute("dataList", apiService.getAllVaccinations());
        return "member4";
    }

    @PostMapping("/member4/grooming/add")
    public String addGrooming(@RequestParam Map<String, Object> payload) {
        apiService.addGroomingService(payload);
        return "redirect:/member4";
    }

    @PostMapping("/member4/vaccinations/add")
    public String addVaccination(@RequestParam Map<String, Object> payload) {
        apiService.addVaccination(payload);
        return "redirect:/member4";
    }

    // --- Member 5 ---
    @GetMapping("/member5")
    public String member5(Model model) {
        return "member5";
    }

    @GetMapping("/member5/food")
    public String getFood(Model model) {
        model.addAttribute("dataTitle", "Pet Food Inventory");
        model.addAttribute("dataList", apiService.getFood());
        return "member5";
    }

    @GetMapping("/member5/suppliers")
    public String getSuppliers(Model model) {
        model.addAttribute("dataTitle", "All Suppliers");
        model.addAttribute("dataList", apiService.getSuppliers());
        return "member5";
    }

    @GetMapping("/member5/employees")
    public String getEmployees(Model model) {
        model.addAttribute("dataTitle", "All Employees");
        model.addAttribute("dataList", apiService.getEmployees());
        return "member5";
    }

    @GetMapping("/member5/food/{id}")
    public String getFoodById(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("dataTitle", "Food Details");
            model.addAttribute("singleData", apiService.getFood(id));
        } catch (Exception e) {
            model.addAttribute("dataTitle", "Error: Food not found.");
        }
        return "member5";
    }

    @GetMapping("/member5/suppliers/{id}")
    public String getSupplierById(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("dataTitle", "Supplier Details");
            model.addAttribute("singleData", apiService.getSupplier(id));
        } catch (Exception e) {
            model.addAttribute("dataTitle", "Error: Supplier not found.");
        }
        return "member5";
    }

    @GetMapping("/member5/employees/{id}")
    public String getEmployeeById(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("dataTitle", "Employee Details");
            model.addAttribute("singleData", apiService.getEmployee(id));
        } catch (Exception e) {
            model.addAttribute("dataTitle", "Error: Employee not found.");
        }
        return "member5";
    }

    @PostMapping("/member5/food/add")
    public String addFood(@RequestParam Map<String, Object> payload) {
        // Convert quantity and price to correct types if necessary, though RestTemplate with JSON map usually handles strings fine if backend allows, or we parse it
        // The backend uses @RequestBody PetFood, Jackson binds strings "10" to Integer 10.
        apiService.addPetFood(payload);
        return "redirect:/member5";
    }

    @PostMapping("/member5/suppliers/add")
    public String addSupplier(@RequestParam Map<String, Object> payload) {
        Map<String, Object> address = new java.util.HashMap<>();
        if (payload.containsKey("street") && !payload.get("street").toString().isEmpty()) {
            address.put("street", payload.remove("street"));
        }
        if (payload.containsKey("city") && !payload.get("city").toString().isEmpty()) {
            address.put("city", payload.remove("city"));
        }
        if (payload.containsKey("state") && !payload.get("state").toString().isEmpty()) {
            address.put("state", payload.remove("state"));
        }
        if (payload.containsKey("zipCode") && !payload.get("zipCode").toString().isEmpty()) {
            address.put("zipCode", payload.remove("zipCode"));
        }
        if (!address.isEmpty()) {
            payload.put("address", address);
        }
        apiService.addSupplier(payload);
        return "redirect:/member5";
    }
}
