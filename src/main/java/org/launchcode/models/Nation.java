package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
//@Table(name = "nation")
public class Nation {

    public String name;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int id;

    private String governmentType;

    private String leader;

    private int totalProduction;

    private int totalPopulation;

    private int totalManpower;

    @OneToMany
    @JoinColumn (name = "city_id")
    private List<City> cities;

    @OneToMany
    @JoinColumn (name = "resource_id")
    private List<Resource> resources;

    @OneToMany
    @JoinColumn (name = "territory_id")
    private List<Territory> territories;

    @OneToMany
    private List<Unit> units;

    public Nation() {
    }

    public Nation(String name, int id, String governmentType, String leader, int totalProduction, int totalPopulation, int totalManpower, List<City> cities, List<Resource> resources, List<Territory> territories, List<Unit> units) {
        this.name = name;
        this.id = id;
        this.governmentType = governmentType;
        this.leader = leader;
        this.totalProduction = totalProduction;
        this.totalPopulation = totalPopulation;
        this.totalManpower = totalManpower;
        this.cities = cities;
        this.resources = resources;
        this.territories = territories;
        this.units = units;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public String getLeader() {
        return leader;
    }

    public int getTotalProduction() {

        return totalProduction;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public int getTotalManpower() {
        return totalManpower;
    }

    public List<City> getCities() {
        return cities ;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public void setTotalManpower(int totalManpower) {
        this.totalManpower = totalManpower;
    }

    public void setCities(City cities) {
        this.cities.add(cities);
    }

    public void setResources(Resource resources) {
        this.resources.add(resources);
    }

    public void setTerritories(Territory territories) {
        this.territories.add(territories);
    }

    public void setUnits(Unit units) {
        this.units.add(units);
    }
}
