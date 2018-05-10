package com.ucbcba.demo.Controllers;

import com.ucbcba.demo.Entities.City;
import com.ucbcba.demo.Entities.Restaurant;

import com.ucbcba.demo.Entities.User;
import com.ucbcba.demo.services.CityService;
import com.ucbcba.demo.services.RestaurantService;
import com.ucbcba.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {
    private RestaurantService restaurantService;
    private CityService cityService;
    private UserService userService;
    private String actualRole = "client";

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }
    @Autowired
    public void setCityService(CityService cityService){
        this.cityService = cityService;
    }
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("cities", cityService.listAllCities());
        return "home";
    }
    @RequestMapping("/newRestaurant")
    String newRestaurant(Model model) {
        model.addAttribute("cities", cityService.listAllCities());
        return "newRestaurant";
    }

    @RequestMapping("/restaurants")
    String list(Model model) {
        model.addAttribute("actualRole", this.actualRole);
        model.addAttribute("restaurants", restaurantService.listAllRestaurants());
        return "restaurants";
    }

    @RequestMapping("/deleteRestaurant/{id}")
    String delete(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return "redirect:/restaurants";

    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    String save(Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/restaurants";
    }

    @RequestMapping("/editRestaurant/{id}")
    String editRestaurant(@PathVariable Integer id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        Iterable<City> cities = cityService.listAllCities();
        model.addAttribute("cities", cities);
        return "editRestaurant";
    }

    @RequestMapping("/showRestaurant/{id}")
    String showRestaurant(@PathVariable Integer id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        model.addAttribute("restaurant", restaurant);
        return "showRestaurant";
    }

    public void setActualRole(String actualRole) {
        this.actualRole = actualRole;
    }
}
