package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private TerritoryDao territoryDao;

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private NationDao nationDao;

    @Autowired
    private UnitDao unitDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("nations", nationDao.findAll());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("title", "My Country");

        return "cheese/index";
    }


    /*@RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid Cheese newCheese,
                                       Errors errors,
                                       @RequestParam int categoryId,
                                       Model model) {
        Category cat = categoryDao.findOne(categoryId);
        newCheese.setCategory(cat);


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }


        cheeseDao.save(newCheese);
        return "redirect:";
    }*/

    @RequestMapping(value = "update-stats", method = RequestMethod.GET)
//    @ModelAttribute("messages")
//    public List<Nation> getNations() {
//        return nationDao.findAll();
//    }
    public String displayUpdateStatsForm(Model model) {
        model.addAttribute("title", "Update Stats");
        model.addAttribute("nation", nationDao.findAll());
        model.addAttribute("resource", resourceDao.findAll());
        model.addAttribute("territory", territoryDao.findAll());
        model.addAttribute("city", cityDao.findAll());
        return "/update-stats";
    }
//
@RequestMapping(value = "update-stats", method = RequestMethod.POST)
public String processUpdateStatsForm(@ModelAttribute  @Valid Nation nation, Territory territory, Resource resource, City city,
                                   Errors errors,
                                   Model model) {


    if (errors.hasErrors()) {
        model.addAttribute("title", "Update Stats");
        return "cheese/update-stats";
    }

        territoryDao.save(territory);
        cityDao.save(city);
        resourceDao.save(resource);
        nationDao.save(nation);
        return "cheese/index";
    }



    /*@RequestMapping(value = "update-stats", method = RequestMethod.GET)
    public String displayUpdateStatsForm(Model model) {
        model.addAttribute("title", "Update Stats");
        model.addAttribute("nations", nationDao.findAll());
        return "update-stats";
    }


    @RequestMapping(value = "update-stats", method = RequestMethod.POST)
    public String processUpdateStatsForm(Model model, @RequestParam int[] nationIds) {
        final Iterable<Nation> nations = nationDao.findAll();
        model.addAttribute("nations", nationDao.findAll());
        model.addAttribute("title", "Update Cheese");

        for (int oneNation : nationIds) {
            model.addAttribute("nations", nationDao.findOne(oneNation));
            /*final Cheese cheese = cheeseDao.findOne(oneCheese);*/
        //}
        //return "cheese/index";
    //}

    /*@RequestMapping(value = "edit", method = RequestMethod.GET)
    public String displayEditCheeseForm(Model model) {
        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/edit";
    }

    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditUpdateCheeseForm(Model model, @RequestParam int[] cheeseIds) {
        final Iterable<Cheese> cheeses = cheeseDao.findAll();
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Update Cheese");

        for (int oneCheese : cheeseIds) {
            model.addAttribute("cheeses", cheeseDao.findOne(oneCheese));

        }
        return "cheese/harry";
    }*/


//    @RequestMapping(value = "harry", method = RequestMethod.POST)
//    public String processUpdateDB(@ModelAttribute  @Valid Cheese newCheese,
//                                       Errors errors,
//                                       @RequestParam int categoryId,
//                                       Model model) {
//        Category cat = categoryDao.findOne(categoryId);
//        newCheese.setCategory(cat);
//
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Cheese");
//            return "cheese/harry";
//        }
//
//
//        cheeseDao.save(newCheese);
//        return "redirect:";
//    }

//    @RequestMapping(value = "remove", method = RequestMethod.GET)
//    public String displayRemoveCheeseForm(Model model) {
//        model.addAttribute("cheeses", cheeseDao.findAll());
//        model.addAttribute("title", "Remove Cheese");
//        return "cheese/remove";
//    }


//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveCheeseForm ( @RequestParam int[] cheeseIds){
//        final Iterable<Menu> menus = menuDao.findAll();
//
//        for (int cheeseId : cheeseIds) {
//            final Cheese cheese = cheeseDao.findOne(cheeseId);
//            for (Menu menu : menus) {
//                if (menu.getCheeses().contains(cheese)) {
//                    menu.getCheeses().remove(cheese);
//                    menuDao.save(menu);
//                }
//
//            }
//            for (int someCheese : cheeseIds) {
//                cheeseDao.delete(someCheese);
//            }
//        }
//
//        return "redirect:";
//    }


@RequestMapping(value = "add-new-units", method = RequestMethod.GET)
    public String displayAddNewUnitsForm(Model model) {
        model.addAttribute("title", "Add New Units");
        model.addAttribute(new Unit());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("nations", nationDao.findAll());
        return "/add-new-units";

    }

    @RequestMapping(value = "add-new-units", method = RequestMethod.POST)
    public String processAddNewUnitsForm(@ModelAttribute Unit newUnit, Nation nation,
                                       Errors errors,
                                       Model model) {



        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Units");
            return "/add-new-units";
        }


        unitDao.save(newUnit);
        nationDao.save(nation);
        return "redirect:";
    }


    @RequestMapping(value = "order-production", method = RequestMethod.GET)
    public String displayOrderProductionForm(Model model) {
    model.addAttribute("title", "Order Production");
    model.addAttribute(new Unit());
    model.addAttribute("units", unitDao.findAll());
    model.addAttribute("nations", nationDao.findAll());
    return "/order-production";
    }
}
