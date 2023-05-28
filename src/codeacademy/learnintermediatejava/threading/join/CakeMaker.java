package codeacademy.learnintermediatejava.threading.join;

/**
 * In this class, the method .join() is being used to synchronize thread execution. In this way, several threads
 * can be coordinated so that the program can be sure one thing finalizes before starting another thing.
 *
 */
public class CakeMaker {

    /* Instance Variables */
    private boolean whiskInUse = false;
    private boolean ovenInUse = false;
    private boolean mixingBowlInUse = false;

    /* Main Method
    * In this method, the method .join() is being used to synchronize thread execution. In this way, several threads
    * can be coordinated so that the program can be sure on thing finalizes before starting another thing.
    *
    * */
    public static void main(String[] args) {

        CakeMaker c = new CakeMaker();
        try {

            Thread preheatOven = new Thread(() -> c.preheatOven(), "preheatOven");
            Thread mixDryIngredients = new Thread(() -> c.mixDryIngredients(), "mixDryIngredients");
            Thread mixWetIngredients = new Thread(() -> c.mixWetIngredients(), "mixWetIngredients");
            Thread combineIngredients = new Thread(() -> c.combineIngredients(), "combineIngredients");
            Thread bakeCake = new Thread(() -> c.bakeCake(), "bakeCake");
            Thread makeFrosting = new Thread(() -> c.makeFrosting(), "makeFrosting");
            Thread frostCake = new Thread(() -> c.frostCake(), "frostCake");

            // Add logic to start and initial.join threads here!
            // There should be a .start() and .initial.join() method call for each thread, seven in total.
            // The following constraints should apply:

            // The oven must be preheated before the cake can be baked.
            // The dry ingredients and wet ingredients should be mixed before the ingredients can be combined.
            // The ingredients must be combined before the cake can be baked.
            // The cake must be finished baking before the cake can be frosted.
            preheatOven.start();
            mixDryIngredients.start();
            mixWetIngredients.start();
            mixDryIngredients.join();
            mixWetIngredients.join();
            combineIngredients.start();
            preheatOven.join();
            combineIngredients.join();
            bakeCake.start();
            makeFrosting.start();
            bakeCake.join();
            makeFrosting.join();
            frostCake.start();
            frostCake.join();

            System.out.println("Cake complete!");
        } catch (Exception e) {
            System.out.println(e);
        }
    } // End of Main

    /* Instance Methods */
    public void preheatOven() {
        try {
            printTask("Oven pre-heating...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixDryIngredients() {
        try {
            printTask("Mixing dry ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(200);
            printTask("Adding cake flour");
            Thread.sleep(200);
            printTask("Adding salt");
            Thread.sleep(200);
            printTask("Adding baking powder");
            Thread.sleep(200);
            printTask("Adding baking soda");
            Thread.sleep(200);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(200);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void mixWetIngredients() {

        try {

            printTask("Mixing wet ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(1000);
            printTask("Adding butter...");
            Thread.sleep(500);
            printTask("Adding eggs...");
            Thread.sleep(500);
            printTask("Adding vanilla extract...");
            Thread.sleep(500);
            printTask("Adding buttermilk...");
            Thread.sleep(500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void combineIngredients() {
        try {
            printTask("Combining ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(1000);
            printTask("Adding dry mix to wet mix...");
            Thread.sleep(1500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    };

    public void bakeCake() {
        try {
            printTask("Baking cake...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void makeFrosting() {
        try {
            printTask("Making frosting...");
            whiskInUse = true;
            mixingBowlInUse = true;
            printTask("Adding butter...");
            Thread.sleep(200);
            printTask("Adding milk...");
            Thread.sleep(200);
            printTask("Adding sugar...");
            Thread.sleep(200);
            printTask("Adding vanilla extract...");
            Thread.sleep(200);
            printTask("Adding salt...");
            Thread.sleep(200);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void frostCake() {
        try {
            printTask("Frosting cake...");
            Thread.sleep(1500);
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void printTask(String task) {
        System.out.println(Thread.currentThread().getName() + " " + " - " + task);
    };
}
