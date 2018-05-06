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
    public String index(Model model, Resource Resource) {

        model.addAttribute("nations", nationDao.findAll());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("resources", resourceDao.findAll());
        model.addAttribute("territories", territoryDao.findAll());
        model.addAttribute("cities", cityDao.findAll());
        model.addAttribute("title", "My Country");

        return "cheese/index";
    }



    @RequestMapping(value = "update-stats", method = RequestMethod.GET)
    public String displayUpdateStatsForm(Model model) {
        model.addAttribute("title", "Update Stats");
        model.addAttribute("nations", nationDao.findAll());
        model.addAttribute("resources", resourceDao.findAll());
        model.addAttribute("territories", territoryDao.findAll());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("cities", cityDao.findAll());
        return "/update-stats";
    }
//
    @RequestMapping(value = "update-stats", method = RequestMethod.POST)
    public String processUpdateStatsForm(@ModelAttribute  @Valid Nation nation,
                                       Errors errors, @RequestParam int nationId, int[] resourceIds, int[] resourceQty,
                                         int[] productionBonus, int[]territoryIds, int[] territoryQuantity, int[] cityProductionBonus,
                                         int[] cityIds, int[] industrialTier, int[] residentialTier, int[] populationBonus, int[] cityPopulationBonus,
                                       Model model) {


        model.addAttribute("nation", nationDao.findOne(nationId));
        int resourceQtyIdx = 0;
        int resourceTotal = 0;
        for (int resourceId : resourceIds ) {
            model.addAttribute("resource", resourceDao.findOne(resourceId));
            Resource resource = resourceDao.findOne(resourceId);
            int tempQuantity = resourceQty[resourceQtyIdx];
            resource.setQuantity(tempQuantity);
            int resourceBonuses = resourceQty[resourceQtyIdx] * productionBonus[resourceQtyIdx];
            resourceTotal = resourceTotal + resourceBonuses;
            resourceDao.save(resource);
            resourceQtyIdx++;
        }
        int territoryQtyIdx = 0;
        int territoryPopulations = 0;
        for (int territoryId : territoryIds ) {
            model.addAttribute("territory", territoryDao.findOne(territoryId));
            Territory territory = territoryDao.findOne(territoryId);
            int tempQuantity = territoryQuantity[territoryQtyIdx];
            territory.setQuantity(tempQuantity);
            int territoryTotals = territoryQuantity[territoryQtyIdx] * populationBonus[territoryQtyIdx];
            territoryPopulations = territoryPopulations + territoryTotals;
            territoryDao.save(territory);
            territoryQtyIdx++;
        }
        int cityTotal = 0;
        int cityTierIdx = 0;
        int cityPopulation = 0;
        for (int cityId : cityIds ) {
            model.addAttribute("city", cityDao.findOne(cityId));
            City city = cityDao.findOne(cityId);
            int tempIndustrial = industrialTier[cityTierIdx];
            int tempResidential = residentialTier[cityTierIdx];
            int cityProduction = industrialTier[cityTierIdx] * 225;
            city.setProductionBonus(cityProduction);
            cityTotal = cityTotal + cityProduction;
            if (tempResidential == 0) {
                city.setPopulationBonus(0);
            }
            if (tempResidential == 1) {
                city.setPopulationBonus(1000000);
            }
            if (tempResidential == 2) {
                city.setPopulationBonus(3000000);
            }
            if (tempResidential == 3) {
                city.setPopulationBonus(7000000);
            }
            if (tempResidential == 4) {
                city.setPopulationBonus(14000000);
            }
            cityPopulation = cityPopulation + cityPopulationBonus[cityTierIdx];
            city.setIndustrialTier(tempIndustrial);
            city.setResidentialTier(tempResidential);
            cityDao.save(city);
            cityTierIdx++;
        }

        int totalNationProduction = cityTotal + resourceTotal;
        nation.setTotalProduction(totalNationProduction);

        int totalNationalPopulation = cityPopulation + territoryPopulations;
        nation.setTotalPopulation(totalNationalPopulation);
        double militaryManpower = totalNationalPopulation * 0.01;
        nation.setTotalManpower(militaryManpower);

        nation.id = nationId;
        nationDao.save(nation);



        if (errors.hasErrors()) {
            model.addAttribute("title", "Error");
            return "cheese/index";
        }
        model.addAttribute("resources", resourceDao.findAll());
        model.addAttribute("cities", cityDao.findAll());
        model.addAttribute("territories", territoryDao.findAll());
        model.addAttribute("nations", nationDao.findAll());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("title", "My Country");

        return "cheese/index";
            }



@RequestMapping(value = "add-new-units", method = RequestMethod.GET)
    public String displayAddNewUnitsForm(Model model) {
        model.addAttribute("title", "Add New Units");
        model.addAttribute(new Unit());
        model.addAttribute("units", unitDao.findAll());
        model.addAttribute("nations", nationDao.findAll());
        return "/add-new-units";

    }

    @RequestMapping(value = "add-new-units", method = RequestMethod.POST)
    public String processAddNewUnitsForm(@ModelAttribute Unit unit, Nation nation,
                                       Errors errors,
                                       Model model) {



        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Units");
            return "/add-new-units";
        }


        unitDao.save(unit);
//        nationDao.save(nation);
        return "redirect:";
    }


    @RequestMapping(value = "order-production", method = RequestMethod.GET)
    public String displayOrderProductionForm(Model model) {
    model.addAttribute("title", "Order Production");
    model.addAttribute("units", unitDao.findAll());
    model.addAttribute("nations", nationDao.findAll());
    return "/order-production";
    }



    @RequestMapping(value = "order-production", method = RequestMethod.POST)
    public String processOrderProductionForm(@ModelAttribute @Valid Nation nation, Errors errors, Model model, @RequestParam int[] unitIds, int[] unitQuantity) {

        int unitQtyIdx = 0;
        for (int unitId : unitIds) {
            model.addAttribute("units", unitDao.findOne(unitId));
            Unit unit = unitDao.findOne(unitId);
            int tempQuantity = unitQuantity[unitQtyIdx];
            unit.setQuantity(tempQuantity);
            unitDao.save(unit);
            unitQtyIdx++;

        }
        return "cheese/index";
    }


    @RequestMapping(value = "add-new-cities", method = RequestMethod.GET)
    public String displayAddNewCitiesForm(Model model) {
        model.addAttribute("title", "Add New Cities");
        model.addAttribute(new City());
        model.addAttribute("cities", cityDao.findAll());
        model.addAttribute("nations", nationDao.findAll());
        return "/add-new-cities";

    }

    @RequestMapping(value = "add-new-cities", method = RequestMethod.POST)
    public String processAddNewCitiesForm(@ModelAttribute City city, Nation nation,
                                         Errors errors,
                                         Model model) {



        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Cities");
            return "/add-new-cities";
        }


       cityDao.save(city);
//        nationDao.save(nation);
        return "redirect:";
    }}


