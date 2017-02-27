package _06_RawData;

 class Cargo {
     public String getType() {
         return this.type;
     }

     private String type;
     private int weight;

     public Cargo(String type, int weight) {
         this.type = type;
         this.weight = weight;
     }
 }
