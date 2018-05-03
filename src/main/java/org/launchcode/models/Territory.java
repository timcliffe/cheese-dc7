package org.launchcode.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Territory {

    public Territory(String climateType, int quantity, int populationBonus) {
        this.climateType = climateType;
        this.quantity = quantity;
        this.populationBonus = populationBonus;
    }

    public Territory() {
    }

    private String climateType;


    public String name;

    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    private int populationBonus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getClimateType() {
        return climateType;
    }

    public void setClimateType(String climateType) {
        this.climateType = climateType;
    }

    public int getPopulationBonus() {
        return populationBonus;
    }

    public void setPopulationBonus(int populationBonus) {
        this.populationBonus = populationBonus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

//    public class Tundra extends Territory {
//        private int populationBonus = 1000;
//        private String category = "Colds";
//
//        public Tundra(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Subarctic extends Territory {
//        private int populationBonus = 10000;
//        private String category = "Colds";
//
//        public Subarctic(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Continental extends Territory {
//        private int populationBonus = 75000;
//        private String category = "Temperates";
//
//        public Continental(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Oceanic extends Territory {
//        private int populationBonus = 75000;
//        private String category = "Temperates";
//
//        public Oceanic(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Mediterranean extends Territory {
//        private int populationBonus = 75000;
//        private String category = "Temperates";
//
//        public Mediterranean(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Subtropical extends Territory {
//        private int populationBonus = 75000;
//        private String category = "Temperates";
//
//        public Subtropical(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Jungle extends Territory {
//        private int populationBonus = 75000;
//        private String category = "Hots";
//
//        public Jungle(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Savannah extends Territory {
//        private int populationBonus = 60000;
//        private String category = "Hots";
//
//        public Savannah(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Steppe extends Territory {
//        private int populationBonus = 20000;
//        private String category = "Arids";
//
//        public Steppe(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Semiarid extends Territory {
//        private int populationBonus = 10000;
//        private String category = "Arids";
//
//        public Semiarid(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Desert extends Territory {
//        private int populationBonus = 1000;
//        private String category = "Arids";
//
//        public Desert(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Highland extends Territory {
//        private int populationBonus =  20000;
//        private String category = "Other";
//
//        public Highland(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Marsh extends Territory {
//        private int populationBonus = 10000;
//        private String category = "Other";
//
//        public Marsh(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//
//    public class Icecap extends Territory {
//        private int populationBonus = 0;
//        private String category = "Other";
//
//        public Icecap(String climateType, int quantity, int populationBonus, int populationBonus1, String category) {
//            super(climateType, quantity, populationBonus);
//            this.populationBonus = populationBonus1;
//            this.category = category;
//        }
//    }
//}
