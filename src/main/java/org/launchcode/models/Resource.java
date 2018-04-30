package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Resource {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String type;

    private int quantity;

    private int productionBonus = 50;

    public Resource() {
    }

    public Resource(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.productionBonus = productionBonus;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductionBonus() {
        return productionBonus;
    }

    public void setProductionBonus(int productionBonus) {
        this.productionBonus = productionBonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public class Oil extends Resource {
        private int productionBonus = 200;
        private String type = "Strategic";

        public Oil(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }

    }

    public class Iron extends Resource {
        private int productionBonus = 150;
        private String type = "Strategic";

        public Iron(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class Coal extends Resource {
        private int productionBonus = 150;
        private String type = "Strategic";

        public Coal(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class Aluminum extends Resource {
        private int productionBonus = 125;
        private String type = "Strategic";

        public Aluminum(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class Timber extends Resource {
        private int productionBonus = 100;
        private String type = "Strategic";

        public Timber(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class Helium extends Resource {
        private int productionBonus = 125;
        private String type = "Commercial";

        public Helium(int id, String name, int quantity, int productionBonus) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
        }
    }

    public class Opium extends Resource {
        private int productionBonus = 75;
        private String type = "Commercial";

        public Opium(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class luxuryMinerals extends Resource {
        private int productionBonus = 75;
        private String type = "Commercial";

        public luxuryMinerals(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class cashCrops extends Resource {
        private int productionBonus = 75;
        private String type = "Commercial";

        public cashCrops(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

    public class Food extends Resource {
        private int productionBonus = 50;
        private String type = "Commercial";

        public Food(int id, String name, int quantity, int productionBonus, String type) {
            super(id, name, quantity);
            this.productionBonus = productionBonus;
            this.type = type;
        }
    }

}
