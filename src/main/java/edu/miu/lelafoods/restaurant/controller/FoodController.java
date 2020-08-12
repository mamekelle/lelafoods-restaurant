package edu.miu.lelafoods.restaurant.controller;

import edu.miu.lelafoods.restaurant.domain.Food;
import edu.miu.lelafoods.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping({"","/all"})
    public List<Food> findAll(){
        List<Food> foodList =  foodService.findAll();
        return foodList;
    }

    @GetMapping("{id}")
    public Food findFoodById(@PathVariable("id")Long id){
        return foodService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void  addFood(@RequestBody Food food){
        foodService.save(food);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        foodService.deleteById(id);
    }
}
