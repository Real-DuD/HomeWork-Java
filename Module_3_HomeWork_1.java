public class Module_3_HomeWork_1 {
    abstract static class Metal {
        protected int Endurence;
        public int GetEnderence () {
            return this.Endurence;
        }
    }

    static class steel extends Metal{
        public steel() {
            this.Endurence = 50;
        }
    }

    static class iron extends Metal{
        public iron() {
            this.Endurence = 30;
        }
    }
    static class copper extends Metal{
        public copper() {
            this.Endurence = 20;
        }
    }

    static class Plastic {

    }

    public static class Sword <T extends Metal> {
        private final T material;

        public Sword(T material) {
            this.material = material;
        }

        private boolean EndurenceCheck() {
            return this.material.GetEnderence() > 49;
        }
    }

    static class Test {
        public static void main(String[] args) {
            steel ingot_1 = new steel();
            iron ingot_2 = new iron();
            copper ingot_3 = new copper();
            Plastic ingot_4 = new Plastic();

            Sword Sword_1 = new Sword(ingot_1);
            Sword Sword_2 = new Sword(ingot_2);
            Sword Sword_3 = new Sword(ingot_3);




            //Sword Sword_4 = new Sword(ingot_4); (не получается)

            if (Sword_1.EndurenceCheck()) {
                System.out.println("Меч Sword_1 прошёл проверку прочности");
            }
            else {
                System.out.println("Меч Sword_1 не прошёл проверку прочности");
            }

            if (Sword_2.EndurenceCheck()) {
                System.out.println("Меч Sword_2 прошёл проверку прочности");
            }
            else {
                System.out.println("Меч Sword_2 не прошёл проверку прочности");
            }

            if (Sword_3.EndurenceCheck()) {
                System.out.println("Меч Sword_3 прошёл проверку прочности");
            }
            else {
                System.out.println("Меч Sword_3 не прошёл проверку прочности");
            }
        }
    }
}
